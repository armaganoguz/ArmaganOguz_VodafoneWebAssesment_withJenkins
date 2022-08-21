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
	
	String username = System.getenv("BROWSERSTACK_USERNAME");
	String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	String buildName = System.getenv("JENKINS_LABEL");

	DesiredCapabilities capabilities = new DesiredCapabilities();	
	WebDriver driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
	HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
	
	browserstackOptions.put("os", "Windows");
	browserstackOptions.put("osVersion", "10");
	browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
	browserstackOptions.put("seleniumVersion", "4.0.0");
	
	capabilities.setCapability("browserName", "Chrome");
	capabilities.setCapability("browserVersion", "104.0");
	capabilities.setCapability("bstack:options", browserstackOptions);



}
