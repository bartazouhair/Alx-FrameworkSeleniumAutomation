package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CurriculumPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
			WebElement elementCurriculum = wait
					.until(ExpectedConditions.elementToBeClickable(curriculumPage.getCapIcon()));
			elementCurriculum.click();
			Actions builder = new Actions(driver);
			builder.moveToElement(elementCurriculum).click().perform();
		} catch (Exception e) {
			System.out.println("My Curriculums icon not found: " + e.getMessage());
		}
	}

	@And("Click on the Show transcript")
	public void click_on_the_Show_transcript() throws InterruptedException {
		WebElement transcriptLink = wait
				.until(ExpectedConditions.elementToBeClickable(curriculumPage.getTranscriptLink()));
		transcriptLink.click();
		Thread.sleep(2000);
		// takeScreenshotTranscript("Transcript_Open");
		Thread.sleep(2000);
	}
	/*
	 * private void takeScreenshotTranscript(String description) { File
	 * screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * String timestamp =
	 * LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	 * String fileName = "Screenshot_" + description + "_Time_" + timestamp +
	 * ".png";
	 * 
	 * String destinationFolder =
	 * "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\Curriculums";
	 * 
	 * File folder = new File(destinationFolder); if (!folder.exists()) {
	 * folder.mkdirs(); }
	 * 
	 * try { Path destinationPath = Path.of(destinationFolder, fileName);
	 * Files.copy(screenshotFile.toPath(), destinationPath,
	 * StandardCopyOption.REPLACE_EXISTING);
	 * System.out.println("Screenshot saved : " + destinationPath); } catch
	 * (IOException e) { System.out.println("Error saving screenshot : " +
	 * e.getMessage()); } }
	 */

	@Then("Click on the Show Overview")
	public void click_on_the_Show_Overview() throws InterruptedException {
		WebElement overviewLink = wait.until(ExpectedConditions.elementToBeClickable(curriculumPage.getOverviewLink()));
		overviewLink.click();
		Thread.sleep(3000);
	}

	@And("I Take screenshort Overview")
	public void I_Take_screenshot_Overview() throws InterruptedException {
		Thread.sleep(2000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String fileName = "Screenshot_Curriculums_" + "Time_" + timestamp + ".png";

		String destinationFolder = "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\Curriculums";

		File folder = new File(destinationFolder);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		try {
			Path destinationPath = Path.of(destinationFolder, fileName);
			Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Screenshot save : " + destinationPath);
		} catch (IOException e) {
			System.out.println("Error saving screenshot : " + e.getMessage());
		}
	}

	@Then("Click on the leave Overview")
	public void click_on_the_leave_Overview() throws InterruptedException {
		Thread.sleep(2000);
		WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(curriculumPage.getCloseButton()));
		closeButton.click();
	}
}