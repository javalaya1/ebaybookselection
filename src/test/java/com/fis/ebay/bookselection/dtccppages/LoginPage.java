package com.fis.ebay.bookselection.dtccppages;

import com.fis.ebay.bookselection.pages.EbayBasePage;
import com.fis.ebay.utils.fwutil.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoginPage extends EbayBasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    By cookiesLocator = By.id("onetrust-accept-btn-handler");
    By productsAndServicesMenuLocator = By.xpath("//a[normalize-space()='Products & Services']");

    public void clickAcceptCookiesButton() {
        super.elementUtil.clickElement(cookiesLocator);
    }

    public void clickOnProductsAndServiceMenu() {
        super.allMouseKeyboardActions.hoverOverElement(productsAndServicesMenuLocator);
    }

    public List<String> getListOfMenus() {
        String dynamicXpath = "//a[normalize-space()='Products & Services']/following-sibling::ul[@id='section-one-ul']/li";
        List<WebElement> allMenuNames = driver.findElements(By.xpath(dynamicXpath));
        ArrayList<String> allMenuItemNames = new ArrayList<>();
        CommonUtil.doWait(5);
        for (int i = 0; i < allMenuNames.size(); i++) {
            String eachMainMenuName = "//ul[@id='section-one-ul']/li[" + (i + 1) + "]/a";
            //System.out.println(eachMainMenuName);
            WebElement eachMenuItem = driver.findElement(By.xpath(eachMainMenuName));
            String menuName = eachMenuItem.getText();
//            System.out.println("Main Menu Name : " + (i + 1) + "= " + menuName);

            allMenuItemNames.add(menuName);
        }
        return allMenuItemNames;
    }

    public static String captializeFirst(String input) {
        // Split the input into words
        String[] words = input.split(" ");

        // StringBuilder to build the final output
        StringBuilder output = new StringBuilder();

        // Process each word
        for (String word : words) {
            if (Objects.equals(word, "DTCC")) {
                output.append(word).append(" ");
                continue;
            }
            // Capitalize first letter and make the rest of the letters lowercase
            output.append(word.substring(0, 1).toUpperCase())  // Capitalize first letter
                    .append(word.substring(1).toLowerCase())     // Lowercase the rest of the word
                    .append(" ");
        }

        // Remove the last extra space
        output.setLength(output.length() - 1);
        return output.toString();
    }

    public List<String> getSubMenusItems(String name, int eachMenuItemIndex) {
        String dynamicXpath = "//a[normalize-space()='Products & Services']/following-sibling::ul[@id='section-one-ul']/li";
        String eachMainMenuDynamicXpath = dynamicXpath + "[" + (eachMenuItemIndex + 1) + "]/a[normalize-space()='" + captializeFirst(name) + "']";
        super.allMouseKeyboardActions.hoverOverElement(By.xpath(eachMainMenuDynamicXpath));
        String subMenuXpath = eachMainMenuDynamicXpath+"/following-sibling::ul/div";
        List<String> youngerList = new ArrayList<>();
        List<WebElement> subMenusList = driver.findElements(By.xpath(subMenuXpath));
        if (!subMenusList.isEmpty()) {
            for (int eachSubMenuIndex = 1; eachSubMenuIndex <= subMenusList.size(); eachSubMenuIndex++) {
                String eachSubMenuXpath = subMenuXpath + "[" + eachSubMenuIndex + "]/li";
                List<WebElement> eachSubMenuItemNameList = driver.findElements(By.xpath(eachSubMenuXpath));
                for(int j = 1; j<eachSubMenuItemNameList.size(); j++){
                    String finalItem = eachSubMenuXpath+"["+j+"]";
                    WebElement eachSubMenuItemName = driver.findElement(By.xpath(finalItem));
                    String eachSubMenuItemsName = eachSubMenuItemName.getText();
                    youngerList.add(eachSubMenuItemsName);
                }
            }
        } else {
            youngerList = getYoungerSubMenuItems(name, eachMenuItemIndex);
        }
        return youngerList;
    }

    public List<String> getYoungerSubMenuItems(String menuItemName, int menuIndex) {
        String dynamicMenuItemsXpath = "//a[normalize-space()='Products & Services']/following-sibling::ul[@id='section-one-ul']/li";
        String eachYoungSubMenuItemNameDynamicXpath = dynamicMenuItemsXpath + "[" + (menuIndex + 1) + "]/a[normalize-space()='" + captializeFirst(menuItemName) + "']/following-sibling::ul/li";
        List<WebElement> eachYoungSubMenuItemsList = driver.findElements(By.xpath(eachYoungSubMenuItemNameDynamicXpath));
        ArrayList<String> eachYoungSubMenuItemNames = new ArrayList<>();
        for (int i = 1; i <= eachYoungSubMenuItemsList.size(); i++) {
            String finalItemsListXpath = eachYoungSubMenuItemNameDynamicXpath+"["+i+"]/a";
            List<WebElement> allAs = driver.findElements(By.xpath(finalItemsListXpath));
            for(int j = 1; j<allAs.size(); j++) {
                String itemXpath = finalItemsListXpath + "[" + j + "]";
                WebElement eachYoungSubMenuItem = driver.findElement(By.xpath(itemXpath));
                String menuItemText = eachYoungSubMenuItem.getText();
                eachYoungSubMenuItemNames.add(menuItemText);
            }
        }
        return eachYoungSubMenuItemNames;
    }
}
