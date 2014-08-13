package uk.co.oliverdelange.pageobjects.oliverdelange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.oliverdelange.pageobjects.AbstractPageObject;

public class AboutMePage extends AbstractPageObject{

    @FindBy(id  = "profilePicture")
    private WebElement profilePicture;

    public AboutMePage(WebDriver d) throws IllegalStateException {
        super(d);
    }

    @Override
    public boolean isLoaded() {
        return profilePicture.isDisplayed();
    }
}
