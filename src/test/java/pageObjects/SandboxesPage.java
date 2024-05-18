package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SandboxesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Localisateurs des éléments de la page
    @FindBy(id = "sidebar-dashboards-my-containers")
    private WebElement icnSandboxes;

    @FindBy(css = ".btn-outline-primary > .ml-2")
    private WebElement runOnlySandboxesButton;

    @FindBy(css = ".panel:nth-child(1) .align-items-center .align-items-center .ml-2")
    private WebElement firstSandbox;

    // Constructeur
    public SandboxesPage(WebDriver driver) {
        this.setDriver(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickSandboxesIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(icnSandboxes)).click();
    }

    public void clickRunOnlySandboxesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(runOnlySandboxesButton)).click();
    }

    public void openFirstSandbox() {
        wait.until(ExpectedConditions.elementToBeClickable(firstSandbox)).click();
    }

    public WebElement getIcnsandboxes() {
        return wait.until(ExpectedConditions.visibilityOf(icnSandboxes));
    }

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}