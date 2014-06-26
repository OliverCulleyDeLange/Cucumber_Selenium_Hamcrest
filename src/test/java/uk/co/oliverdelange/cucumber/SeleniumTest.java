package uk.co.oliverdelange.cucumber;

import uk.co.oliverdelange.webbrowser.Browser;
import uk.co.oliverdelange.webbrowser.BrowserPool;

public class SeleniumTest {

    public Browser browser;

    public void setFirefoxBrowser() {
        browser = BrowserPool.getFirefoxBrowser();
    }

    public void replaceBrowser(Browser browser) {
        BrowserPool.putFirefoxBack(browser);
        this.browser = null;
    }
}
