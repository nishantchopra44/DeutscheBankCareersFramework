package stepDefinition;

 
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import cucumber.api.java.en.*;

import static org.junit.Assert.assertTrue;

public class SearchResultsSteps {

    WebDriver driver;
    String searchKeyword;

    @Given("I navigate to the search results page")
    public void navigateToSearchResultsPage() {
    	CareerPageVerificationSteps launchcareerpage = new CareerPageVerificationSteps();
    	launchcareerpage.iNavigateToTheDeutscheBankCareersWebsite("chrome");
    }

    @Then("the search results should contain the keyword {string}")
    public void validateSearchResultsContainKeyword(String keyword) {
        searchKeyword = keyword;
        String dynamicXPath = String.format("//div[@data-v-6e086576]//h2[contains(text(), '%s')]", searchKeyword);

        WebElement resultsContainer = driver.findElement(By.xpath(dynamicXPath));

        String resultsText = resultsContainer.getText();

        assertTrue("Keyword '" + searchKeyword + "' not found in search results", resultsText.contains(searchKeyword));

        driver.quit();
    }
}
