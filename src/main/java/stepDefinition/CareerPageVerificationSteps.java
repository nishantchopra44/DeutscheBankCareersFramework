package stepDefinition;

import static org.junit.Assert.assertTrue;

import org.junit.After;

//import cucumber.api.junit.Cucumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import cucumber.api.CucumberOptions;
//import io.cucumber.java.en.*;
import cucumber.api.java.en.*;


public class CareerPageVerificationSteps {

    WebDriver driver;
    String browser;

    @Given("^I navigate to the Deutsche Bank careers website$")
    public void iNavigateToTheDeutscheBankCareersWebsite(String browser) {
    	if(browser.contentEquals(browser)) {
        System.setProperty("webdriver.chrome.driver","/Users/nishantchopra/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://careers.db.com/");
    	}
    	else {
    		System.setProperty("webdriver.ie.driver", "/Users/nishantchopra/Downloads/iexolorer");
    		driver=new InternetExplorerDriver();
    	}
    }

    @Then("^I should be on the careers page$")
    public void iShouldBeOnTheCareersPage() {
        String currentPageURL = driver.getCurrentUrl();
        assertTrue("Not on the Deutsche Bank careers page",
                currentPageURL.startsWith("https://careers.db.com/"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

