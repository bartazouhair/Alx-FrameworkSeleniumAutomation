package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesFile {
    // HashMap to store the properties
    static HashMap<String, String> propertiesMap = new HashMap<>();

    // Method to read properties from a specified file
    public static HashMap<String, String> read(String propertiesFilePath) {
        // Create a File object for the specified properties file
        File file = new File(propertiesFilePath);
        FileInputStream fileInput = null;
        
        try {
            // Open a FileInputStream for the properties file
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            e.printStackTrace();
        }
        
        // Create a Properties object to load the properties
        Properties properties = new Properties();
        assert fileInput != null;
        
        try {
            // Load properties from the FileInputStream
            properties.load(fileInput);
        } catch (IOException e) {
            // Handle any I/O exceptions during the load
            e.printStackTrace();
        }
        
        // Map the properties to the HashMap
        Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = properties.getProperty(key);
            propertiesMap.put(key, value);
        }
        
        // Return the populated properties map
        return propertiesMap;
    }
}