package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SearchPage;

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

public class SDSearchProjectAlx {

	private SearchPage searchPage;
	private static WebDriver driver;

	public SDSearchProjectAlx() {
		SDSearchProjectAlx.driver = SDLoginApp.getDriver();
		this.searchPage = new SearchPage(driver);
	}

	@And("I click on the my Search icon")
	public void i_click_on_the_my_Search_icon() {
		searchPage.clickSearchIcon();
	}

	@Then("I write the name of the Pitch project")
	public void I_write_the_name_of_the_Pitch_project() {
		searchPage.enterSearchText("Pitch");
	}

	@And("I click on the project Alx")
	public void I_click_on_the_project_alx() {
		searchPage.clickProjectLink();
	}
	
	@Then("Take Screenshoort")
	public void take_Screenshort() throws InterruptedException {
		Thread.sleep(2000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String fileName = "Screenshot_SearchProject_" + "Time_" + timestamp + ".png";

		String destinationFolder = "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\SearchProject";

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

	public SearchPage getSearchPage() {
		return searchPage;
	}

	public void setSearchPage(SearchPage searchPage) {
		this.searchPage = searchPage;
	}
}