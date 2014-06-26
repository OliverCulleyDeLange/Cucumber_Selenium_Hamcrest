package uk.co.oliverdelange.testrunners.testng;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(tags = "~@Ignore",
        features = "src/test/resources/uk/co/oliverdelange/cucumber/",
        glue = "uk.co.oliverdelange.cucumber.tests",
        format = {"pretty","html:CucumberReports/html/","json:CucumberReports/cucumber.json", "junit:CucumberReports/cucumberJUnit.xml"},
        monochrome = true
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}
