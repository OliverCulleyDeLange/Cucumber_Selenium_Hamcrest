package uk.co.oliverdelange.webbrowser;

import org.openqa.selenium.WebDriver;
import uk.co.oliverdelange.pageobjects.google.GoogleSearchPage;
import uk.co.oliverdelange.pageobjects.oliverdelange.HomePage;

import static uk.co.oliverdelange.utility.PageUrls.googleSearchPage;
import static uk.co.oliverdelange.utility.PageUrls.oliverdelangeHome;

public class Browser {

    private final WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void close() {
        driver.close();
    }


    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public GoogleSearchPage navigateToGoogleSearchPage() throws IllegalStateException {
        driver.navigate().to(googleSearchPage.url);
        return new GoogleSearchPage(driver);
    }

    public HomePage navigateToOliverdelangeHome() {
        driver.navigate().to(oliverdelangeHome.url);
        return new HomePage(driver);
    }
}


