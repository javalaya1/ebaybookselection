package com.fis.testscriptrunners;

import com.fis.ebay.utils.listenersutil.RetryAnalyzer;
import com.fis.ebay.utils.listenersutil.TestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "./src/test/resources/coindesk.features",
        glue = {"com.fis.coindesk.stepdefs","com.fis.hooks"},
        plugin = {"pretty", "html:target/cucumber-coindesk-reports.html"},
        monochrome = true,
        tags = "@Coindesk"
)
public class RunAPITests extends AbstractTestNGCucumberTests {
	//@Test(retryAnalyzer = RetryAnalyzer.class)
    public void runCucumberTests() {
        //Cucumber will automatically run your feature files
    }
}
