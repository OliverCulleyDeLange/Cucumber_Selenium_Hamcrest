package uk.co.oliverdelange.cucumber.tests;


import uk.co.oliverdelange.cucumber.SeleniumTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import uk.co.oliverdelange.pageobjects.GoogleSearchPage;
import uk.co.oliverdelange.pageobjects.Matchers.GoogleSearchResultsMatcher;

import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleSearchTest extends SeleniumTest {

    GoogleSearchPage googleSearchPage;

    @Before("@RequiresSelenium")
    public void before() {
        setFirefoxBrowser();
    }

    @After("@RequiresSelenium")
    public void after() {
        replaceBrowser(browser);
    }

    @Given("^I am on google search page$")
    public void I_am_on_google_search_page() throws Throwable {
        googleSearchPage = browser.navigateToGoogleSearchPage();
    }

    @When("^I search for (.*)$")
    public void I_search_for_text(String text) throws Throwable {
        googleSearchPage.searchFor(text);
    }

    @Then("^I will see results related to (.*)$")
    public void I_will_see_results_related_to_text(String searchTerm) throws Throwable {
        MatcherAssert.assertThat(googleSearchPage, GoogleSearchResultsMatcher.isDisplayingResultsRelatedTo(searchTerm));
    }
}
