package com.fis.ebay.bookselection.pages;

import com.fis.ebay.utils.webelementsutil.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayBasePage {

    protected WebDriver driver = null;
    protected ElementUtil elementUtil = null;

    By searchBoxLocator = By.id("gh-ac");
    By searchButtonLocator = By.id("gh-search-btn");

    protected EbayBasePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public void enterTextInSearchBox(String searchItem) {
        elementUtil.sendKeysToElement(searchBoxLocator, searchItem);
    }

    public void clickSearchButton() {
        elementUtil.clickElement(searchButtonLocator);
    }


}
