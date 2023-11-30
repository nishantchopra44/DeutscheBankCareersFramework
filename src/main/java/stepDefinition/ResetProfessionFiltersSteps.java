package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.*;

public class ResetProfessionFiltersSteps {
	
	WebDriver driver;

    private String selectedProfessionCategory;
    private String selectedProfession;
    private String selectedCountry;
    private String selectedCorporateTitle;
   

    @Given("^I navigate to the Deutsche Bank careers website$")
    public void i_navigate_to_the_Deutsche_Bank_careers_website() {
    	CareerPageVerificationSteps launchcareerpage = new CareerPageVerificationSteps();
    	launchcareerpage.iNavigateToTheDeutscheBankCareersWebsite("chrome");
    }

    @Given("^I search using profession$")
    public void i_search_using_profession() {
    	WebElement buttonElement = driver.findElement(By.xpath("//button[@id='profession']"));
    	buttonElement.click();
    }

    @Given("^I select profession category as \"([^\"]*)\"$")
    public void i_select_profession_category_as(String professionCategory) {
    	WebElement professioncDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
        Select professioncSelect = new Select(professioncDropdown);
        professioncSelect.selectByVisibleText("Audit");
    }

    @Given("^I select profession as \"([^\"]*)\"$")
    public void i_select_profession_as(String profession) {
    	WebElement professionDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
        Select professionSelect = new Select(professionDropdown);
        professionSelect.selectByVisibleText("Internal Audit");

    }
    
    @Given("^I select country as \"([^\"]*)\"$")
    public void i_select_country_as(String country) {
        WebElement countryDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("Germany");

    }
    
    @Given("^I select corporate title as \"([^\"]*)\"$")
    public void i_select_corporate_title_as(String corporatetitle) {
    	WebElement titleDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
        Select titleSelect = new Select(titleDropdown);
        titleSelect.selectByVisibleText("Associate");

    }
    
    @When("^I reset the profession filters$")
    public void i_reset_the_profession_filters() {
        selectedProfessionCategory = null;
        selectedProfession = null;
        selectedCountry = null;
        selectedCorporateTitle = null;
        //  to reset the filters
    }

    @Then("^the profession filters should be reset$")
    public void the_profession_filters_should_be_reset() {
        assertEquals(null, selectedProfessionCategory);
        assertEquals(null, selectedProfession);
        assertEquals(null, selectedCountry);
        assertEquals(null, selectedCorporateTitle);
        // to verify that the filters have been reset
    }
}