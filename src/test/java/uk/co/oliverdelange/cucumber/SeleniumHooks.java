package uk.co.oliverdelange.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SeleniumHooks extends SeleniumTest {

    @Before("@RequiresSelenium")
    public void before() {
        setFirefoxBrowser();
    }

    @After("@RequiresSelenium")
    public void after() {
        System.out.println("Putting browser back");
        replaceBrowser(browser);
    }
}
