package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import pageObjects.DiscordPage;

public class SDDiscordAlx {
    private static WebDriver driver;
    private DiscordPage discordPage;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private ExtentHTMLReport extentReport;

    public SDDiscordAlx() {
        SDDiscordAlx.driver = SDLoginApp.getDriver();
        this.setDiscordPage(new DiscordPage(driver));
        this.setWait(new WebDriverWait(driver, Duration.ofSeconds(30)));
        this.extentReport = Hook.getExtentReport(); // Get instance of Extent Report
    }

    @And("I click on the My Discord icon")
    public void i_click_on_the_my_discord_icon() {
        extentReport.logStep("Clicking on the My Discord icon");
        try {
            driver.findElement(By.cssSelector("ul:nth-child(2) .fa-brands")).click();
            extentReport.logStep("Successfully clicked on the My Discord icon");
        } catch (NoSuchElementException e) {
            extentReport.logStep("My Discord icon not found: " + e.getMessage());
            System.out.println("My Discord icon not found: " + e.getMessage());
        }
    }

    @Then("I do login")
    public void i_do_login() {
        extentReport.logStep("Performing Discord login");
        try {
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
                if (driver.getTitle().contains("Discord")) {
                    break;
                }
            }

            driver.switchTo().activeElement();
            WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
            emailField.sendKeys("bartazouhair@gmail.com");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("Ezzine.Enzo2424");

            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
            submitButton.click();
            extentReport.logStep("Successfully logged in to Discord");
        } catch (NoSuchElementException e) {
            extentReport.logStep("Element not found during Discord login: " + e.getMessage());
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    @Then("I Take a screenshort")
    public void take_screenshort() throws InterruptedException {
        extentReport.logStep("Taking screenshot on Discord");
        Thread.sleep(2000);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "Screenshot_Discord_" + "Time_" + timestamp + ".png";

        String destinationFolder = "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\Discord";

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

    public DiscordPage getDiscordPage() {
        return discordPage;
    }

    public void setDiscordPage(DiscordPage discordPage) {
        this.discordPage = discordPage;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public void setJs(JavascriptExecutor js) {
        this.js = js;
    }
}