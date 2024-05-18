package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.ProfilPage;

public class SDProfilAlx {

    private ProfilPage profilPage;
    private static WebDriver driver;

    public SDProfilAlx() {
        SDProfilAlx.driver = SDLoginApp.getDriver();
        this.profilPage = new ProfilPage(driver);
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
            profilPage.changePicture("C:\\Users\\zbarta\\Documents\\BARTA ZOUHAIR\\Capgemini Zouhair Barta\\Stage PFE\\Me\\BARTA Zouhair.jpg");
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
}