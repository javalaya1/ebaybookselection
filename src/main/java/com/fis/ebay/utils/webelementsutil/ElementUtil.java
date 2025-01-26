package com.fis.ebay.utils.webelementsutil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ElementUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Method to wait for element to be visible
    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Method to click an element
    public void clickElement(WebElement element) {
        waitForElementToBeVisible(element).click();
    }

    public void clickElement(By elementLocator) {
        waitForElementToBeVisible(driver.findElement(elementLocator)).click();
    }

    // Method to send keys to an element
    public void sendKeysToElement(WebElement element, String text) {
        WebElement webElement = waitForElementToBeVisible(element);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void sendKeysToElement(By element, String text) {
        WebElement webElement = waitForElementToBeVisible(driver.findElement(element));
        webElement.clear();
        webElement.sendKeys(text);
    }

    // Method to get text from an element
    public String getElementText(WebElement element) {
        return waitForElementToBeVisible(element).getText();
    }

    // Method to get text from an element
    public String getElementText(By elementLocator) {
        return waitForElementToBeVisible(driver.findElement(elementLocator)).getText();
    }

    // Method to check if an element is displayed
    public boolean isElementDisplayed(WebElement element) {
        try {
            return waitForElementToBeVisible(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to get a list of elements
    public List<WebElement> getListOfElements(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    // Method to switch to another window by title
    public void switchToWindowByTitle(String windowTitle) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
//        System.out.println("Window Titles : " + allWindows);
        for (String window : allWindows) {

            driver.switchTo().window(window);
            if (driver.getTitle().equals(windowTitle)) {
                return;
            }

        }
    }

    // Method to switch to a frame using frame element
    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(waitForElementToBeVisible(frameElement));
    }

    // Method to switch to a frame using frame name or ID
    public void switchToFrame(String frameNameOrID) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
    }

    // Method to switch to a frame using frame index
    public void switchToFrame(int frameIndex) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }

    // Method to switch back to the main content from frame
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Method to switch to an alert and accept
    public void acceptAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    // Method to switch to an alert and dismiss
    public void dismissAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    // Method to switch to an alert and get text
    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    // Method to switch to an alert and send keys
    public void sendKeysToAlert(String text) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
    }
}
