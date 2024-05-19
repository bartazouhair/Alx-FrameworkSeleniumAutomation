package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.Hook;
import pageObjects.SandboxesPage;
import utils.ExtentHTMLReport;

public class SDSanboxesAlx {

    private SandboxesPage sandboxesPage;
    private static WebDriver driver;
    private WebDriverWait wait;
    private ExtentHTMLReport extentReport;

    public SDSanboxesAlx() {
        SDSanboxesAlx.driver = SDLoginApp.getDriver();
        this.sandboxesPage = new SandboxesPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Updated wait time to 20 seconds
        this.extentReport = Hook.getExtentReport(); // Get instance of Extent Report
    }

	@And("I click on the my Sandboxes icon")
	public void i_click_on_the_my_Sandboxes_icon() {
		extentReport.logStep("Clicking on the my Sandboxes icon");
		try {
			WebElement icnSandboxes = wait.until(ExpectedConditions.visibilityOf(sandboxesPage.getIcnsandboxes()));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", icnSandboxes);

			Actions builder = new Actions(driver);
			builder.moveToElement(icnSandboxes).click().perform();
			extentReport.logStep("Successfully clicked on the my Sandboxes icon");
		} catch (Exception e) {
			extentReport.logStep("Failed to click on the my Sandboxes icon: " + e.getMessage());
			System.out.println("Failed to click on the my Sandboxes icon: " + e.getMessage());
		}
	}

	@Then("I click on the runing only Sandboxes")
	public void I_click_on_the_runing_only_Sandboxes() {
		extentReport.logStep("Clicking on the running only Sandboxes");
		sandboxesPage.clickRunOnlySandboxesButton();
		extentReport.logStep("Successfully clicked on the running only Sandboxes");
	}

	@And("Open Sandboxe")
	public void Open_Sandboxes() {
		extentReport.logStep("Opening the first Sandbox");
		sandboxesPage.openFirstSandbox();
		extentReport.logStep("Successfully opened the first Sandbox");
	}

	public SandboxesPage getSandboxesPage() {
		return sandboxesPage;
	}

	public void setSandboxesPage(SandboxesPage sandboxesPage) {
		this.sandboxesPage = sandboxesPage;
	}
}