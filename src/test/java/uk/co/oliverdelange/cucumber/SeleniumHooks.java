package uk.co.oliverdelange.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import uk.co.oliverdelange.webbrowser.BrowserPool;

public class SeleniumHooks {

    @Before("@RequiresSelenium")
    public void before() {
//        setFirefoxBrowser();
    }

    @After("@RequiresSelenium")
    public void after() {
//        System.out.println("Putting browser back");
//        replaceBrowser(browser);
    }
}
