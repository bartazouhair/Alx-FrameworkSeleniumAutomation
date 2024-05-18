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

	@FindBy(css = ".fa-magnifying-glass")
	private WebElement searchIcon;

	@FindBy(id = "search-bar")
	private WebElement searchBar;

	@FindBy(linkText = "Webstack - Portfolio Project - Pitch")
	private WebElement projectLink;

	public SearchPage(WebDriver driver) {
		this.setDriver(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void clickSearchIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
	}

	public void enterSearchText(String text) {
		WebElement searchBarElement = wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBarElement.sendKeys(text);
		searchBarElement.sendKeys(Keys.ENTER);
	}

	public void clickProjectLink() {
		wait.until(ExpectedConditions.elementToBeClickable(projectLink)).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}