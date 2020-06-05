package com.selenium.projects.amazon.pages;

import com.selenium.projects.amazon.enums.Url;
import com.selenium.projects.amazon.exceptions.TestException;
import com.selenium.projects.amazon.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class HomePage extends CommonUtils {
    private final By YOUR_ACCOUNT = By.id("nav-link-yourAccount");
    private final By SHOPPING_CART_ICON = By.cssSelector("#nav-cart");
    private final By SHOPPING_CART_COUNT = By.cssSelector("#nav-cart > #nav-cart-count");

    public HomePage(){
    }

    public void navigateToHomePage() throws TestException {
        String url = Url.BASEURL.getURL();
        log.info("Navigating to Amazon.com: " + url);
        navigateToURL(url);
    }

    public void navigateToSignInPage() throws TestException {
        log.info("HOME_PAGE: Selecting [YOUR_ACCOUNT] in navigation bar.");
        scrollToThenClick(YOUR_ACCOUNT);
        log.info("HOME_PAGE: Navigating to the SIGNIN_PAGE.\n");
    }

    public void signOutWithSignOutLink() throws TestException {
        String url = Url.BASEURL.getURL() + Url.SIGNOUT.getURL();
        navigateToURL(url);
    }

    public void selectShoppingCartIcon() throws TestException {
        click(SHOPPING_CART_ICON);
    }

    public String getNumberOfItemsListedInShoppingCartIcon(){
        return getElementText(SHOPPING_CART_COUNT);
    }
}
