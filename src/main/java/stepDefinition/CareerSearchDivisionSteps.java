package stepDefinition;

 
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;

	import cucumber.api.java.After;
	import cucumber.api.java.en.*;
	
	//import static org.junit.Assert.assertTrue;

	public class CareerSearchDivisionSteps{

	    WebDriver driver;

	    @Given("^I navigate to the Deutsche Bank careers website$")
	    public void navigateToDeutscheBankCareers() {
	    	CareerPageVerificationSteps launchcareerpage = new CareerPageVerificationSteps();
	    	launchcareerpage.iNavigateToTheDeutscheBankCareersWebsite("chrome");
	    }

	    @When("^I search using \"Division Category\" as \"([^\"]*)\", \"Country\" as \"([^\"]*)\", \"Corporate title\" as \"([^\"]*)\", and \"Availability\" as \"([^\"]*)\"$")
	    public void searchWithFilters(String division, String country, String corporateTitle, String availability) {
	    	WebElement buttonElement = driver.findElement(By.xpath("//button[@id='divisionProf']"));
	    	buttonElement.click();
	    	
	    	WebElement divisionDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
	        Select divisionSelect = new Select(divisionDropdown);
	        divisionSelect.selectByVisibleText("Chairman");

	        
	        WebElement countryDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
	        Select countrySelect = new Select(countryDropdown);
	        countrySelect.selectByVisibleText("Germany");

	        WebElement titleDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
	        Select titleSelect = new Select(titleDropdown);
	        titleSelect.selectByVisibleText("Associate");

	        WebElement availabilityDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
	        Select availabilitySelect = new Select(availabilityDropdown);
	        availabilitySelect.selectByVisibleText("FullTime");

	        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'type-primary') and text()='Search'"));
	        searchButton.click();
	    }

	    @Then("^I should see relevant search results$")
	    public void validateSearchResults() {
	    	WebElement resultElement = driver.findElement(By.cssSelector("div[data-v-1888e6f8='']"));

	        // Get the text from the element
	        String resultText = resultElement.getText();

	        // Extract the number from the text (assuming the format is 'x suitable results found.')
	        String[] parts = resultText.split("\\s+");
	        int resultCount = Integer.parseInt(parts[0]); // Extracting the number

	        // Validate that the result count is greater than 0
	        if (resultCount > 0) {
	            System.out.println("Validation successful. Results found: " + resultCount);
	        } else {
	            System.out.println("Validation failed. No results found.");
	        }
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}



