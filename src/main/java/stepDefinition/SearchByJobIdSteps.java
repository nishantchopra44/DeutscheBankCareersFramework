package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.After;
import cucumber.api.java.en.*;


public class SearchByJobIdSteps {
    WebDriver driver;

    @Given("^I am on the careers page$")
    public void i_am_on_the_careers_page() {
    	
    	CareerPageVerificationSteps launchcareerpage = new CareerPageVerificationSteps();
    	launchcareerpage.iNavigateToTheDeutscheBankCareersWebsite("chrome");
    }

    @When("^I search for job ID \"([^\"]*)\"$")
    public void i_search_for_job_ID(String jobId) {
        WebElement searchField = driver.findElement(By.xpath("//input[@id='jobIdSearch']"));
        searchField.sendKeys(jobId);

        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'type-primary') and text()='Search'")); 
        searchButton.click();
    }

    @Then("^I should see the job details$")
    public void i_should_see_the_job_details() {
    	CareerSearchDivisionSteps validateresults = new CareerSearchDivisionSteps();
    	validateresults.validateSearchResults();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

