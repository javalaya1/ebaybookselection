package com.fis.hooks;

import com.fis.ebay.utils.constantsuitl.FrameworkConstants;
import com.fis.ebay.utils.logutil.LoggerUtility;
import com.fis.ebay.utils.reportsutil.ExtentReportUtil;
import com.fis.ebay.utils.webdriveruitl.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class BaseStepDefinitions {

    protected Logger scenarioLogger;

    private static WebDriver driver;
    private static int scenarioCount = 0;

    // Ensure WebDriver is initialized before running any tests
    @Before("@eBay")
    public void setUpEbay(Scenario scenario) {
        // Initialize Logger for the Scenario
        LoggerUtility.initializeLogger(scenario);
        scenarioLogger = LoggerUtility.getLogger();
        
        // Initialize Extent Reports for eBay
        ExtentReportUtil.initializeEbayExtentReports();
        ExtentReportUtil.createEbayTest(scenario.getName());
        scenarioLogger.debug("Logger for eBay is initialized.");

        // Initialize WebDriver if it's not already done
        initializeDriver();

        scenarioCount++;
        scenarioLogger.info("Started Scenario: {}", scenario.getName());
    }

    private synchronized void initializeDriver() {
        // Ensure that driver is initialized only once
        if (driver == null) {
            try {
                driver = BrowserFactory.initializeDriver(
                        FrameworkConstants.BROWSER_NAME,
                        FrameworkConstants.PROFILE_PATH,
                        FrameworkConstants.IS_HEAD_LESS,
                        FrameworkConstants.USE_GRID
                );
            } catch (MalformedURLException e) {
                throw new RuntimeException("Failed to initialize WebDriver", e);
            }
        }
    }

    @After("@eBay")
    public void tearDownEBay(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioLogger.error("Scenario failed for: {}", scenario.getName());
        } else {
            scenarioLogger.info("Scenario passed: {}", scenario.getName());
        }

        // Flush eBay Reports
        ExtentReportUtil.flushEbayReports();

        // Only close and quit driver if it's initialized
        if (driver != null) {
            driver.quit();  // Ensure to quit WebDriver
            // Set driver to null after quitting to avoid any further use
        }
    }

    @Before("@Coindesk")
    public void setUpCoindesk(Scenario scenario) {
        // Similar setup logic for Coindesk
        LoggerUtility.initializeLogger(scenario);
        scenarioLogger = LoggerUtility.getLogger();
        ExtentReportUtil.initializeCoindeskExtentReports();
        ExtentReportUtil.createCoindeskTest(scenario.getName());
        scenarioLogger.debug("Logger for Coindesk is initialized.");
        scenarioLogger.info("Start Scenario: {}", scenario.getName());
    }

    @After("@Coindesk")
    public void tearDownCoinDesk(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioLogger.error("Scenario failed: {}", scenario.getName());
        } else {
            scenarioLogger.info("{} passed: ", scenario.getName());
        }
        ExtentReportUtil.flushCoindeskReports();
    }

}
