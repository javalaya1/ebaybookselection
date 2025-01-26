package com.fis.ebay.utils.datareadersutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {
    private final Map<String, String> propertiesMap;

    public PropertiesReader(String propertiesFileName) {
//        System.out.println(" -- properties file name is : " + propertiesFileName);
        propertiesMap = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(propertiesFileName)) {
            Properties properties = new Properties();
            properties.load(fis);

            for (String key : properties.stringPropertyNames()) {
                setProperty(key, properties.getProperty(key));
            }
//            System.out.println("all properties file values = ");
//            System.out.println(propertiesMap);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return propertiesMap.get(key);
    }

    public void setProperty(String key, String value) {
        propertiesMap.put(key, value);
    }
}