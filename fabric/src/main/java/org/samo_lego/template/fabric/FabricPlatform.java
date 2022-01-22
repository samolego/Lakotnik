package org.samo_lego.template.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.level.ServerPlayer;
import org.samo_lego.template.platform_specific.Platform;

import java.nio.file.Path;

public class FabricPlatform extends Platform {
    @Override
    public Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    @Override
    public boolean hasPermission(ServerPlayer player, String permission) {
        return false;
    }
}
