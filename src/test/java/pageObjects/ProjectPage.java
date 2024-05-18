package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "ul:nth-child(2) div:nth-child(2) > a")
    private WebElement profilIcon;

    @FindBy(css = "ul:nth-child(2) .inner")
    private WebElement innerElement;

    @FindBy(id = "user_avatar")
    private WebElement avatarInput;

    @FindBy(name = "commit")
    private WebElement saveButton;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void clickOnProfilIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(profilIcon)).click();
    }

    public void changePicture(String filePath) {
        wait.until(ExpectedConditions.elementToBeClickable(innerElement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(avatarInput)).sendKeys(filePath);
    }

    public void clickOnSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public String getAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(alertMessage)).getText();
    }
}