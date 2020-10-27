package com.vyTrack.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    static Properties properties;
    FileInputStream inputStream;

    {
        try {
            inputStream = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Path cannot found");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }


}
