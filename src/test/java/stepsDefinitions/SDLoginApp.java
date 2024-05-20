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
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		loginPage = new LoginAppPage(driver);
		constante = new Constante();
		loginPage.setUp();
	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
		extentReport.logStep("Entering valid credentials");
		loginPage.enterEmail(constante.getUseremail());
		loginPage.enterPassword(constante.getPassword());
	}

	@And("I click on the sign in button")
	public void i_click_on_the_sign_in_button() {
		extentReport.logStep("Clicking on the sign in button");
		loginPage.clickOnSignIn();
	}

	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() throws InterruptedException {
		extentReport.logStep("Redirecting to the dashboard");
		System.out.println("Welcome to the ALX dashboard, dear Zouhair BARTA");
		Thread.sleep(2000);
	}

	@And("Take a screenshort dashboard")
	public void take_a_screenshot_dashboard() {
		extentReport.logStep("Taking a screenshot of the dashboard");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String fileName = "Screenshot_Login_" + "Time_" + timestamp + ".png";

		String destinationFolder = "src/test/resources/Screenshots/Login";

		File folder = new File(destinationFolder);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		try {
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
		if (driver != null) {
			driver.quit();
		}
	}
}