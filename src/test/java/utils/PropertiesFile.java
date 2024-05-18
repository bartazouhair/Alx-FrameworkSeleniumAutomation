package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesFile {
    // To Do : Read the file Properties
    static HashMap<String, String> propertiesMap = new HashMap<>();

    public static HashMap<String, String> read(String propertiesFilePath) {
        File file = new File(propertiesFilePath);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        assert fileInput != null;
        try {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Do Mapping
        Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = properties.getProperty(key);
            propertiesMap.put(key, value);
        }
        return propertiesMap;
    }
}
