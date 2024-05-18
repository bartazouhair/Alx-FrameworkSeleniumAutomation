package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CurriculumPage;

import java.time.Duration;

public class SDCurriculumsAlx {

    private static WebDriver driver;
    private CurriculumPage curriculumPage;
    private WebDriverWait wait;

    public SDCurriculumsAlx() {
        SDCurriculumsAlx.driver = SDLoginApp.getDriver();
        this.curriculumPage = new CurriculumPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("I click on the my Curriculums icon")
    public void i_click_on_the_my_Curriculums_icon() {
        try {
            WebElement elementCurriculum = wait.until(ExpectedConditions.elementToBeClickable(curriculumPage.getCurriculumsIcon()));
            Actions builder = new Actions(driver);
            builder.moveToElement(elementCurriculum).click().perform();
        } catch (Exception e) {
            System.out.println("My Curriculums icon not found: " + e.getMessage());
        }
    }

    @Then("Click on the Show Overview")
    public void click_on_the_Show_Overview() {
        WebElement capIcon = wait.until(ExpectedConditions.elementToBeClickable(curriculumPage.getCapIcon()));
        capIcon.click();
        WebElement overviewLink = wait.until(ExpectedConditions.elementToBeClickable(curriculumPage.getOverviewLink()));
        overviewLink.click();
    }

    @Then("Click on the leave Overview")
    public void click_on_the_leave_Overview() {
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(curriculumPage.getCloseButton()));
        closeButton.click();
    }

    @And("Click on the Show transcript")
    public void click_on_the_Show_transcript() {
        WebElement transcriptLink = wait.until(ExpectedConditions.elementToBeClickable(curriculumPage.getTranscriptLink()));
        transcriptLink.click();
    }
}