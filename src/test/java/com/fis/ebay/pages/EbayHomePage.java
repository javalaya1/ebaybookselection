package com.fis.ebay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EbayHomePage extends EbayBasePage {

    public EbayHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchForItem(String itemName){
       super.enterTextInSearchBox(itemName);
       super.clickSearchButton();
    }




}
