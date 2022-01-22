package org.samo_lego.lakotnik.fabric;

import me.lucko.fabric.api.permissions.v0.Permissions;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.level.ServerPlayer;
import org.samo_lego.lakotnik.platform_specific.Platform;

import java.nio.file.Path;

public class FabricPlatform extends Platform {

    public FabricPlatform() {
        super(Environment.FABRIC);
    }

    @Override
    public Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    @Override
    public boolean hasPermission(ServerPlayer player, String permission) {
        return Permissions.check(player, permission, true);
    }
}
