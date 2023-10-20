package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty",
				"html:Cucumber_Reports/cucumber_report.html",
				"json:Cucumber_Reprots/cucmber_report.json"},
		features="./src/test/resources/features",
		glue="test",
		tags="@ScenarioOutlineDemo"
		)


public class TestRunner {

}
