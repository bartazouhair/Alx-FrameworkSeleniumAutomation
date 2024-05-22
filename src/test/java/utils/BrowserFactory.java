package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;

public class BrowserFactory {

    // Placeholder for WebDriver instance
    static WebDriver factoryDriver;

    // Load configuration properties from the specified file
    private static HashMap<String, String> configurationPropertiesMap = PropertiesFile.read("src/test/resources/environment/config.properties");

    // Extract browser type and headless mode settings from properties
    static String webBrowserType = configurationPropertiesMap.get("browser");
    static boolean headless = Boolean.parseBoolean(configurationPropertiesMap.get("isHeadless"));

    // Method to get the WebDriver instance based on the specified browser type
    public static WebDriver getFactoryDriver() {
        String driverPath = "src/test/resources/drivers/";

        switch (webBrowserType) {
            case "chrome":
                // Configure ChromeDriver with specified options
                System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--incognito");
                options.setHeadless(headless);
                factoryDriver = new ChromeDriver(options);
                break;

            case "ie":
                // Configure InternetExplorerDriver
                System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
                factoryDriver = new InternetExplorerDriver();
                break;

            case "firefox":
                // Configure FirefoxDriver
                System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                factoryDriver = new FirefoxDriver();
                break;

            default:
                // Print error message if browser type is not recognized
                System.out.println("******************************************************");
                System.out.println("Unsupported browser type: " + webBrowserType);
                System.out.println("******************************************************");
                break;
        }

        // Return the configured WebDriver instance
        return factoryDriver;
    }
}