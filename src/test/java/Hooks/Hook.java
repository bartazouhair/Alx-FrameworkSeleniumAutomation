package Hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ExtentHTMLReport;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static stepsDefinitions.SDLoginApp.getDriver;

public class Hook {
    // Create an instance of the ExtentHTMLReport utility
    private static ExtentHTMLReport extentReport = new ExtentHTMLReport();

    // Method to execute before each scenario
    @Before
    public void beforeScenario(Scenario scenario) {
        extentReport.generateReport(); // Initialize the report
        extentReport.startTest(scenario.getName()); // Start a new test in the report with the scenario name
    }

    // Method to execute after each scenario
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            extentReport.logStep("Scenario failed: " + scenario.getName()); // Log the failure in the report
            takeScreenshot(scenario); // Capture a screenshot for the failed scenario
        } else {
            extentReport.logStep("Scenario passed: " + scenario.getName()); // Log the success in the report
        }
        extentReport.flushReport(); // Finalize the report for the current scenario
    }

    // Method to capture a screenshot when a scenario fails
    private void takeScreenshot(Scenario scenario) {
        File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE); // Take a screenshot
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")); // Generate a timestamp
        String fileName = "FailedScenario_" + scenario.getName() + "_" + timestamp + ".png"; // Create a file name with the scenario name and timestamp
        String destinationFolder = "/AlxAutomationSelenium/src/test/resources/Screenshorts/Failures"; // Destination folder for screenshots

        // Create the destination folder if it doesn't exist
        File folder = new File(destinationFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        try {
            // Define the path to save the screenshot
            Path destinationPath = Path.of(destinationFolder, fileName);
            // Copy the screenshot to the destination folder
            Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + destinationPath);
            extentReport.logStep("Screenshot saved: " + destinationPath); // Log the screenshot save location in the report
        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
            extentReport.logStep("Error saving screenshot: " + e.getMessage()); // Log any errors in the report
        }
    }

    // Method to get the ExtentHTMLReport instance
    public static ExtentHTMLReport getExtentReport() {
        return extentReport;
    }
}