package wipro.test.modules;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty:target/cucumber-reports/cucumber-pretty.txt",
		"html:target/cucumber-html-reports",
		"json:target/cucumber-reports/cucumber-json.json",
		"usage:target/cucumber-reports/cucumber-usage.json",
		"junit:target/cucumber-reports/cucumber-results.xml" },
features = {"src/test/resources/FeatureCollections"},
tags = { " @SmokeTest " })

public class runTest {
}




/*
 * @RunWith(Cucumber.class)
 * 
 * @CucumberOptions.Options(format = {"pretty", "html:target/html"}, features =
 * {"FeatureCollections"}, tags={"@SmokeTest"} ) public class runTest {
 * 
 * }
 * 
 * 
 * plugin = {"pretty:target/cucumber-reports/cucumber-pretty.txt", 
		"html:target/cucumber-html-reports","json:target/cucumber-reports/cucumber-json.json",
		"usage:target/cucumber-reports/cucumber-usage.json","junit:target/cucumber-reports/cucumber-results.xml" }
 * 
 */