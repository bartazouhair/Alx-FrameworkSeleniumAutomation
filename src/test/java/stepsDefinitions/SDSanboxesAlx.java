package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SandboxesPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SDSanboxesAlx {

    private SandboxesPage sandboxesPage;
    private static WebDriver driver;

    public SDSanboxesAlx() {
        SDSanboxesAlx.driver = SDLoginApp.getDriver();
        this.sandboxesPage = new SandboxesPage(driver);
    }

    @And("I click on the my Sandboxes icon")
    public void i_click_on_the_my_Sandboxes_icon() {
        // Attendre que l'élément soit visible
        WebElement icnSandboxes = sandboxesPage.getIcnsandboxes();
        
        // Faire défiler jusqu'à l'élément
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", icnSandboxes);

        // Cliquer sur l'élément
        Actions builder = new Actions(driver);
        builder.moveToElement(icnSandboxes).click().perform();
    }

    @Then("I click on the runing only Sandboxes")
    public void I_click_on_the_runing_only_Sandboxes() {
        sandboxesPage.clickRunOnlySandboxesButton();
    }

    @And("Open Sandboxe")
    public void Open_Sandboxes() {
        sandboxesPage.openFirstSandbox();
    }

    public SandboxesPage getSandboxesPage() {
        return sandboxesPage;
    }

    public void setSandboxesPage(SandboxesPage sandboxesPage) {
        this.sandboxesPage = sandboxesPage;
    }
}