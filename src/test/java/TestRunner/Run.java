package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/BillSave.feature",
		glue = "StepDefinition",
		dryRun = false, 
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-reports/reports06-04-2025.html"}		
		) 
 
public class Run {

}
