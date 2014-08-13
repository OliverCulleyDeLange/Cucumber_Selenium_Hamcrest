package uk.co.oliverdelange.cucumber.oliverdelange;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.oliverdelange.pageobjects.oliverdelange.AboutMePage;
import uk.co.oliverdelange.pageobjects.oliverdelange.HomePage;
import uk.co.oliverdelange.webbrowser.Browser;

import static org.junit.Assert.assertTrue;
import static uk.co.oliverdelange.webbrowser.BrowserRepository.firefox;

public class HomePageSteps {

    HomePage homePage;
    AboutMePage aboutMePage;

    Browser browser;

    @Given("^I am on oliverdelange home page$")
    public void I_am_on_oliverdelange_splash() {
        browser = firefox();
        homePage = browser.navigateToOliverdelangeHome();
    }

    @When("^I click the about me link$")
    public void I_click_the_about_me_link() {
        aboutMePage = homePage.clickAboutMeMenuLink();
    }

    @Then("^I will be redirected to oliverdelange about me$")
    public void I_will_be_redirected_to_oliverdelange_About_Me_Page() throws Throwable {
        assertTrue(aboutMePage.isLoaded());
    }

}
