package runner;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/nishantchopra/eclipse-workspace/DeutscheBankCareersFramework/src/main/java/Features/career_page_verification.feature", //the path of the feature files
		glue= "/Users/nishantchopra/eclipse-workspace/DeutscheBankCareersFramework/src/main/java/stepDefinition/CareerPageVerificationSteps.java", //the path of the step definition files
	    tags = {"@Smoke" , "@Regression", "@Sanity"}
		//format= {"pretty","html:test-outout"} //to generate different types of reporting
//		monochrome = true, //display the console output in a proper readable format
//		strict = true, //it will check if any step is not defined in step definition file
//		dryRun = false //to check the mapping is proper between feature file and step def file
					
		)

public class TestRunner {
	
	

}



