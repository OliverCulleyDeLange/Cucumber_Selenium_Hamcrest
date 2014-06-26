package uk.co.oliverdelange.webbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
    private BrowserFactory() {}

    public static Browser firefox() {
        WebDriver driver= new FirefoxDriver();
        return new Browser(driver);
    }

    public static Browser firefoxNoJavascript() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(false);
        WebDriver driver = new FirefoxDriver(capabilities);
        return new Browser(driver);
    }

    //TODO Create more driver configurations
}