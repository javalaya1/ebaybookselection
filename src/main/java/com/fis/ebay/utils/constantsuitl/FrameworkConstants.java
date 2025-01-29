package com.fis.ebay.utils.constantsuitl;

import com.fis.ebay.utils.datareadersutil.PropertiesReader;

public class FrameworkConstants {

    // Framework Paths
    public static final String CONFIG_FILE_PATH = ".\\src\\main\\resources\\config.properties";
    public static final String SCREENSHOTS_PATH = ".\\src\\test\\screenshots";
    public static final String LOG_FILE_PATH = "src/test/logs";

    public static final PropertiesReader PROPERTIES_FILE_READER = new PropertiesReader(CONFIG_FILE_PATH);

    //BROWER related
    public static final String BROWSER_NAME = PROPERTIES_FILE_READER.getProperty("config.browser.name");
    public static final String PROFILE_PATH = PROPERTIES_FILE_READER.getProperty("config.profilepath");

    public static final boolean IS_HEAD_LESS = Boolean.parseBoolean(PROPERTIES_FILE_READER.getProperty("config.isheadless"));
    public static final boolean USE_GRID = Boolean.parseBoolean(PROPERTIES_FILE_READER.getProperty("config.usergrid"));
    public static final String GRID_URL = PROPERTIES_FILE_READER.getProperty("config.grid.url");

    public static final String APP_URL = PROPERTIES_FILE_READER.getProperty("browser.url");


    // API Constants
    public static final String API_BASE_URL = PROPERTIES_FILE_READER.getProperty("api.base.url");
    public static final String API_END_POINT_URL = PROPERTIES_FILE_READER.getProperty("api.endpoint.url");

    // Miscellaneous
    public static final int MAX_RETRY_COUNT = 3;
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd hh-mm-SS";

    // Private constructor to prevent instantiation
    private FrameworkConstants() {
        throw new IllegalStateException("Utility class");
    }
}
