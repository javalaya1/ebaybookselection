package com.fis.testscriptrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/coindesk.features",
        glue = {"com.fis.coindesk.stepdefs","com.fis.hooks"},
        plugin = {"pretty", "html:target/cucumber-coindesk-reports.html"},
        monochrome = true,
        tags = "@Coindesk"
)
public class RunAPITests extends AbstractTestNGCucumberTests {

}
