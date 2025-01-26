package com.fis.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EbayShoppingCartPage extends EbayBasePage {
    By shoppingCartElement = By.xpath("//a[@class='gh-flyout__target']/span[@class='gh-cart__icon']/span");

    public EbayShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getItemCountAddedtoCart() {
        return elementUtil.getElementText(By.xpath("//a[@class='gh-flyout__target']/span[@class='gh-cart__icon']/span"));
    }
}
