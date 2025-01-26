package com.fis.ebay.utils.webdriveruitl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverSetup implements IDriverSetup, IRemoteDriverSetup {
    @Override
    public WebDriver setupDriver(String profilePath, boolean isHeadless) {
//        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (profilePath != null) {
            FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
            options.setProfile(profile);
        }
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new FirefoxDriver(options);
    }

    @Override
    public WebDriver setupRemoteDriver(String profilePath, boolean isHeadless, URL hub) throws MalformedURLException {
//        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (profilePath != null) {
            FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
            options.setProfile(profile);
        }
        if (isHeadless) {
            options.addArguments("--headless");
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.merge(options);
        return new RemoteWebDriver(hub, capabilities);
    }
}

