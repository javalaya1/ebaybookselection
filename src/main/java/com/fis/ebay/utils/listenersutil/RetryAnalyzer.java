/*package com.fis.ebay.utils.listenersutil;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private static final int MAX_RETRY_COUNT = 3;  // Set the maximum retry count

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY_COUNT) {
            count++;
            return true;  // Retry the test
        }
        return false;  // No more retries
    }
}

*/