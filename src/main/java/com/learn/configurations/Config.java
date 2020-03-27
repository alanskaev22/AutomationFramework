package com.learn.configurations;

import com.learn.logger.Logging;
import io.vavr.control.Try;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

public class Config implements Logging {

    private static Properties profileProperties = new Properties();

    private final static String CHROME = "chrome";
    private final static String FIREFOX = "firefox";


    public static Properties read() {
        return Try.of(() -> {
            profileProperties.load(new FileInputStream("src/main/resources/Config.properties"));
            return readProperties(profileProperties);
        }).getOrElseThrow(throwable -> {
            throw new RuntimeException("Error : configuration.Config.properties does not exist");
        });
    }


    private static Properties readProperties(Properties profileProperties) {
        Properties systemProperties = System.getProperties();
        for (Map.Entry entry : profileProperties.entrySet()) {
            String key = String.valueOf(entry.getKey());
            if (systemProperties.containsKey(key)) {
                String value = systemProperties.getProperty(key);
                if (!value.isEmpty()) {
                    profileProperties.setProperty(key, value);
                }
            }
        }
        return profileProperties;
    }


}
