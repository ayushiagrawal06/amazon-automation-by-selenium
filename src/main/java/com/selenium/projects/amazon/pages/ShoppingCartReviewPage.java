package com.selenium.projects.amazon.pages;

import com.selenium.projects.amazon.exceptions.TestException;
import com.selenium.projects.amazon.utils.CommonUtils;
import org.openqa.selenium.By;

public class ShoppingCartReviewPage extends CommonUtils {

    private final By CART_BUTTON = By.cssSelector("#hlb-view-cart-announce");
    private final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("#hlb-ptc-btn-native");
    private final By PRICE = By.cssSelector("[class='a-color-price hlb-price a-inline-block a-text-bold']");

    public void verifyOnShoppingCartReviewPage() throws TestException {
        String url = getCurrentURL();
        System.out.println("SHOPPING_CART_REVIEW_PAGE: Verifying that we are on SHOPPING_CART_REVIEW_PAGE.");
        if (!url.contains("view")){
            throw new TestException("ERROR: Not on SHOPPING_CART_REVIEW_PAGE! URL: " + url);
        }
    }

    public String getCartSubtotal(){
        return getElementText(PRICE);
    }

    public void clickProceedToCheckoutButton() throws TestException {
        click(PROCEED_TO_CHECKOUT_BUTTON);
    }

    public void clickCartButton() throws TestException {
        click(CART_BUTTON);
    }



}
