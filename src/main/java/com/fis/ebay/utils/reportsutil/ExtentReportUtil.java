package com.fis.ebay.utils.reportsutil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportUtil {
    private static ExtentReports ebayExtent;
    private static ExtentReports coindeskExtent;
    private static ExtentTest test;
    private static ExtentSparkReporter ebayHtmlReporter;
    private static ExtentSparkReporter coindeskHtmlReporter;

    public static void initializeEbayExtentReports() {
        ebayHtmlReporter = new ExtentSparkReporter(".\\reports\\extentReport_ebay.html");
        ebayExtent = new ExtentReports();
        ebayExtent.attachReporter(ebayHtmlReporter);
    }

    public static void initializeCoindeskExtentReports() {
        coindeskHtmlReporter = new ExtentSparkReporter(".\\reports\\extentReport_coindesk.html");
        coindeskExtent = new ExtentReports();
        coindeskExtent.attachReporter(coindeskHtmlReporter);
    }

    public static ExtentTest createEbayTest(String testName) {
        test = ebayExtent.createTest(testName);
        return test;
    }

    public static ExtentTest createCoindeskTest(String testName) {
        test = coindeskExtent.createTest(testName);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void flushEbayReports() {
        ebayExtent.flush();
    }

    public static void flushCoindeskReports() {
        coindeskExtent.flush();
    }
}
