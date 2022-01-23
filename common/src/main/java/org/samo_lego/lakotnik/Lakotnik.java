package org.samo_lego.lakotnik;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.samo_lego.lakotnik.platform_specific.Platform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class Lakotnik {

    public static final String MOD_ID = "lakotnik";
    public static final Logger LOGGER;
    private static Platform PLATFORM_INSTANCE;
    public static final String PREVIEW_PERMISSION;
    public static final Properties CONFIG = new Properties();
    private static boolean lowHungerEnabled;
    private static int updateRate;

    /**
     * Initializes the mod.
     * @param platform platformer instance
     */
    public static void init(Platform platform) {
        PLATFORM_INSTANCE = platform;
        LOGGER.info("[Lakotnik] Loading Lakotnik mod on " + platform.getEnvironment().toString().toLowerCase(Locale.ROOT) + "...");

        String path = String.valueOf(platform.getConfigPath());
        File configFile = new File(path);
        try {
            if (!configFile.exists()) {
                configFile.getParentFile().mkdirs();
                configFile.createNewFile();
                CONFIG.setProperty("tick_update_rate", "10");
                CONFIG.setProperty("enable_on_low_hunger", "false");
            } else {
                CONFIG.load(new FileInputStream(path));
            }
        } catch (Exception e) {
            LOGGER.error("[Lakotnik] Failed to load config file: ", e);
        }

        // Loading values
        updateRate = Integer.parseInt(CONFIG.getProperty("tick_update_rate", "10"));
        lowHungerEnabled = Boolean.parseBoolean(CONFIG.getProperty("enable_on_low_hunger", "false"));

        try {
            // save the properties to the file
            CONFIG.store(new FileOutputStream(configFile), "Lakotnik Config");
        } catch (IOException e) {
            LOGGER.error("[Lakotnik] Failed to save config file: ", e);
        }
    }

    public static int getUpdateRate() {
        return updateRate;
    }

    public static boolean lowHungerEnabled() {
        return lowHungerEnabled;
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
