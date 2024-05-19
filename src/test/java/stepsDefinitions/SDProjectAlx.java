package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObjects.ProjectPage;

public class SDProjectAlx {

	private ProjectPage projectPage;
	private static WebDriver driver;

	public SDProjectAlx() {
		SDProjectAlx.driver = SDLoginApp.getDriver();
		this.projectPage = new ProjectPage(driver);
	}

	@And("I click on the my Project icon")
	public void i_click_on_the_my_Project_icon() {
		projectPage.clickOnProjectIcon();
	}

	@Then("I Click on the ExpandAll button")
	public void I_click_on_the_ExpandAll_button() {
		projectPage.clickOnExpandAllButton();
	}

	@And("Display last projects Alx")
	public void display_last_projects_alx() {
		projectPage.clickOnSpecificProjectLink();
	}
	
	@Then("Take Screenshort")
	public void take_Screenshort() throws InterruptedException {
		Thread.sleep(2000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String fileName = "Screenshot_Project_" + "Time_" + timestamp + ".png";

		String destinationFolder = "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\Projects";

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
}