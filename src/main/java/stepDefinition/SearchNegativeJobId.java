package stepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.*;

public class SearchNegativeJobId {


	    WebDriver driver;
	    String enteredJobId;

	    @Given("I navigate to the job search page")
	    public void navigateToJobSearchPage() {
	    	CareerPageVerificationSteps launchcareerpage = new CareerPageVerificationSteps();
	    	launchcareerpage.iNavigateToTheDeutscheBankCareersWebsite("chrome");
	    }

	    @When("I enter {string} in the Job ID field")
	    public void enterWrongJobID(String wrongJobId) {
	        enteredJobId = wrongJobId;
	        WebElement jobIdField = driver.findElement(By.id("jobIdSearch"));
	        jobIdField.sendKeys(enteredJobId);
	    }

	    @When("I click the Search button")
	    public void clickSearchButton() {
	        WebElement searchButton = driver.findElement(By.xpath("//button[@class='button type-primary']"));
	        searchButton.click();
	    }

	    @Then("the search results should be zero")
	    public void verifyZeroSearchResults() {
	        WebElement searchResultContainer = driver.findElement(By.xpath("//div[@class='search-results']"));
	        assertEquals("Search results are not zero", "0", searchResultContainer.getText().trim());

	        driver.quit();
	    }
}

