package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
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
		driver.findElement(By.cssSelector("ul:nth-child(2) > #sidebar-current-projects-item .fa-solid")).click();
	}

	@Then("I Click on the ExpandAll button")
	public void I_click_on_the_ExpandAll_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Expand all")).click();
	}

	@And("Display all projetcs Alx")
	public void display_all_projects_alx() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Webstack - Portfolio Project - Pitch")).click();
	}
}