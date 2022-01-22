package org.samo_lego.template;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.samo_lego.template.platform_specific.Platform;

public class Template {

    public static final String MOD_ID = "template";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    private static Platform PLATFORM_INSTANCE;

    /**
     * Initializes the mod.
     * @param platform platformer instance
     */
    public static void init(Platform platform) {
        PLATFORM_INSTANCE = platform;
        LOGGER.info("Hello World!");
    }
    
    /**
     * Gets the platform instance.
     * @return platform instance.
     */
    public static Platform getPlatform() {
        return PLATFORM_INSTANCE;
    }

    /**
     * Called on command registration.
     * @param dispacther dispatcher to register commands to.
     * @param dedicated whether the server is dedicated or not.
     */
    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispacther, boolean dedicated) {

    }
}
