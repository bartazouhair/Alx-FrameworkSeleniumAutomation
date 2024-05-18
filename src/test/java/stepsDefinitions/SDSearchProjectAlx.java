package stepsDefinitions;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SearchPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SDSearchProjectAlx {
    
    private SearchPage searchPage;
    private static WebDriver driver;
    private WebDriverWait wait;

    public SDSearchProjectAlx() {
        SDSearchProjectAlx.driver = SDLoginApp.getDriver();
        this.setSearchPage(new SearchPage(driver));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

    @And("I click on the my Search icon")
    public void i_click_on_the_my_Search_icon() {
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-magnifying-glass")));
        searchIcon.click();
    }

    @Then("I write the name of the Pitch project")
    public void I_write_the_name_of_the_Pitch_project() {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-bar")));
        searchBar.sendKeys("Pitch");
        searchBar.sendKeys(Keys.ENTER);
    }

    @And("I click on the project Alx")
    public void I_click_on_the_project_alx() {
        WebElement projectLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Webstack - Portfolio Project - Pitch")));
        projectLink.click();
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public void setSearchPage(SearchPage searchPage) {
        this.searchPage = searchPage;
    }
}

