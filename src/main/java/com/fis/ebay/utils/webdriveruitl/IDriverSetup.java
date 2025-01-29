package com.fis.ebay.utils.webdriveruitl;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface IDriverSetup {
    WebDriver setupDriver(String profilePath, boolean isHeadless) throws MalformedURLException;
}



