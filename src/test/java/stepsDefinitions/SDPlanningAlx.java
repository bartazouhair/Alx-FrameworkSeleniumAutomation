package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import pageObjects.PlanningPage;

public class SDPlanningAlx {
	private static WebDriver driver;
	private PlanningPage planningPage;
	private WebDriverWait wait;

	public SDPlanningAlx() {
		SDPlanningAlx.driver = SDLoginApp.getDriver();
		this.planningPage = new PlanningPage(driver);
		this.setWait(new WebDriverWait(driver, Duration.ofSeconds(30)));
	}

	@And("I click on the My Planning icon")
	public void i_click_on_the_my_planning_icon() {
		try {
			WebElement elementPlanning = driver.findElement(By.cssSelector("ul:nth-child(2) > li:nth-child(1) .icon"));
			Actions builder = new Actions(driver);
			builder.moveToElement(elementPlanning).click().perform();
		} catch (NoSuchElementException e) {
			System.out.println("My Planning icon not found: " + e.getMessage());
		}
	}

	@Then("I click on the Day button to see the projects for the day")
	public void i_click_on_the_day_button_to_see_the_projects_for_the_day() throws InterruptedException {
		try {
			WebElement dayButton = planningPage.getDayTabButton();
			dayButton.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			System.out.println("Day button not found: " + e.getMessage());
		}
	}

	@And("I click on the Zoom button to enlarge the planning view")
	public void i_click_on_the_zoom_button_to_enlarge_the_planning_view() {
		try {
			WebElement zoomButton = planningPage.getZoomButton();
			zoomButton.click();
		} catch (NoSuchElementException e) {
			System.out.println("Zoom button not found: " + e.getMessage());
		}
	}

	@Then("Take screenshort")
	public void take_screenshort() throws InterruptedException {
		Thread.sleep(2000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String fileName = "Screenshot_Planning_" + "Time_" + timestamp + ".png";

		String destinationFolder = "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\Planning";

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

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}
}