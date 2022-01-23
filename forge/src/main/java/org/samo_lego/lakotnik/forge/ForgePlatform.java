package org.samo_lego.lakotnik.forge;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.loading.FMLPaths;
import org.samo_lego.lakotnik.platform_specific.Platform;

import java.nio.file.Path;

import static org.samo_lego.lakotnik.Lakotnik.MOD_ID;

public class ForgePlatform extends Platform {

    public ForgePlatform() {
        super(Environment.FORGE);
    }

    @Override
    public Path getConfigPath() {
        return Path.of(FMLPaths.CONFIGDIR.get() + "/" + MOD_ID+ "/" + this.getConfigName());
    }

    @Override
    public boolean hasPermission(ServerPlayer player, String permission) {
        return true;//PermissionAPI.getPermission(player, new PermissionNode<>(permission));
    }
}
