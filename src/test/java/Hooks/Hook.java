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
    private static ExtentHTMLReport extentReport = new ExtentHTMLReport();

    @Before
    public void beforeScenario(Scenario scenario) {
        extentReport.generateReport();
        extentReport.startTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            extentReport.logStep("Scenario failed: " + scenario.getName());
            takeScreenshot(scenario);
        } else {
            extentReport.logStep("Scenario passed: " + scenario.getName());
        }
        extentReport.flushReport();
    }

    private void takeScreenshot(Scenario scenario) {
        File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "FailedScenario_" + scenario.getName() + "_" + timestamp + ".png";
        String destinationFolder = "src/test/resources/Screenshorts/Failures";

        File folder = new File(destinationFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        try {
            Path destinationPath = Path.of(destinationFolder, fileName);
            Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + destinationPath);
            extentReport.logStep("Screenshot saved: " + destinationPath);
        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
            extentReport.logStep("Error saving screenshot: " + e.getMessage());
        }
    }

    public static ExtentHTMLReport getExtentReport() {
        return extentReport;
    }
}