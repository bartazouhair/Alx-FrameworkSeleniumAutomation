package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAppPage {
    private WebDriver driver;

    public LoginAppPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUp() {
        driver.get("https://intranet.alxswe.com/auth/sign_in");
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("user_email")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("user_password")).sendKeys(password);
    }

    public void clickOnSignIn() {
        driver.findElement(By.name("commit")).click();
    }
}