package uk.co.oliverdelange.cucumber.google;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.oliverdelange.pageobjects.google.GoogleSearchPage;
import uk.co.oliverdelange.webbrowser.Browser;
import uk.co.oliverdelange.webbrowser.BrowserRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static uk.co.oliverdelange.pageobjects.Matchers.GoogleSearchResultsMatcher.isDisplayingResultsRelatedTo;

public class GoogleSearchSteps {

    GoogleSearchPage googleSearchPage;

    Browser browser;

    @Given("^I am on google search page$")
    public void I_am_on_google_search_page() throws Throwable {
        System.out.println("Getting firefox browser for google");
        browser = BrowserRepository.firefoxNoJavascript();
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
