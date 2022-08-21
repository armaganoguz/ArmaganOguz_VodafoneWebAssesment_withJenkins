package StepDefinitions;

import java.net.URL;
import java.util.HashMap;

import org.junit.runner.RunWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/signup.feature", glue = {
		"StepDefinitions" }, monochrome = true, plugin = { "pretty", "html:target/htmlReport",
				"json:target/jsonReport.json", "junit:target/junitReport.xml" })
public class TestRunner {

}
