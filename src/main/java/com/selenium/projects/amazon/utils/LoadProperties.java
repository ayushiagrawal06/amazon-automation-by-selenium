package com.selenium.projects.amazon.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class LoadProperties {

    public static Properties user = loadProperties("src/test/resources/user.properties");

    private static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        try {
            FileInputStream f = new FileInputStream(filePath);
            properties.load(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
