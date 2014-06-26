package uk.co.oliverdelange.testrunners.junit;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(tags = "~@Ignore",
        features = "src/test/resources/uk/co/oliverdelange/cucumber/",
        glue = "uk.co.oliverdelange.cucumber.tests",
        format = {"pretty","html:CucumberReports/html/","json:CucumberReports/cucumber.json", "junit:CucumberReports/cucumberJUnit.xml"},
        monochrome = true
)
public class JUnitCucumberRunner {
}