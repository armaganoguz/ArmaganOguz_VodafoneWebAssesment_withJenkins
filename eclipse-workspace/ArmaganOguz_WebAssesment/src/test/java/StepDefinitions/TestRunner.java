package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/test.feature", glue = {
		"StepDefinitions" }, monochrome = true, plugin = { "pretty", "html:target/htmlReport",
				"json:target/jsonReport.json", "junit:target/junitReport.xml" })
public class TestRunner {

}
