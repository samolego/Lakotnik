package org.samo_lego.lakotnik;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.samo_lego.lakotnik.platform_specific.Platform;

public class Lakotnik {

    public static final String MOD_ID = "lakotnik";
    public static final Logger LOGGER;
    private static Platform PLATFORM_INSTANCE;
    public static final String PREVIEW_PERMISSION;

    /**
     * Initializes the mod.
     * @param platform platformer instance
     */
    public static void init(Platform platform) {
        PLATFORM_INSTANCE = platform;
        LOGGER.info("Loading Lakotnik mod on " + platform.getEnvironment());
    }
    
    /**
     * Gets the platform instance.
     * @return platform instance.
     */
    public static Platform getPlatform() {
        return PLATFORM_INSTANCE;
    }

    static {
        PREVIEW_PERMISSION = MOD_ID;
        LOGGER = LogManager.getLogger(MOD_ID);
    }
}
