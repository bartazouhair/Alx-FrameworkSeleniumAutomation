package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pageObjects.ProfilPage;

public class SDProfilAlx {

	private ProfilPage profilPage;
	private static WebDriver driver;
	private WebDriverWait wait;

	public SDProfilAlx() {
		SDProfilAlx.driver = SDLoginApp.getDriver();
		this.profilPage = new ProfilPage(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@And("I click on the my Profil icon")
	public void i_click_on_the_my_Profil_icon() {
		try {
			WebElement elementProfil = wait.until(
					ExpectedConditions.elementToBeClickable(By.cssSelector("ul:nth-child(2) div:nth-child(2) > a")));
			Actions builder = new Actions(driver);
			builder.moveToElement(elementProfil).click().perform();
		} catch (NoSuchElementException e) {
			System.out.println("My Profil icon not found: " + e.getMessage());
		}
	}

	@Then("I Change my picture")
	public void I_change_my_picture() {
	    try {
	        WebElement innerElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul:nth-child(2) .inner")));
	        innerElement.click();
	        
	        WebElement avatarInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("user_avatar")));
	        avatarInput.sendKeys("C:\\Users\\zbarta\\Documents\\BARTA ZOUHAIR\\Capgemini Zouhair Barta\\Stage PFE\\Me\\Photo.png");
	    } catch (NoSuchElementException e) {
	        System.out.println("Element for changing picture not found: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("An unexpected error occurred: " + e.getMessage());
	    }
	}

	@Then("Click on the Save Information button")
	public void click_on_the_Save_Information_button() {
		try {
			WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("commit")));
			saveButton.click();
		} catch (NoSuchElementException e) {
			System.out.println("Save Information button not found: " + e.getMessage());
		}
	}

	@And("Display the message: Your profile was successfully updated")
	public void display_the_message_Your_profile_was_successfully_updated() {
		try {
			WebElement alertMessage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));
			System.out.println("Alert message: " + alertMessage.getText());
		} catch (NoSuchElementException e) {
			System.out.println("Success message not found: " + e.getMessage());
		}
	}
}