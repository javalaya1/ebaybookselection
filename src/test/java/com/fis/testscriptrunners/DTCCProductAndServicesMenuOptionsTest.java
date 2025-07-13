package com.fis.testscriptrunners;

import com.fis.ebay.bookselection.dtccppages.LoginPage;
import com.fis.ebay.utils.datareadersutil.PropertiesReader;
import com.fis.ebay.utils.webdriveruitl.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class DTCCProductAndServicesMenuOptionsTest {
    PropertiesReader pr = new PropertiesReader("src\\main\\resources\\config.properties");
    WebDriver driver = null;

    @BeforeMethod
    public void openBrowser() throws MalformedURLException {
        String browserName = pr.getProperty("config.browser.name");
        String url = pr.getProperty("browser.url");
        driver = BrowserFactory.initializeDriver(browserName, null, false, false);
        driver.get(url);
    }

    LoginPage lp = null;

    //    @Test
    public void verifyProductAndServicesMenuOptions() {
        lp = new LoginPage(driver);
        lp.clickAcceptCookiesButton();
        lp.clickOnProductsAndServiceMenu();
        List<String> allMenuNames = lp.getListOfMenus();
//        System.out.println(allMenuNames.size());
        Assert.assertEquals(allMenuNames.size(), 8);
    }

    @Test
    public void verifySubMenus() {
        lp = new LoginPage(driver);
        lp.clickAcceptCookiesButton();
        lp.clickOnProductsAndServiceMenu();
        List<String> allMenuNames = lp.getListOfMenus();
        System.out.println(allMenuNames);
        for (int i = 0; i < allMenuNames.size(); i++) {
            System.out.println("i = " + (i + 1));
            String eachMainMenuName = allMenuNames.get(i);
            List<String> data = lp.getSubMenusItems(eachMainMenuName, i);
            System.out.println(data);
        }
    }


}
