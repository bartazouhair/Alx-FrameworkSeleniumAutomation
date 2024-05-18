package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanningPage {
    private WebDriver driver;

    public PlanningPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDayTabButton() {
        return driver.findElement(By.name("day_tab"));
    }

    public WebElement getZoomButton() {
        return driver.findElement(By.name("full_screen"));
    }
}