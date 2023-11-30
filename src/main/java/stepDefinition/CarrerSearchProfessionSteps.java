package stepDefinition;

 
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;

	import cucumber.api.java.After;
	import cucumber.api.java.en.*;


public class CarrerSearchProfessionSteps {
	
	WebDriver driver;

	 @Given("^I navigate to the Deutsche Bank careers website$")
	    public void navigateToDeutscheBankCareers() {
		 CareerPageVerificationSteps launchcareerpage = new CareerPageVerificationSteps();
	    	launchcareerpage.iNavigateToTheDeutscheBankCareersWebsite("chrome");
	    }

    @When("^I search using \"Profession Category\" as \"([^\"]*)\", \"Profession \" as \"([^\"]*)\", \"Country\" as \"([^\"]*)\", and \"Corporate title\" as \"([^\"]*)\"$")
    public void searchWithFilters(String ProfessionCategory, String Profession, String country, String corporateTitle, String availability) {
    	WebElement buttonElement = driver.findElement(By.xpath("//button[@id='profession']"));
    	buttonElement.click();
    	
    	WebElement professioncDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
        Select professioncSelect = new Select(professioncDropdown);
        professioncSelect.selectByVisibleText("Audit");
        
        WebElement professionDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
        Select professionSelect = new Select(professionDropdown);
        professionSelect.selectByVisibleText("Internal Audit");

        
        WebElement countryDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("Germany");

        WebElement titleDropdown = driver.findElement(By.xpath("//input[@placeholder='Please select']"));
        Select titleSelect = new Select(titleDropdown);
        titleSelect.selectByVisibleText("Associate");

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



