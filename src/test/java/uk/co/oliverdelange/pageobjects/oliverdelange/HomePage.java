package uk.co.oliverdelange.pageobjects.oliverdelange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.oliverdelange.pageobjects.AbstractPageObject;

import java.util.List;

public class HomePage extends AbstractPageObject{

    @FindBy(className = "box")
    private List<WebElement> boxes;
    @FindBy(linkText = "About Me")
    private WebElement aboutMeLink;
    @FindBy(linkText = "Home")
    private WebElement homeLink;

    public HomePage(WebDriver d) throws IllegalStateException {
        super(d);
    }

    @Override
    public boolean isLoaded() {
        for (WebElement box : boxes) {
            if (!box.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public AboutMePage clickAboutMeMenuLink() {
        aboutMeLink.click();
        return new AboutMePage(driver);
    }
    public HomePage clickHomeMenuLink() {
        homeLink.click();
        return new HomePage(driver);
    }
}
