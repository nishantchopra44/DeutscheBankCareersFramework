package stepDefinition;

import cucumber.api.java.en.*;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchByInvalidJobId {

    private int searchResultCount;
    WebDriver driver;


    @Given("^I am on the career page$")
    public void navigateToCareerPage() {
    	CareerPageVerificationSteps launchcareerpage = new CareerPageVerificationSteps();
    	launchcareerpage.iNavigateToTheDeutscheBankCareersWebsite("chrome");
        
    }

    @When("^I search with an invalid job ID \"([^\"]*)\"$")
    public void searchWithInvalidJobId(String invalidJobId) {
    	
    	WebElement invalidsearchField =  driver.findElement(By.xpath("//input[@id='jobIdSearch']"));
    	invalidsearchField.sendKeys(invalidJobId);

        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'type-primary') and text()='Search'")); 
        searchButton.click();
    }

    @Then("^I should see zero search results$")
    public void verifyZeroSearchResults() {
        assertEquals("Expected zero search results", 0, searchResultCount);
    }

    // Method to simulate search with an invalid job ID
    public void performSearch(String invalidJobId) {
    	WebElement searchResultDiv = driver.findElement(By.cssSelector("div[data-v-1888e6f8='']"));
        String searchResultText = searchResultDiv.getText();
        // Validate that the search result count is "0 suitable results found"
        if (searchResultText.equals("0 suitable results found.")) {
            System.out.println("Search results show 0 suitable results.");
        } else {
            System.out.println("Search results are not as expected.");
            
        }
      
        
    }
}
