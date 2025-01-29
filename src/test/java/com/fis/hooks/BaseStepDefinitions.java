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

    //private static final ReentrantLock lock = new ReentrantLock();
    //private static final Semaphore semaphore = new Semaphore(1);

    // Define a variable to track which logger to use
    protected Logger scenarioLogger;

    private static WebDriver driver;
    private static int scenarioCount = 0;

    @Before("@eBay")
    public void setUpEbay(Scenario scenario) {
        LoggerUtility.initializeLogger(scenario);
        scenarioLogger = LoggerUtility.getLogger();
//        lock.lock();
        try {
            // semaphore.acquire();
            // Initialize the eBay Extent Report
            ExtentReportUtil.initializeEbayExtentReports();
            ExtentReportUtil.createEbayTest(scenario.getName());

            // Initialize the logger for eBay with the correct configuration file
            //coindeskLogger = LogUtil.getLogger(Hooks.class, "log4j2-ebay.xml");

            scenarioLogger.debug("Logger for eBay is initialized.");


            try {
                if (driver == null) {
                    synchronized (BaseStepDefinitions.class) {
                        if (driver == null) {
                            driver = BrowserFactory.initializeDriver(FrameworkConstants.BROWSER_NAME, FrameworkConstants.PROFILE_PATH, FrameworkConstants.IS_HEAD_LESS, FrameworkConstants.USE_GRID);
                        }
                    }
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            scenarioCount++;
            scenarioLogger.info("Started Scenario: {}", scenario.getName());
        } finally {
//            lock.unlock();
            //semaphore.release();  // Release permission to log

        }
    }

    @Before("@Coindesk")
    public void setUpCoindesk(Scenario scenario) {
//        lock.lock();
        LoggerUtility.initializeLogger(scenario);
        scenarioLogger = LoggerUtility.getLogger();
        try {
            //semaphore.acquire();
            // Initialize the Coindesk Extent Report
            ExtentReportUtil.initializeCoindeskExtentReports();
            ExtentReportUtil.createCoindeskTest(scenario.getName());

            // Initialize the logger for Coindesk with the correct configuration file
            //logger = LogUtil.getLogger(Hooks.class, "log4j2-coindesk.xml");
            if (scenarioLogger == null) {
                System.out.println("Logger for Coindesk is not initialized.");
            } else {
                scenarioLogger.debug("Logger for Coindesk is initialized.");
            }
            scenarioLogger.info("Start Scenario: {}", scenario.getName());
        } finally {
//            lock.unlock();
            // semaphore.release();  // Release permission to log
        }
    }


    @After("@eBay")
    public void tearDownEBay(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioLogger.error("Scenario failed for: {}", scenario.getName());
        } else {

            scenarioLogger.info("Scenario passed: {}", scenario.getName());
        }
        ExtentReportUtil.flushEbayReports();
        driver.close();
        driver.quit();
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

    public static WebDriver getDriver() {

        return driver;
    }

    //@Before("@eBag and @Coindesk")
    public void beforeEbayCoinDesk(Scenario scenario) {
        System.out.println(0);

        // Check if the scenario has specific tags and assign the appropriate logger
        if (scenario.getSourceTagNames().contains("@Coindesk")) {
            System.out.println("coindesk before - 1");

            setUpCoindesk(scenario);
        } else if (scenario.getSourceTagNames().contains("@eBay")) {
            System.out.println("eBay before - 1");
            setUpEbay(scenario);
        }

        // Log the tags (optional)
        scenarioLogger.info("Running scenario with tags: " + scenario.getSourceTagNames());
    }

//    @After("@eBag and @Coindesk")
//    public void tearDownEbayCoinDesk(Scenario scenario) {
//        if (scenario.getSourceTagNames().contains("@Coindesk")) {
//            tearDownCoinDesk(scenario);
//        } else if (scenario.getSourceTagNames().contains("@eBay")) {
//            tearDownEBay(scenario);
//        }
//    }
}
