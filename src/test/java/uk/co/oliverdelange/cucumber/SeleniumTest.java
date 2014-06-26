package uk.co.oliverdelange.cucumber;

import uk.co.oliverdelange.webbrowser.Browser;
import uk.co.oliverdelange.webbrowser.BrowserPool;

public class SeleniumTest {

    public static BrowserPool browserPool = new BrowserPool();
    public Browser browser;

    public void setFirefoxBrowser() {
        browser = browserPool.getFirefoxBrowser();
    }

    public void replaceBrowser(Browser browser) {
        browserPool.putFirefoxBack(browser);
        this.browser = null;
    }
}
