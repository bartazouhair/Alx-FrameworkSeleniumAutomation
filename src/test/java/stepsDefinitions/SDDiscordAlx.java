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

	public SDDiscordAlx() {
		SDDiscordAlx.driver = SDLoginApp.getDriver();
		this.discordPage = new DiscordPage(driver);
		this.setWait(new WebDriverWait(driver, Duration.ofSeconds(30)));
	}

	@And("I click on the My Discord icon")
	public void i_click_on_the_my_discord_icon() {
		try {
			driver.findElement(By.cssSelector("ul:nth-child(2) .fa-brands")).click();
		} catch (NoSuchElementException e) {
			System.out.println("My Discord icon not found: " + e.getMessage());
		}
	}

	@Then("I do login")
	public void i_do_login() {
		try {
			// Basculer vers la fenêtre Discord
			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);
				if (driver.getTitle().contains("Discord")) {
					break;
				}
			}

			// Donner le focus à l'élément actif de la fenêtre Discord
			driver.switchTo().activeElement();
			WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
			emailField.sendKeys("bartazouhair@gmail.com");

			WebElement passwordField = driver.findElement(By.name("password"));
			passwordField.sendKeys("Ezzine.Enzo2424");

			WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
			submitButton.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}
	}

	  @Then("I Take a screenshort") public void take_screenshort() throws
	  InterruptedException { Thread.sleep(2000); File screenshotFile =
	  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  
	  String timestamp =
	  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	  String fileName = "Screenshot_Discord_" + "Time_" + timestamp + ".png";
	  
	  String destinationFolder =
	  "C:\\Users\\zbarta\\eclipse-workspace\\AlxAutomationSelenium\\src\\test\\resources\\Screenshorts\\Discord";
	  
	  File folder = new File(destinationFolder); if (!folder.exists()) {
	  folder.mkdirs(); }
	  
	  try { Path destinationPath = Path.of(destinationFolder, fileName);
	  Files.copy(screenshotFile.toPath(), destinationPath,
	  StandardCopyOption.REPLACE_EXISTING); System.out.println("Screenshot save : "
	  + destinationPath); } catch (IOException e) {
	  System.out.println("Error saving screenshot : " + e.getMessage()); } }
	 

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}
}