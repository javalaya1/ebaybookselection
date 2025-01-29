package com.fis.ebay.bookselection.stepdefs;

import com.fis.ebay.bookselection.pages.EbayBookForSalePage;
import com.fis.ebay.bookselection.pages.EbayBuyItPage;
import com.fis.ebay.bookselection.pages.EbayHomePage;
import com.fis.ebay.utils.logutil.LoggerUtility;
import com.fis.ebay.utils.reportsutil.ExtentReportUtil;
import com.fis.hooks.BaseStepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class EbayHomePageStepdefs{

    private final WebDriver driver = BaseStepDefinitions.getDriver();
    private final EbayHomePage ebayHomePage = new EbayHomePage(driver);
    private final EbayBookForSalePage ebaybookForSale = new EbayBookForSalePage(driver);
    private final EbayBuyItPage ebayBuyItPage = new EbayBuyItPage(driver);
   // private static final Logger logger = LogUtil.getLogger(EbayHomePageStepdefs.class, "log4j2-ebay.xml");
   private final Logger scenarioLogger = LoggerUtility.getLogger();

    @Given("I open the browser and navigate to {string}")
    public void iOpenTheBrowserAndNavigateTo(String url) {
        try {
            driver.get(url);
            ExtentReportUtil.getTest().
                    pass("entered " + url + " successfully");
            scenarioLogger.info("entered {} successfully", url);
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("Failed to enter " + url);
            scenarioLogger.error("Failed to enter {}", url);
            throw t;
        }
    }

    @When("I search for {string}")
    public void iSearchFor(String itemName) {
        try {
            ebayHomePage.searchForItem(itemName);
            ExtentReportUtil.getTest().
                    pass("I Searched for an Item : " + itemName);
            scenarioLogger.info("i searched for an item {}", itemName);
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("I Searched for an Item : " + itemName);
            scenarioLogger.error("i searched for an item {}", itemName);
            throw t;
        }

    }

    private String bookName = null;

    @And("I click on Add to cart")
    public void iClickOnAddToCart() {
        try {
            ebayBuyItPage.switchToBuyItPage(bookName);
            ebayBuyItPage.clickOnAddToCartButton();
            ExtentReportUtil.getTest().
                    pass("I Clicked on Add To Cart Button");

            scenarioLogger.info("I Clicked on Add To Cart Button");
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("Failed to Click on Add To Cart Button");
            scenarioLogger.error("Failed to Click on Add To Cart Button");
            throw t;
        }
    }


    @And("I click on the item {int} in the list")
    public void iClickOnTheItemInTheList(int itemNumber) {
        try {
            bookName = ebaybookForSale.clickOnItem(itemNumber);
            ExtentReportUtil.getTest().
                    pass("I clicked on " + bookName);
            scenarioLogger.info("I clicked on {}", bookName);
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("Failed to Click on " + bookName);
            scenarioLogger.error("Failed to Click on {}", bookName);
            throw t;
        }
    }
}
