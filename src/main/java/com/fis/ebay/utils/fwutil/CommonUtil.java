package com.fis.ebay.utils.fwutil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtil {

    public static String getCurrentDataTime() {

        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss"));
    }

    public static void doWait(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
