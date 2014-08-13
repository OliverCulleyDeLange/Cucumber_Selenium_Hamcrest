package uk.co.oliverdelange.cucumber.google;


import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import uk.co.oliverdelange.cucumber.SeleniumTest;
import uk.co.oliverdelange.pageobjects.google.GoogleSearchPage;
import uk.co.oliverdelange.webbrowser.Browser;
import uk.co.oliverdelange.webbrowser.BrowserPool;

import static org.hamcrest.MatcherAssert.assertThat;
import static uk.co.oliverdelange.pageobjects.Matchers.GoogleSearchResultsMatcher.isDisplayingResultsRelatedTo;

public class GoogleSearchSteps extends SeleniumTest {

    GoogleSearchPage googleSearchPage;

    @Given("^I am on google search page$")
    public void I_am_on_google_search_page() throws Throwable {
        System.out.println("Getting firefox browser for google");
        browser = BrowserPool.getFirefoxBrowser();
        googleSearchPage = browser.navigateToGoogleSearchPage();
    }

    @When("^I search for (.*)$")
    public void I_search_for_text(String text) throws Throwable {
        googleSearchPage.searchFor(text);
    }

    @Then("^I will see results related to (.*)$")
    public void I_will_see_results_related_to_text(String searchTerm) throws Throwable {
        assertThat(googleSearchPage, isDisplayingResultsRelatedTo(searchTerm));
    }
}
