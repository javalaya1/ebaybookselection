package com.fis.ebay.utils.reportsutil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LogUtil {

    public static Logger getLogger(Class<?> clazz, String configFileName) {
        Configurator.initialize(null, ".\\src\\main\\resources\\" + configFileName);
        return LogManager.getLogger(clazz);
    }

}