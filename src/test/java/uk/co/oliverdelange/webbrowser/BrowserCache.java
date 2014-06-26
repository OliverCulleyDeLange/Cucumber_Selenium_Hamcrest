package uk.co.oliverdelange.webbrowser;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BrowserCache {

    private List<Browser> availableCache = new ArrayList<Browser>();
    private List<Browser> inUseCache = new ArrayList<Browser>();

    public Browser get() throws NoSuchElementException {
        if (availableCache.size()>0) {
            Browser browser = availableCache.get(0);
            availableCache.remove(browser);
            inUseCache.add(browser);
            return browser;
        } else {
            throw new NoSuchElementException("No available browsers");
        }
    }

    public void putBrowserBack(Browser browser) {
        if(inUseCache.contains(browser)){
            inUseCache.remove(browser);
        } else {
            throw new NoSuchElementException("Cannot find browser in inUseCache");
        }
        availableCache.add(browser);
    }

    public void addToInUseCache(Browser browser) {
        inUseCache.add(browser);
    }

    public void closeAll() {
        for (Browser b : availableCache){
            b.close();
        }
        if (inUseCache.size()>0){
            System.out.println("Some browsers shut down that were in use!");
            for (Browser b : inUseCache){
                b.close();
            }
        }
    }
}
