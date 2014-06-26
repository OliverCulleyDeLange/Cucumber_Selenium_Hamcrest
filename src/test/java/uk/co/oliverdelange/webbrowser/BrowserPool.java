package uk.co.oliverdelange.webbrowser;

import java.util.NoSuchElementException;

public class BrowserPool {

    BrowserCache FirefoxCache = new BrowserCache();
    BrowserCache FirefoxNoJsCache = new BrowserCache();

    public Browser getFirefoxBrowser() {
        try {
            return FirefoxCache.get();
        } catch (NoSuchElementException e){
            Browser browser = BrowserFactory.firefox();
            FirefoxCache.addToInUseCache(browser);
            return browser;
        }
    }
    public Browser getFirefoxBrowserNoJs() {
        try {
            return FirefoxNoJsCache.get();
        } catch (NoSuchElementException e){
            Browser browser = BrowserFactory.firefoxNoJavascript();
            FirefoxNoJsCache.addToInUseCache(browser);
            return browser;
        }
    }

    public void closeAll()  {
        FirefoxCache.closeAll();
    }

    public void putFirefoxBack(Browser browser) {
        browser.deleteAllCookies();
        FirefoxCache.putBrowserBack(browser);
    }
}
