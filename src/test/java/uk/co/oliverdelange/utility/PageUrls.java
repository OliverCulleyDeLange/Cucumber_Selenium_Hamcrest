package uk.co.oliverdelange.utility;

public enum PageUrls {
    oliverdelangeSplash("http://oliverdelange.co.uk"),
    googleSearchPage("http://www.google.co.uk");

    public String url;
    PageUrls(String url) {
        this.url = url;
    }
}