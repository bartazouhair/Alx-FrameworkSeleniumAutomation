package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurriculumPage {

	private WebDriver driver;

	// Locators for elements on the Curriculum Page
	// private By curriculumsIcon = By.cssSelector("ul:nth-child(2) >
	// #sidebar-concepts-item > a");
	private By capIcon = By.cssSelector("ul:nth-child(2) .fa-graduation-cap");
	private By overviewLink = By.linkText("Overview");
	private By closeButton = By.className("close");
	private By transcriptLink = By.linkText("Show transcript");

	// Constructor
	public CurriculumPage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods to interact with elements on the Curriculum Page
	/*
	 * public WebElement getCurriculumsIcon() { return
	 * driver.findElement(curriculumsIcon); }
	 */

	public WebElement getCapIcon() {
		return driver.findElement(capIcon);
	}

	public WebElement getOverviewLink() {
		return driver.findElement(overviewLink);
	}

	public WebElement getCloseButton() {
		return driver.findElement(closeButton);
	}

	public WebElement getTranscriptLink() {
		return driver.findElement(transcriptLink);
	}
}