package com.fis.ebay.utils.webdriveruitl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class EdgeDriverSetup implements IDriverSetup, IRemoteDriverSetup {
    @Override
    public WebDriver setupDriver(String profilePath, boolean isHeadless) {
//        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        if (profilePath != null) {
            options.addArguments("user-data-dir=" + profilePath);
        }
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new EdgeDriver(options);
    }

    @Override
    public WebDriver setupRemoteDriver(String profilePath, boolean isHeadless, URL hub) throws MalformedURLException {
//        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
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

