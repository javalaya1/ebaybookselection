package com.fis.ebay.utils.logutil;


import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    // Loggers for Coindesk and eBay
    private static final Logger coindeskLogger = LogManager.getLogger("coindeskLogger");
    private static final Logger ebayLogger = LogManager.getLogger("ebayLogger");
    private static final Logger defaultLogger = LogManager.getLogger(LoggerUtility.class);

    // This will hold the logger for the current scenario
    private static Logger scenarioLogger;

    // Method to initialize the logger based on scenario tags
    public static void initializeLogger(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@Coindesk")) {
            scenarioLogger = coindeskLogger;  // Use Coindesk logger
        } else if (scenario.getSourceTagNames().contains("@eBay")) {
            scenarioLogger = ebayLogger;  // Use eBay logger
        } else {
            scenarioLogger = defaultLogger;  // Default logger
        }

        // Log the tags (optional)
        scenarioLogger.info("Running scenario with tags: " + scenario.getSourceTagNames());
    }

    // Get the logger for the current scenario
    public static Logger getLogger() {
        return scenarioLogger != null ? scenarioLogger : defaultLogger;
    }
}
