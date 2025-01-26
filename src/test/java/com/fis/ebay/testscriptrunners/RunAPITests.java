package com.fis.ebay.testscriptrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/coindesk.features",
        glue = {"com.fis.ebay.bookselection", "com.fis.ebay.coindesk.stepdefs"},
        plugin = {"pretty", "html:target/cucumber-coindesk-reports.html"},
        monochrome = true,
        tags = "@Coindesk"
)
public class RunAPITests extends AbstractTestNGCucumberTests {

}
