package com.fis.ebay.utils.webdriveruitl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverSetup implements IDriverSetup, IRemoteDriverSetup {
    @Override
    public WebDriver setupDriver(String profilePath, boolean isHeadless) {
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (profilePath != null) {
            options.addArguments("user-data-dir=" + profilePath);
        }
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new ChromeDriver(options);
    }

    @Override
    public WebDriver setupRemoteDriver(String profilePath, boolean isHeadless, URL hub) throws MalformedURLException {
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (profilePath != null) {
            options.addArguments("user-data-dir=" + profilePath);
        }
        if (isHeadless) {
            options.addArguments("--headless");
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.merge(options);
        return new RemoteWebDriver(hub, capabilities);
    }
}


