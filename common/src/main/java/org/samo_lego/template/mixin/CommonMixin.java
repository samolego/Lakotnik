package org.samo_lego.template.mixin;

import net.minecraft.client.gui.screens.TitleScreen;
import org.samo_lego.template.Template;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.file.Path;

@Mixin(TitleScreen.class)
public class CommonMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        Template.LOGGER.info("This line is printed by an example mod mixin in COMMON package!");
        Path configDirectory = Template.getPlatform().getConfigDirectory();
        System.out.println(configDirectory);
    }
}
