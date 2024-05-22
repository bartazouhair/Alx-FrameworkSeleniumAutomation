package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Hooks.Hook;
import pageObjects.ProjectPage;
import utils.ExtentHTMLReport;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SDProjectAlx {

    private ProjectPage projectPage;
    private static WebDriver driver;
    private ExtentHTMLReport extentReport;

    // Constructor to initialize the required objects
    public SDProjectAlx() {
        SDProjectAlx.driver = SDLoginApp.getDriver();
        this.projectPage = new ProjectPage(driver);
        this.extentReport = Hook.getExtentReport(); // Get instance of Extent Report
    }

    // Step definition for clicking on the project icon
    @And("I click on the my Project icon")
    public void i_click_on_the_my_Project_icon() {
        extentReport.logStep("Clicking on the my Project icon");
        projectPage.clickOnProjectIcon();
        extentReport.logStep("Successfully clicked on the my Project icon");
    }

    // Step definition for clicking the ExpandAll button
    @Then("I Click on the ExpandAll button")
    public void I_click_on_the_ExpandAll_button() {
        extentReport.logStep("Clicking on the ExpandAll button");
        projectPage.clickOnExpandAllButton();
        extentReport.logStep("Successfully clicked on the ExpandAll button");
    }

    // Step definition for displaying the last projects
    @And("Display last projects Alx")
    public void display_last_projects_alx() {
        extentReport.logStep("Displaying last projects Alx");
        projectPage.clickOnSpecificProjectLink();
        extentReport.logStep("Successfully displayed last projects Alx");
    }

    // Step definition for taking a screenshot
    @Then("Take Screenshort")
    public void take_Screenshort() throws InterruptedException {
        extentReport.logStep("Taking screenshot of project view");
        Thread.sleep(2000); // Pause to allow any UI updates to complete
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "Screenshot_Project_" + "Time_" + timestamp + ".png";

        String destinationFolder = "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\Projects";

        File folder = new File(destinationFolder);
        if (!folder.exists()) {
            folder.mkdirs(); // Create the directory if it does not exist
        }

        try {
            Path destinationPath = Path.of(destinationFolder, fileName);
            Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            extentReport.logStep("Screenshot saved: " + destinationPath);
            System.out.println("Screenshot saved: " + destinationPath);
        } catch (IOException e) {
            extentReport.logStep("Error saving screenshot: " + e.getMessage());
            System.out.println("Error saving screenshot: " + e.getMessage());
        }
    }
}