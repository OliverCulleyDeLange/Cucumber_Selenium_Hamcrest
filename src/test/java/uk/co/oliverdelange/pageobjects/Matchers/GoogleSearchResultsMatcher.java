package uk.co.oliverdelange.pageobjects.Matchers;

import org.hamcrest.*;
import org.testng.annotations.Factory;
import uk.co.oliverdelange.pageobjects.google.GoogleSearchPage;

public class GoogleSearchResultsMatcher {

    @Factory
    public static Matcher<GoogleSearchPage> isDisplayingResultsRelatedTo(final String searchTerm) {
        return new TypeSafeMatcher<GoogleSearchPage>() {
            @Override
            protected boolean matchesSafely(GoogleSearchPage page) {
                return page.isShowingResultsFor(searchTerm);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Google should be telling us about " + searchTerm + " - but its not! :(");
            }
        };
    }
};