package uk.co.oliverdelange.webbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserRepository {
    private BrowserRepository() {}

    private static Browser firefox;
    private static Browser firefoxNoJavascript;


    public static Browser firefox() {
        if (firefox == null) {
            firefox = new Browser(new FirefoxDriver());
        }
        return firefox;
    }

    public static Browser firefoxNoJavascript() {
        if (firefoxNoJavascript == null ) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setJavascriptEnabled(false);
            firefoxNoJavascript=  new Browser(new FirefoxDriver(capabilities));
        }
        return firefoxNoJavascript;
    }

    public static void closeAll() {
        firefox.close();
        firefoxNoJavascript.close();
    }

    //TODO Create more driver configurations
}