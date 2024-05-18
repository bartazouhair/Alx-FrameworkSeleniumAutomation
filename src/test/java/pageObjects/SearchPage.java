package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By projectIcon = By.cssSelector("ul:nth-child(2) > #sidebar-current-projects-item .fa-solid");
    private By expandAllButton = By.linkText("Expand all");
    private By specificProjectLink = By.linkText("Webstack - Portfolio Project - Pitch");

    public SearchPage(WebDriver driver) {
        this.setDriver(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnProjectIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(projectIcon)).click();
    }

    public void clickOnExpandAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(expandAllButton)).click();
    }

    public void clickOnSpecificProjectLink() {
        wait.until(ExpectedConditions.elementToBeClickable(specificProjectLink)).click();
    }

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}