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
import pageObjects.ProfilPage;
import utils.Constante;

public class SDProfilAlx {

	private ProfilPage profilPage;
	private static WebDriver driver;
	private Constante constante;

	public SDProfilAlx() {
		SDProfilAlx.driver = SDLoginApp.getDriver();
		this.profilPage = new ProfilPage(driver);
		constante = new Constante();
	}

	@And("I click on the my Profil icon")
	public void i_click_on_the_my_Profil_icon() {
		try {
			profilPage.clickOnProfilIcon();
		} catch (Exception e) {
			System.out.println("My Profil icon not found: " + e.getMessage());
		}
	}

	@Then("I Change my picture")
	public void I_change_my_picture() {
		try {
			profilPage.changePicture(constante.getImage());
		} catch (Exception e) {
			System.out.println("An error occurred while changing the picture: " + e.getMessage());
		}
	}

	@Then("Click on the Save Information button")
	public void click_on_the_Save_Information_button() {
		try {
			profilPage.clickOnSaveButton();
		} catch (Exception e) {
			System.out.println("Save Information button not found: " + e.getMessage());
		}
	}

	@And("Display the message: Your profile was successfully updated")
	public void display_the_message_Your_profile_was_successfully_updated() {
		try {
			String message = profilPage.getAlertMessage();
			System.out.println("Alert message: " + message);
		} catch (Exception e) {
			System.out.println("Success message not found: " + e.getMessage());
		}
	}

	@Then("Take a screenshort")
	public void take_a_screenshort() throws InterruptedException {
		Thread.sleep(2000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String fileName = "Screenshot_Profil_" + "Time_" + timestamp + ".png";

		String destinationFolder = "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\Profil";

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
}