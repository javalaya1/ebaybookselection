package com.fis.testscriptrunners;

import com.fis.ebay.utils.listenersutil.TestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = ".\\src\\test\\resources\\features\\ebay",
        glue = {"com.fis.ebay.bookselection.stepdefs","com.fis.hooks"},
        plugin = {"pretty", "html:target/cucumber-ebay-report.html"},
        tags = "@eBay"
)
@Listeners(TestListener.class)
public class RunEbayTests extends AbstractTestNGCucumberTests {
		
		//JIRA - 102
		public void m2(){
				//Logic
		}
		
    //@Test(retryAnalyzer = RetryAnalyzer.class)
    public void runCucumberTests() {
        //Cucumber will automatically run your feature files
    }
}

