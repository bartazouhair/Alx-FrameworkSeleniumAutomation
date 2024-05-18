package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CurriculumPage;

import java.time.Duration;

public class SDCurriculumsAlx {

	private static WebDriver driver;
	private CurriculumPage curriculumPage;
	private WebDriverWait wait;

	public SDCurriculumsAlx() {
		SDCurriculumsAlx.driver = SDLoginApp.getDriver();
		this.curriculumPage = new CurriculumPage(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@And("I click on the my Curriculums icon")
	public void i_click_on_the_my_Curriculums_icon() {
		try {
			WebElement elementCurriculum = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("ul:nth-child(2) > #sidebar-concepts-item > a")));
			Actions builder = new Actions(driver);
			builder.moveToElement(elementCurriculum).click().perform();
		} catch (NoSuchElementException e) {
			System.out.println("My Planning icon not found: " + e.getMessage());
		}
	}

	@Then("Click on the Show Overview")
	public void click_on_the_Show_Overview() {
		WebElement capIcon = wait.until(ExpectedConditions.elementToBeClickable(
			By.cssSelector("ul:nth-child(2) .fa-graduation-cap")));
		capIcon.click();
		WebElement overviewLink = wait.until(ExpectedConditions.elementToBeClickable(
			By.linkText("Overview")));
		overviewLink.click();
	}

	@Then("Click on the leave Overview")
	public void click_on_the_leave_Overview() {
		WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
			By.className("close")));
		closeButton.click();
	}

	@And("Click on the Show transcript")
	public void click_on_the_Show_transcript() {
		WebElement transcriptLink = wait.until(ExpectedConditions.elementToBeClickable(
			By.linkText("Show transcript")));
		transcriptLink.click();
	}
}