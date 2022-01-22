package org.samo_lego.lakotnik.sponge;

import net.minecraft.server.level.ServerPlayer;
import org.samo_lego.lakotnik.platform_specific.Platform;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.plugin.PluginContainer;

import java.nio.file.Path;

public class SpongePlatform extends Platform {
    private final PluginContainer container;

    public SpongePlatform(PluginContainer container) {
        super(Environment.SPONGE);
        this.container = container;
    }

    @Override
    public boolean hasPermission(ServerPlayer player, String permission) {
        return ((Subject) player).hasPermission(permission);
    }

    @Override
    public Path getConfigDirectory() {
        return Sponge.configManager().pluginConfig(this.container).configPath();
    }
}
