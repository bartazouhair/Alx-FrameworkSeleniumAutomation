package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.NoSuchElementException;
import pageObjects.ProfilPage;

public class SDProfilAlx {

	private ProfilPage profilPage;

	public SDProfilAlx() {

	}

	@And("I click on the my Profil icon")
	public void i_click_on_the_my_Profil_icon() {

	}

	@Then("Click on the Save Information button")
	public void click_on_the_Save_Information_button() {
		try {
			WebElement saveButton = profilPage.getSaveButton();
			saveButton.click();
		} catch (NoSuchElementException e) {
			System.out.println("Save Information button not found: " + e.getMessage());
		}
	}

	@And("Display the message: Your profile was successfully updated")
	public void display_the_message_Your_profile_was_successfully_updated() {
		try {
			WebElement messageElement = profilPage.getSuccessMessage();
			String message = messageElement.getText();
			if (!message.equals("Your profile was successfully updated")) {
				System.out.println("Expected message not found: " + message);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Success message not found: " + e.getMessage());
		}
	}
}