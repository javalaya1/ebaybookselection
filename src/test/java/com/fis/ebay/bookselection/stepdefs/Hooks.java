/*

package com.fis.ebay.bookselection.stepdefs;

import com.fis.ebay.utils.constantsuitl.FrameworkConstants;
import com.fis.ebay.utils.reportsutil.ExtentReportUtil;
import com.fis.ebay.utils.reportsutil.LogUtil;
import com.fis.ebay.utils.webdriveruitl.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Hooks {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Semaphore semaphore = new Semaphore(1);

    private static Logger logger = null;

    private static WebDriver driver;
    private static int scenarioCount = 0;

    @Before("@eBay")
    public void setUpEbay(Scenario scenario) {
//        lock.lock();
        try {
            semaphore.acquire();
            // Initialize the eBay Extent Report
            ExtentReportUtil.initializeEbayExtentReports();

            // Initialize the logger for eBay with the correct configuration file
            logger = LogUtil.getLogger(Hooks.class, "log4j2-ebay.xml");
            if (logger == null) {
                System.out.println("Logger for eBay is not initialized.");
            } else {
                logger.debug("Logger for eBay is initialized.");
            }

            try {
                if (driver == null) {
                    synchronized (Hooks.class) {
                        if (driver == null) {
                            driver = BrowserFactory.initializeDriver(FrameworkConstants.BROWSER_NAME, FrameworkConstants.PROFILE_PATH, FrameworkConstants.IS_HEAD_LESS, FrameworkConstants.USE_GRID);
                        }
                    }
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            scenarioCount++;
            ExtentReportUtil.createEbayTest("TestScenario_" + scenarioCount + " : <b>" + scenario.getName() + "</b>");
            logger.info("Start Scenario: " + scenario.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
            semaphore.release();  // Release permission to log

        }
    }

    @Before("@Coindesk")
    public void setUpCoindesk(Scenario scenario) {
//        lock.lock();

        try {
            semaphore.acquire();
            // Initialize the Coindesk Extent Report
            ExtentReportUtil.initializeCoindeskExtentReports();
            ExtentReportUtil.createCoindeskTest(scenario.getName());

            // Initialize the logger for Coindesk with the correct configuration file
            logger = LogUtil.getLogger(Hooks.class, "log4j2-coindesk.xml");
            if (logger == null) {
                System.out.println("Logger for Coindesk is not initialized.");
            } else {
                logger.debug("Logger for Coindesk is initialized.");
            }
            logger.info("Start Scenario: " + scenario.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
            semaphore.release();  // Release permission to log

        }
    }

    @After("@eBay")
    public void tearDownEBay(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Scenario failed: " + scenario.getName());
        } else {

            logger.info("Scenario passed: " + scenario.getName());
        }
        ExtentReportUtil.flushEbayReports();
        driver.close();
        driver.quit();
        logger = null;
    }

    @After("@Coindesk")
    public void tearDownCoinDesk(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Scenario failed: " + scenario.getName());
        } else {
            logger.info("Scenario passed: " + scenario.getName());
        }
        ExtentReportUtil.flushCoindeskReports();
        logger = null;
    }

    public static WebDriver getDriver() {

        return driver;
    }
}
*/