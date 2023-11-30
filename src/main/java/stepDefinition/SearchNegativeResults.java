package stepDefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.*;

import static org.junit.Assert.assertFalse;

public class SearchNegativeResults {

    WebDriver driver;
    String searchKeyword;

    @Given("I navigate to the search results page")
    public void navigateToSearchResultsPage() {
    	CareerPageVerificationSteps launchcareerpage = new CareerPageVerificationSteps();
    	launchcareerpage.iNavigateToTheDeutscheBankCareersWebsite("chrome");
    }

    @Then("the search results should not contain the keyword {string}")
    public void validateSearchResultsDoNotContainKeyword(String negativeKeyword) {
        searchKeyword = negativeKeyword;
        String dynamicXPath = String.format("//div[@data-v-6e086576]//h2[contains(text(), '%s')]", searchKeyword);

        WebElement resultsContainer = null;
        try {
            resultsContainer = driver.findElement(By.xpath(dynamicXPath));
        } catch (org.openqa.selenium.NoSuchElementException ignored) {
            // Ignore the exception if element not found
        }

        assertFalse("Keyword '" + searchKeyword + "' found in search results", resultsContainer != null && resultsContainer.isDisplayed());

        driver.quit();
    }
}
