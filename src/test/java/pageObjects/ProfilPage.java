package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilPage {
    private WebDriver driver;

    public ProfilPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.id("saveButton"));
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(By.id("successMessage"));
    }
}