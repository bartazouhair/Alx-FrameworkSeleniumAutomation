package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // WebElement locators using @FindBy annotation
    @FindBy(css = ".fa-magnifying-glass")
    private WebElement searchIcon;

    @FindBy(id = "search-bar")
    private WebElement searchBar;

    @FindBy(linkText = "Webstack - Portfolio Project - Pitch")
    private WebElement projectLink;

    // Constructor initializes WebDriver, WebDriverWait and PageFactory elements
    public SearchPage(WebDriver driver) {
        this.setDriver(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Method to click on the search icon
    public void clickSearchIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
    }

    // Method to enter text in the search bar and submit the search
    public void enterSearchText(String text) {
        WebElement searchBarElement = wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBarElement.sendKeys(text);
        searchBarElement.sendKeys(Keys.ENTER);
    }

    // Method to click on a specific project link
    public void clickProjectLink() {
        wait.until(ExpectedConditions.elementToBeClickable(projectLink)).click();
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