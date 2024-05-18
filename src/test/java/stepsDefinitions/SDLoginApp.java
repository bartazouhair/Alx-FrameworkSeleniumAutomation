// SDLoginApp.java

package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.LoginAppPage;
import utils.Constante;

public class SDLoginApp {
    private static WebDriver driver;
    private LoginAppPage loginPage;
    private Constante constante;

    @Given("I am on the ALX login page")
    public void i_am_on_the_ALX_login_page() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        loginPage = new LoginAppPage(driver);
        constante = new Constante();
        loginPage.setUp();
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage.enterEmail(constante.getUseremail());
        loginPage.enterPassword(constante.getPassword());
    }

    @And("I click on the sign in button")
    public void i_click_on_the_sign_in_button() {
        loginPage.clickOnSignIn();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        System.out.println("Welcome to the ALX dashboard, dear Zouhair BARTA");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}