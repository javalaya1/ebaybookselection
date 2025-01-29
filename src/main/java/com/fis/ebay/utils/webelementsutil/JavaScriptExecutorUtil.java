package com.fis.ebay.utils.webelementsutil;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JavaScriptExecutorUtil {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;

    public JavaScriptExecutorUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    // Method to wait for element to be visible
    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Method to click an element using JavaScript
    public void clickElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].click();", waitForElementToBeVisible(element));
    }

    // Method to send keys to an element using JavaScript
    public void sendKeysToElement(WebElement element, String text) {
        WebElement webElement = waitForElementToBeVisible(element);
        jsExecutor.executeScript("arguments[0].value='';", webElement);
        jsExecutor.executeScript("arguments[0].value=arguments[1];", webElement, text);
    }

    // Method to get text from an element using JavaScript
    public String getElementText(WebElement element) {
        return (String) jsExecutor.executeScript("return arguments[0].innerText;", waitForElementToBeVisible(element));
    }

    // Method to check if an element is displayed using JavaScript
    public boolean isElementDisplayed(WebElement element) {
        try {
            return (Boolean) jsExecutor.executeScript("return arguments[0].offsetParent !== null;", waitForElementToBeVisible(element));
        } catch (Exception e) {
            return false;
        }
    }

    // Method to get a list of elements using JavaScript
    public List<WebElement> getListOfElements(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    // Method to switch to a frame using frame element with JavaScript
    public void switchToFrame(WebElement frameElement) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", waitForElementToBeVisible(frameElement));
        driver.switchTo().frame(frameElement);
    }

    // Method to switch to a frame using frame name or ID with JavaScript
    public void switchToFrame(String frameNameOrID) {
        WebElement frameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(frameNameOrID)));
        if (frameElement == null) {
            frameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(frameNameOrID)));
        }
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", frameElement);
        driver.switchTo().frame(frameNameOrID);
    }

    // Method to switch to a frame using frame index with JavaScript
    public void switchToFrame(int frameIndex) {
        jsExecutor.executeScript("window.frames[" + frameIndex + "].scrollIntoView(true);");
        driver.switchTo().frame(frameIndex);
    }

    // Method to switch back to the main content from frame with JavaScript
    public void switchToDefaultContent() {
        jsExecutor.executeScript("window.top.document.body.scrollIntoView(true);");
        driver.switchTo().defaultContent();
    }

    // Method to switch to an alert and accept using JavaScript
    public void acceptAlert() {
        jsExecutor.executeScript("window.alert = function(msg) { return true; };");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    // Method to switch to an alert and dismiss using JavaScript
    public void dismissAlert() {
        jsExecutor.executeScript("window.alert = function(msg) { return false; };");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    // Method to switch to an alert and get text using JavaScript
    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    // Method to switch to an alert and send keys using JavaScript
    public void sendKeysToAlert(String text) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        jsExecutor.executeScript("window.prompt = function(msg) { return '" + text + "'; };");
        alert.sendKeys(text);
    }
}

