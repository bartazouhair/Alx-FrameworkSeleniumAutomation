package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilPage {
    // WebDriver instance to interact with the web browser
    private WebDriver driver;
    // WebDriverWait instance for explicit waits
    private WebDriverWait wait;

    // Locator for the profile icon
    @FindBy(css = "ul:nth-child(2) div:nth-child(2) > a")
    private WebElement profilIcon;

    // Locator for an inner element
    @FindBy(css = "ul:nth-child(2) .inner")
    private WebElement innerElement;

    // Locator for the avatar input field
    @FindBy(id = "user_avatar")
    private WebElement avatarInput;

    // Locator for the save button
    @FindBy(name = "commit")
    private WebElement saveButton;

    // Locator for the alert message
    @FindBy(css = ".alert")
    private WebElement alertMessage;

    // Constructor to initialize the WebDriver and WebDriverWait
    public ProfilPage(WebDriver driver) {
        this.setDriver(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Initialize WebElements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // Method to click on the profile icon
    public void clickOnProfilIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(profilIcon)).click();
    }

    // Method to change the profile picture
    public void changePicture(String filePath) {
        wait.until(ExpectedConditions.elementToBeClickable(innerElement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(avatarInput)).sendKeys(filePath);
    }

    // Method to click on the save button
    public void clickOnSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    // Method to get the alert message text
    public String getAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(alertMessage)).getText();
    }

    // Getter for the WebDriver instance
    public WebDriver getDriver() {
        return driver;
    }

    // Setter for the WebDriver instance
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}