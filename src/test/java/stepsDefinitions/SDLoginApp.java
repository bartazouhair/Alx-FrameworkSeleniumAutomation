package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Hooks.Hook;
import pageObjects.LoginAppPage;
import utils.Constante;
import utils.ExtentHTMLReport;

public class SDLoginApp {
	private static WebDriver driver;
	private LoginAppPage loginPage;
	private Constante constante;
	private ExtentHTMLReport extentReport = Hook.getExtentReport();

	@Given("I am on the ALX login page")
	public void i_am_on_the_ALX_login_page() {
		extentReport.logStep("Navigating to the ALX login page");
		// Set the system property for the Chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		// Define Chrome options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");

		// Initialize the Chrome driver with the options
		driver = new ChromeDriver(options);
		loginPage = new LoginAppPage(driver);
		constante = new Constante();
		loginPage.setUp();
	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
		extentReport.logStep("Entering valid credentials");
		// Enter the user email and password
		loginPage.enterEmail(constante.getUseremail());
		loginPage.enterPassword(constante.getPassword());
	}

	@And("I click on the sign in button")
	public void i_click_on_the_sign_in_button() {
		extentReport.logStep("Clicking on the sign in button");
		// Click on the sign-in button
		loginPage.clickOnSignIn();
	}

	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() throws InterruptedException {
		extentReport.logStep("Redirecting to the dashboard");
		// Log a message indicating successful login
		System.out.println("Welcome to the ALX dashboard, dear Zouhair BARTA");
		// Wait for 2 seconds
		Thread.sleep(2000);
	}

	@And("Take a screenshot dashboard")
	public void take_a_screenshot_dashboard() {
		extentReport.logStep("Taking a screenshot of the dashboard");
		// Take a screenshot of the dashboard
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Generate a timestamped file name for the screenshot
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String fileName = "Screenshot_Login_" + "Time_" + timestamp + ".png";

		// Define the destination folder for screenshots
		String destinationFolder = "src/test/resources/Screenshots/Login";

		File folder = new File(destinationFolder);
		// Create the folder if it doesn't exist
		if (!folder.exists()) {
			folder.mkdirs();
		}

		try {
			// Copy the screenshot to the destination folder
			Path destinationPath = Path.of(destinationFolder, fileName);
			Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Screenshot saved: " + destinationPath);
		} catch (IOException e) {
			System.out.println("Error saving screenshot: " + e.getMessage());
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@After
	public void tearDown() {
		// Quit the driver if it is not null
		if (driver != null) {
			driver.quit();
		}
	}
}