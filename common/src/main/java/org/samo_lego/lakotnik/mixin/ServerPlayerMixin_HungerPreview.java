package org.samo_lego.lakotnik.mixin;

import net.minecraft.network.protocol.game.ClientboundSetHealthPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.food.FoodProperties;
import org.samo_lego.lakotnik.Lakotnik;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiFunction;

import static org.samo_lego.lakotnik.Lakotnik.getUpdateRate;
import static org.samo_lego.lakotnik.Lakotnik.lowHungerEnabled;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin_HungerPreview {

    @Shadow public ServerGamePacketListenerImpl connection;

    @Unique private final ServerPlayer player = (ServerPlayer) (Object) this;

    @Unique private boolean foodInfoSent;

    @Unique private final BiFunction<ServerPlayer, String, Boolean> permissionCheck = Lakotnik.getPlatform()::hasPermission;

    @Inject(method = "doTick", at = @At(value = "TAIL"))
    private void onTick(CallbackInfo ci) {
        if (this.player.tickCount % getUpdateRate() == 0 &&
                this.player.getFoodData().needsFood() &&
                !this.player.isCreative() &&
                !this.player.isSpectator() &&
                permissionCheck.apply(this.player, "lakotnik.hunger_preview")) {
            if (this.foodInfoSent) {
                this.updateFoodLevel(0);
                this.foodInfoSent = false;
            } else if (lowHungerEnabled() || this.player.getFoodData().getFoodLevel() > 6.0f) {
                final FoodProperties foodProperties = this.player.getMainHandItem().getItem().getFoodProperties();

                if (foodProperties != null) {
                    int nutrition = foodProperties.getNutrition();
                    this.updateFoodLevel(nutrition);
                    this.foodInfoSent = true;
                }
            }
        }
    }

    @Unique
    private void updateFoodLevel(int addedNutrition) {
        this.connection.send(
                new ClientboundSetHealthPacket(
                        this.player.getHealth(),
                        this.player.getFoodData().getFoodLevel() + addedNutrition,
                        this.player.getFoodData().getSaturationLevel()
                )
        );
    }
}
