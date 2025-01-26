package com.fis.ebay.bookselection.stepdefs;

import com.fis.ebay.pages.EbayBookForSalePage;
import com.fis.ebay.pages.EbayBuyItPage;
import com.fis.ebay.pages.EbayHomePage;
import com.fis.ebay.utils.reportsutil.ExtentReportUtil;
import com.fis.ebay.utils.reportsutil.LogUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class EbayHomePageStepdefs {

    private WebDriver driver = Hooks.getDriver();
    private EbayHomePage ebayHomePage = new EbayHomePage(driver);
    private EbayBookForSalePage ebaybookForSale = new EbayBookForSalePage(driver);
    private EbayBuyItPage ebayBuyItPage = new EbayBuyItPage(driver);
    private static final Logger logger = LogUtil.getLogger(EbayHomePageStepdefs.class, "log4j2-ebay.xml");


    @Given("I open the browser and navigate to {string}")
    public void iOpenTheBrowserAndNavigateTo(String url) {
        try {
            driver.get(url);
            ExtentReportUtil.getTest().
                    pass("entered " + url + " successfully");
            logger.info("entered " + url + " successfully");
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("Failed to enter " + url);
            logger.error("Failed to enter " + url);
            throw t;
        }
    }

    @When("I search for {string}")
    public void iSearchFor(String itemName) {
        try {
            ebayHomePage.searchForItem(itemName);
            ExtentReportUtil.getTest().
                    pass("I Searched for an Item : " + itemName);
            logger.info("i searched for an item " + itemName);
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("I Searched for an Item : " + itemName);
            logger.error("i searched for an item " + itemName);
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

            logger.info("I Clicked on Add To Cart Button");
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("Failed to Click on Add To Cart Button");
            logger.error("Failed to Click on Add To Cart Button");
            throw t;
        }
    }


    @And("I click on the item {int} in the list")
    public void iClickOnTheItemInTheList(int itemNumber) {
        try {
            bookName = ebaybookForSale.clickOnItem(itemNumber);
            ExtentReportUtil.getTest().
                    pass("I clicked on " + bookName);
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("Failed to Click on " + bookName);
            logger.error("Failed to Click on " + bookName);
            throw t;
        }
    }
}
