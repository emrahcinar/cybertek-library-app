package com.bitrix24.utulities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();
    static {
        String path = "configuration.properties";
        try {
            FileInputStream inputFile = new FileInputStream(path);
            properties.load(inputFile);
            inputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String keyWord) {
        return properties.getProperty(keyWord);

    }


}
