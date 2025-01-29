package com.fis.ebay.bookselection.stepdefs;

import com.fis.ebay.bookselection.pages.EbayShoppingCartPage;
import com.fis.ebay.utils.logutil.LoggerUtility;
import com.fis.ebay.utils.reportsutil.ExtentReportUtil;
import com.fis.ebay.utils.webdriveruitl.BrowserFactory;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EbayShoppingCartStepDefs {

    private final WebDriver driver = BrowserFactory.getDriver();
    private final EbayShoppingCartPage ebayShoppingCartPage = new EbayShoppingCartPage(driver);
    //  private static final Logger logger = LogUtil.getLogger(EbayShoppingCartStepDefs.class, "log4j2-ebay.xml");
    private final Logger scenarioLogger = LoggerUtility.getLogger();

    @Then("the cart should be updated and display the number of items in the cart")
    public void theCartShouldBeUpdatedAndDisplayTheNumberOfItemsInTheCart() {
        try {
            String getText = ebayShoppingCartPage.getItemCountAddedtoCart();
            Assert.assertEquals(getText, "1");
            ExtentReportUtil.getTest().
                    pass("I Cart is displaying the correct number of items that are added");
            scenarioLogger.info("I Cart is displaying the correct number of items that are added");
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("I actual item count is not matching with the expected item count");
            scenarioLogger.error("I actual item count is not matching with the expected item count");
            throw t;
        }
    }
}