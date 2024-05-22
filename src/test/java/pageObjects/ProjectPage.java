package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for different elements on the Project Page
    private By projectIcon = By.cssSelector("ul:nth-child(2) > #sidebar-current-projects-item .fa-solid");
    private By expandAllButton = By.linkText("Expand all");
    private By specificProjectLink = By.linkText("Webstack - Portfolio Project - Pitch");

    // Constructor initializes WebDriver and WebDriverWait
    public ProjectPage(WebDriver driver) {
        this.setDriver(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to click on the project icon
    public void clickOnProjectIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(projectIcon)).click();
    }

    // Method to click on the "Expand all" button
    public void clickOnExpandAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(expandAllButton)).click();
    }

    // Method to click on a specific project link
    public void clickOnSpecificProjectLink() {
        wait.until(ExpectedConditions.elementToBeClickable(specificProjectLink)).click();
    }

    // Getter for WebDriver
    public WebDriver getDriver() {
        return driver;
    }

    // Setter for WebDriver
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}