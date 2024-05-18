package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SearchPage;
import org.openqa.selenium.WebDriver;

public class SDSearchProjectAlx {

	private SearchPage searchPage;
	private static WebDriver driver;

	public SDSearchProjectAlx() {
		SDSearchProjectAlx.driver = SDLoginApp.getDriver();
		this.searchPage = new SearchPage(driver);
	}

	@And("I click on the my Search icon")
	public void i_click_on_the_my_Search_icon() {
		searchPage.clickSearchIcon();
	}

	@Then("I write the name of the Pitch project")
	public void I_write_the_name_of_the_Pitch_project() {
		searchPage.enterSearchText("Pitch");
	}

	@And("I click on the project Alx")
	public void I_click_on_the_project_alx() {
		searchPage.clickProjectLink();
	}

	public SearchPage getSearchPage() {
		return searchPage;
	}

	public void setSearchPage(SearchPage searchPage) {
		this.searchPage = searchPage;
	}
}