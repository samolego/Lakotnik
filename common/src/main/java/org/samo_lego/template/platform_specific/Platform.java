package org.samo_lego.template.platform_specific;

import net.minecraft.server.level.ServerPlayer;

import java.nio.file.Path;

public abstract class Platform {

    private final Environment environment;

    public Platform() {
        this(Environment.UNKNOWN);
    }

    public Platform(Environment environment) {
        this.environment = environment;
    }

    /**
     * Gets mod loader.
     * @return mod loader type.
     */
    public Environment getEnvironment() {
        return this.environment;
    }

    /**
     * Gets config directory path.
     * @return config directory path.
     */
    public Path getConfigDirectory() {
        return null;
    };

    /**
     * Checks whether player has provided permission.
     * @param player player to check.
     * @param permission permission to check.
     * @return true if player has permission, false otherwise.
     */
    public boolean hasPermission(ServerPlayer player, String permission) {
        return false;
    }


    public enum Environment {
        FABRIC,
        FORGE,
        SPONGE,
        UNKNOWN
    }
}
