package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanningPage {
    // WebDriver instance to interact with the web browser
    private WebDriver driver;

    // Constructor to initialize the WebDriver
    public PlanningPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get the WebElement for the day tab button
    public WebElement getDayTabButton() {
        return driver.findElement(By.name("day_tab"));
    }

    // Method to get the WebElement for the zoom button
    public WebElement getZoomButton() {
        return driver.findElement(By.name("full_screen"));
    }
}