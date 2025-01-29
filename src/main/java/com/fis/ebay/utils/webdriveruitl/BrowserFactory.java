package com.fis.ebay.utils.webdriveruitl;

import com.fis.ebay.utils.constantsuitl.FrameworkConstants;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserFactory {

    private static WebDriver driver = null;

    public synchronized static WebDriver getDriver(String browser, String profilePath, boolean isHeadless, boolean useGrid) throws MalformedURLException {

        if(driver == null){
            synchronized (BrowserFactory.class){
                if(driver==null){
                    initializeDriver(browser,profilePath,isHeadless,useGrid);
                }
            }
        }
        return driver;
    }

    public static WebDriver initializeDriver(String browser, String profilePath, boolean isHeadless, boolean useGrid) throws MalformedURLException {
        IDriverSetup browserSetup;
        IRemoteDriverSetup remoteBrowserSetup = null;
        URL hub = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                browserSetup = new ChromeDriverSetup();
                remoteBrowserSetup = new ChromeDriverSetup();
                break;
            case "firefox":
                browserSetup = new FirefoxDriverSetup();
                remoteBrowserSetup = new FirefoxDriverSetup();
                break;
            case "edge":
                browserSetup = new EdgeDriverSetup();
                remoteBrowserSetup = new EdgeDriverSetup();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        if (useGrid) {
            hub = new URL(FrameworkConstants.GRID_URL);
            driver = remoteBrowserSetup.setupRemoteDriver(profilePath, isHeadless, hub);
        } else {
            driver = browserSetup.setupDriver(profilePath, isHeadless);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        return driver;
    }

}
