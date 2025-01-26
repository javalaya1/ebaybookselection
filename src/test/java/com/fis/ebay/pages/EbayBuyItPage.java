package com.fis.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EbayBuyItPage extends EbayBasePage{

    By addToCartButtonLocator = By.id("atcBtn_btn_1");

    public EbayBuyItPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToBuyItPage(String pageName){
        elementUtil.switchToWindowByTitle(pageName);

    }

    public void clickOnAddToCartButton(){
        elementUtil.clickElement(addToCartButtonLocator);
    }


}
