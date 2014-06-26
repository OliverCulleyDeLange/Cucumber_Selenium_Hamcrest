package uk.co.oliverdelange.testrunners.testng;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import uk.co.oliverdelange.webbrowser.BrowserPool;

@CucumberOptions(tags = "~@Ignore",
        features = "src/test/resources/uk/co/oliverdelange/cucumber/",
        glue = "uk.co.oliverdelange.cucumber.tests",
        format = {"pretty","html:CucumberReports/html/","json:CucumberReports/cucumber.json"},
        monochrome = true
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Do stuff here before the cucumber tests happen");
    }

    @AfterClass
    public static void afterClass() { //FIXME why is this not being called?
        System.out.println("Do stuff here after the cucumber tests happen");
        System.out.println("Like shutting down all the web browsers...");
        BrowserPool.closeAll();
        //FIXME: The below is a bloody awful thing to do. But JUnit manages to close the browser before closing the tests, but somehow TestNG doesn't - what!?
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
