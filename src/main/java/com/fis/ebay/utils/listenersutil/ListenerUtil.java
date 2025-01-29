//package com.fis.ebay.utils.listenersutil;
//
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.fis.ebay.utils.constantsuitl.FrameworkConstants;
//import com.fis.ebay.utils.fwutil.CommonUtil;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.Cookie;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.support.events.WebDriverListener;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
//public class ListenerUtil implements WebDriverListener {
//
//    private static final Logger log = LogManager.getLogger(ListenerUtil.class);
//    private static ExtentReports extent;
//    private static ExtentTest test;
//
//    static {
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//        test = extent.createTest("Test Scenario", "Description of the test scenario");
//    }
//
//    private void captureScreenshot(WebDriver driver, String methodName) {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File src = ts.getScreenshotAs(OutputType.FILE);
//        String screenshotPath = FrameworkConstants.SCREENSHOTS_PATH + "\\" + methodName + "_" + CommonUtil.getCurrentDataTime() + ".png";
//        try {
//            Files.copy(src.toPath(), new File(screenshotPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
//            test.addScreenCaptureFromPath(screenshotPath);
//        } catch (IOException e) {
//            log.error("Failed to capture screenshot", e);
//        }
//    }
//
//    // WebDriver event methods
//    @Override
//    public void beforeGet(WebDriver driver, String url) {
//        log.info("Navigating to URL: " + url);
//        test.log(Status.INFO, "Navigating to URL: " + url);
//    }
//
//    @Override
//    public void afterGet(WebDriver driver, String url) {
//        log.info("Navigated to URL: " + url);
//        test.log(Status.INFO, "Navigated to URL: " + url);
//    }
//
//    @Override
//    public void beforeFindElement(WebDriver driver, By locator) {
//        log.info("Finding element by locator: " + locator);
//        test.log(Status.INFO, "Finding element by locator: " + locator);
//    }
//
//    @Override
//    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
//        log.info("Found element: " + getElementDescription(result));
//        test.log(Status.INFO, "Found element: " + getElementDescription(result));
//    }
//
//    @Override
//    public void beforeClick(WebElement element) {
//        log.info("Attempting to click on element: " + getElementDescription(element));
//        test.log(Status.INFO, "Attempting to click on element: " + getElementDescription(element));
//    }
//
//    @Override
//    public void afterClick(WebElement element) {
//        log.info("Clicked on element: " + getElementDescription(element));
//        test.log(Status.INFO, "Clicked on element: " + getElementDescription(element));
//    }
//
//    @Override
//    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
//        log.info("Sending keys to element: " + getElementDescription(element));
//        test.log(Status.INFO, "Sending keys to element: " + getElementDescription(element));
//    }
//
//    @Override
//    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
//        log.info("Sent keys to element: " + getElementDescription(element));
//        test.log(Status.INFO, "Sent keys to element: " + getElementDescription(element));
//    }
//
//    @Override
//    public void beforeGetText(WebElement element) {
//        log.info("Getting text from element: " + getElementDescription(element));
//        test.log(Status.INFO, "Getting text from element: " + getElementDescription(element));
//    }
//
//    @Override
//    public void afterGetText(WebElement element, String result) {
//        log.info("Got text from element: " + result);
//        test.log(Status.INFO, "Got text from element: " + result);
//    }
//
//    // Alert event methods
//    @Override
//    public void beforeAccept(Alert alert) {
//        log.info("About to accept alert: " + alert.getText());
//        test.log(Status.INFO, "About to accept alert: " + alert.getText());
//    }
//
//    @Override
//    public void afterAccept(Alert alert) {
//        log.info("Accepted alert: " + alert.getText());
//        test.log(Status.INFO, "Accepted alert: " + alert.getText());
//    }
//
//    // Cookie event methods
//    @Override
//    public void beforeAddCookie(WebDriver.Options options, Cookie cookie) {
//        log.info("Adding cookie: " + cookie.getName());
//        test.log(Status.INFO, "Adding cookie: " + cookie.getName());
//    }
//
//    @Override
//    public void afterAddCookie(WebDriver.Options options, Cookie cookie) {
//        log.info("Added cookie: " + cookie.getName());
//        test.log(Status.INFO, "Added cookie: " + cookie.getName());
//    }
//
//    // Error handling
//    @Override
//    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
//        log.error("Error in method: " + method.getName(), e);
//        test.log(Status.FAIL, "Error in method: " + method.getName());
//        captureScreenshot((WebDriver) target, method.getName());
//    }
//
//    // Helper method to describe the element
//    private String getElementDescription(WebElement element) {
//        String tagName = element.getTagName();
//        String id = element.getAttribute("id");
//        String className = element.getAttribute("class");
//        return "Tag: " + tagName + ", ID: " + id + ", Class: " + className;
//    }
//}
