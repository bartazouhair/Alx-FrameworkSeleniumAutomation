package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SearchPage;
import utils.ExtentHTMLReport;

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

import Hooks.Hook;

public class SDSearchProjectAlx {

    private SearchPage searchPage;
    private static WebDriver driver;
    private ExtentHTMLReport extentReport;

    // Constructor to initialize the required objects
    public SDSearchProjectAlx() {
        SDSearchProjectAlx.driver = SDLoginApp.getDriver();
        this.searchPage = new SearchPage(driver);
        this.extentReport = Hook.getExtentReport(); // Get instance of Extent Report
    }

    // Step definition for clicking on the search icon
    @And("I click on the my Search icon")
    public void i_click_on_the_my_Search_icon() {
        extentReport.logStep("Clicking on the my Search icon");
        searchPage.clickSearchIcon();
        extentReport.logStep("Successfully clicked on the my Search icon");
    }

    // Step definition for writing the name of the Pitch project in the search box
    @Then("I write the name of the Pitch project")
    public void I_write_the_name_of_the_Pitch_project() {
        extentReport.logStep("Writing the name of the Pitch project");
        searchPage.enterSearchText("Pitch");
        extentReport.logStep("Successfully wrote the name of the Pitch project");
    }

    // Step definition for clicking on the specific project link
    @And("I click on the project Alx")
    public void I_click_on_the_project_alx() {
        extentReport.logStep("Clicking on the Alx project");
        searchPage.clickProjectLink();
        extentReport.logStep("Successfully clicked on the Alx project");
    }

    // Step definition for taking a screenshot of the search result
    @Then("Take Screenshoort")
    public void take_Screenshort() throws InterruptedException {
        extentReport.logStep("Taking screenshot of search result");
        Thread.sleep(2000); // Pause to allow any UI updates to complete
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "Screenshot_SearchProject_" + "Time_" + timestamp + ".png";

        String destinationFolder = "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\SearchProject";

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

    // Getter for searchPage
    public SearchPage getSearchPage() {
        return searchPage;
    }

    // Setter for searchPage
    public void setSearchPage(SearchPage searchPage) {
        this.searchPage = searchPage;
    }
}