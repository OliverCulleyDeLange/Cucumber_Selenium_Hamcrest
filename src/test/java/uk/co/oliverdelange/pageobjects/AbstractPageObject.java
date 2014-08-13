package uk.co.oliverdelange.pageobjects;

import com.google.common.base.Predicate;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.Nullable;

public abstract class AbstractPageObject implements PageObject {

    protected final WebDriver driver;

    public AbstractPageObject(WebDriver d) throws IllegalStateException {
        driver = d;
        PageFactory.initElements(driver, this);

        WebDriverWait wait = new WebDriverWait(driver, 99);
        try {
            wait.until(new Predicate<WebDriver>() {
                @Override
                public boolean apply(@Nullable WebDriver input) {
                    return isLoaded();
                }
            });
        } catch (TimeoutException e) {
            throw new IllegalStateException("Expected Page - " + this.getClass() + " was not loaded");
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}