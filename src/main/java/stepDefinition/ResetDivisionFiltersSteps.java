package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.*;

public class ResetDivisionFiltersSteps {
	
	WebDriver driver;

	 private String selectedDivisionCategory;
	 private String selectedCountry;
	 private String selectedCorporateTitle;
	 private String selectedAvailability;
   

    @Given("^I navigate to the Deutsche Bank careers website$")
    public void i_navigate_to_the_Deutsche_Bank_careers_website() {
    	CareerPageVerificationSteps launchcareerpage = new CareerPageVerificationSteps();
    	launchcareerpage.iNavigateToTheDeutscheBankCareersWebsite("chrome");
    }

    @Given("^I search using division$")
    public void i_search_using_division() {
    	WebElement buttonElement = driver.findElement(By.xpath("//button[@id='division']"));
    	buttonElement.click();
    }

    @Given("^I select division category as \"([^\"]*)\"$")
    public void i_select_division_category_as(String divisionCategory) {
    	WebElement divisionDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
        Select divisionSelect = new Select(divisionDropdown);
        divisionSelect.selectByVisibleText("Chairman");
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
    
    @Given("^I select availability as \"([^\"]*)\"$")
    public void i_select_availability_as(String corporatetitle) {
    WebElement availabilityDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
    Select availabilitySelect = new Select(availabilityDropdown);
    availabilitySelect.selectByVisibleText("FullTime");
    }
    
    @When("^I reset the division filters$")
    public void i_reset_the_division_filters() {
        selectedDivisionCategory = null;
        selectedCountry = null;
        selectedCorporateTitle = null;
        selectedAvailability = null;
        // Code to reset the filters
    }

    @Then("^the division filters should be reset$")
    public void the_division_filters_should_be_reset() {
        assertEquals(null, selectedDivisionCategory);
        assertEquals(null, selectedCountry);
        assertEquals(null, selectedCorporateTitle);
        assertEquals(null, selectedAvailability);
        // Code to verify that the filters have been reset
    }
}