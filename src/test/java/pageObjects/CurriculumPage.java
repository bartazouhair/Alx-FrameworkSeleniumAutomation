package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurriculumPage {

    // WebDriver instance to interact with the web browser
    private WebDriver driver;

    // Locators for elements on the Curriculum Page
    // Locator for the graduation cap icon
    private By capIcon = By.cssSelector("ul:nth-child(2) .fa-graduation-cap");
    // Locator for the Overview link
    private By overviewLink = By.linkText("Overview");
    // Locator for the Close button
    private By closeButton = By.className("close");
    // Locator for the Show transcript link
    private By transcriptLink = By.linkText("Show transcript");

    // Constructor to initialize the WebDriver
    public CurriculumPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements on the Curriculum Page

    // Method to get the WebElement for the graduation cap icon
    public WebElement getCapIcon() {
        return driver.findElement(capIcon);
    }

    // Method to get the WebElement for the Overview link
    public WebElement getOverviewLink() {
        return driver.findElement(overviewLink);
    }

    // Method to get the WebElement for the Close button
    public WebElement getCloseButton() {
        return driver.findElement(closeButton);
    }

    // Method to get the WebElement for the Show transcript link
    public WebElement getTranscriptLink() {
        return driver.findElement(transcriptLink);
    }
}