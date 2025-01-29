package com.fis.ebay.utils.webdriveruitl;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public interface IRemoteDriverSetup {
    WebDriver setupRemoteDriver(String profilePath, boolean isHeadless, URL hub) throws MalformedURLException;
}
