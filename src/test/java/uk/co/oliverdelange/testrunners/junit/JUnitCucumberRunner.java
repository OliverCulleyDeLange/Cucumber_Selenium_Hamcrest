package uk.co.oliverdelange.testrunners.junit;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import uk.co.oliverdelange.webbrowser.BrowserPool;


@RunWith(Cucumber.class)
@CucumberOptions(tags = "~@Ignore",
        features = "src/test/resources/uk/co/oliverdelange/cucumber/",
        glue = "uk.co.oliverdelange.cucumber.tests",
        format = {"pretty","html:CucumberReports/html/","json:CucumberReports/cucumber.json", "junit:CucumberReports/cucumberJUnit.xml"},
        monochrome = true
)
public class JUnitCucumberRunner {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Do stuff here before the cucumber tests happen");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Do stuff here after the cucumber tests happen");
        System.out.println("Like shutting down all the web browsers...");
        BrowserPool.closeAll();
    }
}