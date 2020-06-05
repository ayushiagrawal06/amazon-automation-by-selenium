package com.selenium.projects.amazon.enums;

public enum Url {
    PRODUCT_SECTION("/gp/product"),
    BASEURL("https://www.amazon.com/"),
    SIGNOUT("/gp/flex/sign-out.html");

    String url;

    Url(String url){
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
