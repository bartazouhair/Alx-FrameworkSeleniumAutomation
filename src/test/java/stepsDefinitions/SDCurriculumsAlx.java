package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.Hook;
import pageObjects.CurriculumPage;
import utils.ExtentHTMLReport;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SDCurriculumsAlx {

    private static WebDriver driver;
    private CurriculumPage curriculumPage;
    private WebDriverWait wait;
    private ExtentHTMLReport extentReport;

    public SDCurriculumsAlx() {
        SDCurriculumsAlx.driver = SDLoginApp.getDriver();
        this.curriculumPage = new CurriculumPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extentReport = Hook.getExtentReport(); // Get instance of Extent Report
    }

    @And("I click on the my Curriculums icon")
    public void i_click_on_the_my_Curriculums_icon() {
        extentReport.logStep("Clicking on the my Curriculums icon");
        try {
            WebElement elementCurriculum = wait
                    .until(ExpectedConditions.elementToBeClickable(curriculumPage.getCapIcon()));
            elementCurriculum.click();
            Actions builder = new Actions(driver);
            builder.moveToElement(elementCurriculum).click().perform();
            extentReport.logStep("Successfully clicked on the my Curriculums icon");
        } catch (Exception e) {
            extentReport.logStep("My Curriculums icon not found: " + e.getMessage());
            System.out.println("My Curriculums icon not found: " + e.getMessage());
        }
    }

    @And("Click on the Show transcript")
    public void click_on_the_Show_transcript() throws InterruptedException {
        extentReport.logStep("Clicking on the Show transcript");
        WebElement transcriptLink = wait
                .until(ExpectedConditions.elementToBeClickable(curriculumPage.getTranscriptLink()));
        transcriptLink.click();
        Thread.sleep(2000);
        extentReport.logStep("Successfully clicked on the Show transcript");
        // takeScreenshotTranscript("Transcript_Open");
        Thread.sleep(2000);
    }

    @Then("Click on the Show Overview")
    public void click_on_the_Show_Overview() throws InterruptedException {
        extentReport.logStep("Clicking on the Show Overview");
        WebElement overviewLink = wait.until(ExpectedConditions.elementToBeClickable(curriculumPage.getOverviewLink()));
        overviewLink.click();
        Thread.sleep(3000);
        extentReport.logStep("Successfully clicked on the Show Overview");
    }

    @And("I Take screenshort Overview")
    public void I_Take_screenshot_Overview() throws InterruptedException {
        extentReport.logStep("Taking screenshot of Overview");
        Thread.sleep(2000);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "Screenshot_Curriculums_" + "Time_" + timestamp + ".png";

        String destinationFolder = "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\Curriculums";

        File folder = new File(destinationFolder);
        if (!folder.exists()) {
            folder.mkdirs();
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

    @Then("Click on the leave Overview")
    public void click_on_the_leave_Overview() throws InterruptedException {
        extentReport.logStep("Clicking on the leave Overview");
        Thread.sleep(2000);
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(curriculumPage.getCloseButton()));
        closeButton.click();
        extentReport.logStep("Successfully clicked on the leave Overview");
    }
}