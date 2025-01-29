package com.fis.ebay.utils.listenersutil;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.fis.ebay.utils.webdriveruitl.BrowserFactory;

public class TestListener implements ITestListener {

	WebDriver driver = BrowserFactory.getDriver();

    @Override
    public void onTestFailure(ITestResult result) {
        // Initialize WebDriver (you might have a different WebDriver initialization setup)
        if (driver != null) {
			ScreenshotUtils.takeScreenshot(driver, result.getName());
        }
    }

    // You can implement other ITestListener methods as needed, such as onTestStart, onTestSuccess, etc.
    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(org.testng.ITestContext context) {
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
    }
}
