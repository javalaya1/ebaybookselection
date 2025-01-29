package com.fis.ebay.bookselection.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EbayBookForSalePage extends EbayBasePage {
    public EbayBookForSalePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String clickOnItem(int index) {
        String selectingItemName = elementUtil.getElementText(By.xpath("//ul[normalize-space(@class)='srp-results srp-list clearfix']//li[" + index +
                "]/div/div[2]//a"));
        elementUtil.clickElement(By.xpath("//ul[normalize-space(@class)='srp-results srp-list clearfix']//li[" +
                index + "]/div/div[2]//a"));
        return selectingItemName;

    }
}
