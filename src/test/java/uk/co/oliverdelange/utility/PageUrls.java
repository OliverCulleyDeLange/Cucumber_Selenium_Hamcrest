package uk.co.oliverdelange.utility;

public enum PageUrls {
    oliverdelangeHome("http://www.oliverdelange.co.uk"),
    googleSearchPage("http://www.google.co.uk");

    public String url;
    PageUrls(String url) {
        this.url = url;
    }
}