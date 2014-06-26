package uk.co.oliverdelange.webbrowser;

import org.openqa.selenium.WebDriver;
import uk.co.oliverdelange.pageobjects.GoogleSearchPage;
import uk.co.oliverdelange.utility.PageUrls;

public class Browser {

    private final WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleSearchPage navigateToGoogleSearchPage() throws Exception {
        driver.navigate().to(PageUrls.googleSearchPage);
        return new GoogleSearchPage(driver);
    }

    public void close() {
        driver.close();
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }
}


