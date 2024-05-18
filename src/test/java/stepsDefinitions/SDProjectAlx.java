package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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
    public void I_click_on_the_ExpandAll_button() throws InterruptedException {
        projectPage.clickOnExpandAllButton();
    }

    @And("Display last projects Alx")
    public void display_last_projects_alx() throws InterruptedException {
        projectPage.clickOnSpecificProjectLink();
    }
}