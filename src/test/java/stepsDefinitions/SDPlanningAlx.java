package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.Hook;
import utils.ExtentHTMLReport;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import pageObjects.PlanningPage;

public class SDPlanningAlx {
    private static WebDriver driver;
    private PlanningPage planningPage;
    private WebDriverWait wait;
    private ExtentHTMLReport extentReport;

    public SDPlanningAlx() {
        SDPlanningAlx.driver = SDLoginApp.getDriver();
        this.planningPage = new PlanningPage(driver);
        this.setWait(new WebDriverWait(driver, Duration.ofSeconds(30)));
        this.extentReport = Hook.getExtentReport(); // Get instance of Extent Report
    }

    @And("I click on the My Planning icon")
    public void i_click_on_the_my_planning_icon() {
        extentReport.logStep("Clicking on the My Planning icon");
        try {
            WebElement elementPlanning = driver.findElement(By.cssSelector("ul:nth-child(2) > li:nth-child(1) .icon"));
            Actions builder = new Actions(driver);
            builder.moveToElement(elementPlanning).click().perform();
            extentReport.logStep("Successfully clicked on the My Planning icon");
        } catch (NoSuchElementException e) {
            extentReport.logStep("My Planning icon not found: " + e.getMessage());
            System.out.println("My Planning icon not found: " + e.getMessage());
        }
    }

    @Then("I click on the Day button to see the projects for the day")
    public void i_click_on_the_day_button_to_see_the_projects_for_the_day() throws InterruptedException {
        extentReport.logStep("Clicking on the Day button to see the projects for the day");
        try {
            WebElement dayButton = planningPage.getDayTabButton();
            dayButton.click();
            Thread.sleep(3000);
            extentReport.logStep("Successfully clicked on the Day button");
        } catch (NoSuchElementException e) {
            extentReport.logStep("Day button not found: " + e.getMessage());
            System.out.println("Day button not found: " + e.getMessage());
        }
    }

    @And("I click on the Zoom button to enlarge the planning view")
    public void i_click_on_the_zoom_button_to_enlarge_the_planning_view() {
        extentReport.logStep("Clicking on the Zoom button to enlarge the planning view");
        try {
            WebElement zoomButton = planningPage.getZoomButton();
            zoomButton.click();
            extentReport.logStep("Successfully clicked on the Zoom button");
        } catch (NoSuchElementException e) {
            extentReport.logStep("Zoom button not found: " + e.getMessage());
            System.out.println("Zoom button not found: " + e.getMessage());
        }
    }

    @Then("Take screenshort")
    public void take_screenshort() throws InterruptedException {
        extentReport.logStep("Taking screenshot of planning view");
        Thread.sleep(2000);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "Screenshot_Planning_" + "Time_" + timestamp + ".png";

        String destinationFolder = "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\Planning";

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

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }
}