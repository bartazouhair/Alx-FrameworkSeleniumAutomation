package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAppPage {
    // WebDriver instance to interact with the web browser
    private WebDriver driver;

    // Constructor to initialize the WebDriver
    public LoginAppPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the login page
    public void setUp() {
        driver.get("https://intranet.alxswe.com/auth/sign_in");
    }

    // Method to enter the email in the email field
    public void enterEmail(String email) {
        driver.findElement(By.id("user_email")).sendKeys(email);
    }

    // Method to enter the password in the password field
    public void enterPassword(String password) {
        driver.findElement(By.id("user_password")).sendKeys(password);
    }

    // Method to click on the sign in button
    public void clickOnSignIn() {
        driver.findElement(By.name("commit")).click();
    }
}