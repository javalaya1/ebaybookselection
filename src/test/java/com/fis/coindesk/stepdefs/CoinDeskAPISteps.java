package com.fis.coindesk.stepdefs;

import com.fis.ebay.utils.logutil.LoggerUtility;
import com.fis.ebay.utils.reportsutil.ExtentReportUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;

public class CoinDeskAPISteps {
    //private static final Logger logger = LogUtil.getLogger(CoinDeskAPISteps.class, "log4j2-coindesk.xml");
    private Response response;
    private JSONObject jsonResponse;
    private final Logger scenarioLogger = LoggerUtility.getLogger();

    @Given("I send a GET request to the CoinDesk API")
    public void sendGETRequest() {
        try {
            RestAssured.baseURI = "https://api.coindesk.com";
            RequestSpecification request = RestAssured.given();
            response = request.get("/v1/bpi/currentprice.json");
            scenarioLogger.info("Sent GET request to CoinDesk API");
            Assert.assertEquals(response.getStatusCode(), 200);
            jsonResponse = new JSONObject(response.getBody().asString());
            ExtentReportUtil.getTest().
                    pass("Request Success and the status code is : " + response.getStatusCode());
            scenarioLogger.info("Request Success and the status code is : {}", response.getStatusCode());
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("Request failed and the status code is : " + response.getStatusCode());
            scenarioLogger.error("Request failed and the status code is : {}", response.getStatusCode());
            throw t;
        }
    }

    @Then("the response should contain the BPIs USD, GBP, and EUR")
    public void verifyBPIs() {
        String validationBPI_Text = null;
        try {
            JSONObject bpi = jsonResponse.getJSONObject("bpi");
            validationBPI_Text = "USD";
            Assert.assertTrue(bpi.has("USD"));
            ExtentReportUtil.getTest().pass("BPIs has " + validationBPI_Text);
            validationBPI_Text = "GBP";
            Assert.assertTrue(bpi.has("GBP"));
            ExtentReportUtil.getTest().pass("BPIs has " + validationBPI_Text);
            validationBPI_Text = "EUR";
            Assert.assertTrue(bpi.has("EUR"));
            ExtentReportUtil.getTest().pass("BPIs has " + validationBPI_Text);
        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("BPIs does not contain " + validationBPI_Text);
            scenarioLogger.error("BPIs does not contain " + validationBPI_Text);
            throw t;
        }
    }

    @Then("the GBP description should be {string}")
    public void verifyGBPDescription(String expectedDescription) {
        String actualDescription = null;
        try {
            JSONObject bpi = jsonResponse.getJSONObject("bpi");
            JSONObject gbp = bpi.getJSONObject("GBP");
            actualDescription = gbp.getString("description");

            Assert.assertEquals(actualDescription, expectedDescription);
            ExtentReportUtil.getTest().
                    pass("Actual GBPs description " + actualDescription + " is matching with " + expectedDescription);
            scenarioLogger.info("Actual GBPs description {} is matching with {}", actualDescription, expectedDescription);

        } catch (Throwable t) {
            ExtentReportUtil.getTest().
                    fail("GBPs description is not matching " + actualDescription + " found but required : " + expectedDescription);
            scenarioLogger.error("GBPs description is not matching {} found but required : {}", actualDescription, expectedDescription);
            throw t;
        }
    }
}

