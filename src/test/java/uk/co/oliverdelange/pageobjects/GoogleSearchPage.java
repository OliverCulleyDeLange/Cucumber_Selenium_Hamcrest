package uk.co.oliverdelange.pageobjects;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage extends AbstractPageObject {

    @FindBy(id = "gbqfq")
    private WebElement searchBox;

    public GoogleSearchPage(WebDriver d) throws Exception {
        super(d);
    }

    @Override
    public boolean isLoaded() {
        return searchBox.isDisplayed();
    }

    public void searchFor(String text) {
        searchBox.clear();
        searchBox.sendKeys(text);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(new Predicate<WebDriver>() {
            @Override
            public boolean apply(WebDriver input) {
                return driver.findElement(By.id("rso")).isDisplayed();
            }
        });
        searchBox.sendKeys(Keys.RETURN);
    }

    public boolean isShowingResultsFor(String searchTerm) {
        WebElement searchResultsWebElement = driver.findElement(By.id("rso"));
        List<SearchResult> searchResults = extractSearchResults(searchResultsWebElement);

        String searchRegex = buildSearchRegex(searchTerm);
        for ( SearchResult result : searchResults) {
            if (!result.title.matches(searchRegex) &&
                !result.description.matches(searchRegex) &&
                !result.link.matches(searchRegex)
                ) {
                return false;
            }
        }
        return true;
    }

    private String buildSearchRegex(String searchTerm) {
        String regex = "(?i).*";
        regex += searchTerm.replace(" ", ".*");
        return regex + ".*";
    }

    private List<SearchResult> extractSearchResults(WebElement searchResultsBlock) {
        ArrayList<SearchResult> searchResults = new ArrayList<>();

        List<WebElement> searchresults = searchResultsBlock.findElements(By.cssSelector(".rc"));
        for ( WebElement result : searchresults) {
            String title = result.findElement(By.className("r")).getText();
            String link = result.findElement(By.className("_ee")).getText();
            String description = result.findElement(By.className("st")).getText();

            searchResults.add(new SearchResult(title,link,description));
        }

        return searchResults;
    }

    private class SearchResult {
        public String title;
        public String link;
        public String description;

        public SearchResult(String title, String link, String description){
            this.title = title; this.link = link; this.description = description;
        }

    }
}
