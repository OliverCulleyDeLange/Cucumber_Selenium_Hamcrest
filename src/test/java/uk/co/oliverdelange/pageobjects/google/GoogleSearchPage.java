package uk.co.oliverdelange.pageobjects.google;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.oliverdelange.pageobjects.AbstractPageObject;

public class GoogleSearchPage extends AbstractPageObject {

    @FindBy(id = "gbqfq")
    private WebElement searchBox;
    @FindBy(id = "search")
    private WebElement searchResults;

    public GoogleSearchPage(WebDriver d) throws IllegalStateException {
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
        return searchResults.getText().contains(searchTerm);
    }
}
