package uk.co.oliverdelange.webbrowser;

import java.util.NoSuchElementException;

public class BrowserPool {
    private BrowserPool() {}

    static BrowserCache FirefoxCache = new BrowserCache();
    static BrowserCache FirefoxNoJsCache = new BrowserCache(); // TODO  with tagging system - Browser Builder newFirefoxbrowser.withJavaScriptDisabled()... etc

    public static Browser getFirefoxBrowser() {
        try {
            return FirefoxCache.get();
        } catch (NoSuchElementException e){
            Browser browser = BrowserFactory.firefox();
            FirefoxCache.addToInUseCache(browser);
            return browser;
        }
    }

    public static Browser getFirefoxBrowserNoJs() {
        try {
            return FirefoxNoJsCache.get();
        } catch (NoSuchElementException e){
            Browser browser = BrowserFactory.firefoxNoJavascript();
            FirefoxNoJsCache.addToInUseCache(browser);
            return browser;
        }
    }

    public static void closeAll()  {
        FirefoxCache.closeAll();
        FirefoxNoJsCache.closeAll();
    }

    public static void putFirefoxBack(Browser browser) {
        browser.deleteAllCookies();
        FirefoxCache.putBrowserBack(browser);
    }
}
