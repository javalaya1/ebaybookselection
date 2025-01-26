package com.fis.ebay.utils.mousekeyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class ActionsUtil {

    private WebDriver driver;
    private Actions actions;

    public ActionsUtil(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.click(element).perform();
    }

    public void doubleClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.doubleClick(element).perform();
    }

    public void rightClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.contextClick(element).perform();
    }

    public void hoverOverElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public void dragAndDrop(By sourceLocator, By destinationLocator) {
        WebElement sourceElement = driver.findElement(sourceLocator);
        WebElement destinationElement = driver.findElement(destinationLocator);
        actions.dragAndDrop(sourceElement, destinationElement).perform();
    }

    public void sendKeys(By locator, String keysToSend) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.sendKeys(keysToSend);
    }

    public void keyBoardAction(Keys keys) {
        actions.sendKeys(keys);
    }

    public void sendKeysWithActions(By locator, String keysToSend) {
        WebElement element = driver.findElement(locator);
        actions.click(element).sendKeys(keysToSend).perform();
    }

    public void keyDown(Keys key) {
        actions.keyDown(key).perform();
    }

    public void keyUp(Keys key) {
        actions.keyUp(key).perform();
    }

    public void keyCombination(Keys key1, Keys key2) {
        actions.keyDown(key1).sendKeys(key2).keyUp(key1).perform();
    }

    public void performSequenceOfActions() {
        actions.moveToElement(driver.findElement(By.id("exampleID")))
                .click()
                .sendKeys("example text")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }
}

// Usage example:
// ActionsUtil actionsUtil = new ActionsUtil(driver);
// actionsUtil.clickElement(By.id("exampleID"));

