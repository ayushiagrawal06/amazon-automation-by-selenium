package com.selenium.projects.amazon.pages;

import com.selenium.projects.amazon.enums.Products;
import com.selenium.projects.amazon.enums.Url;
import com.selenium.projects.amazon.exceptions.TestException;
import com.selenium.projects.amazon.utils.CommonUtils;
import org.openqa.selenium.By;

public class ProductPage extends CommonUtils {

    private final By PRODUCT_TITLE = By.cssSelector("#productTitle");
    private final By AUTHOR = By.cssSelector(".a-link-normal.contributorNameID");
    private final By EDITION = By.cssSelector(".a-size-medium.a-color-secondary.a-text-normal");
    private final By PRICE = By.cssSelector(".a-size-medium.a-color-price.offer-price.a-text-normal");
    private final By ADD_TO_CART = By.cssSelector("#add-to-cart-button");

    public void navigateToProductPage(Products product) throws TestException {
        String url = Url.BASEURL.getURL() + Url.PRODUCT_SECTION.getURL() + "/" + product.getProductId();
        navigateToURL(url);
        System.out.println("PRODUCT_PAGE: Navigated to " + url);
    }

    public void verifyProductTitle(String expectedTitle) throws TestException {
        String actualTitle = getProductTitle();
        System.out.println("PRODUCT_PAGE: Verifying that the product title is '" + actualTitle + "'");
        if (!expectedTitle.equals(actualTitle)){
            throw new TestException("ERROR: PRODUCT_PAGE: Product Title is ['" + actualTitle + "']. Expected ['" + expectedTitle + "'].");
        }
    }

    public String getProductTitle(){
        return getElementText(PRODUCT_TITLE);
    }

    public String getAuthor(){
        return getElementText(AUTHOR);
    }

    public String getEdition(){
        return getElementText(EDITION);
    }

    public String getPrice(){
        return getElementText(PRICE);
    }

    public void clickAddToCart() throws TestException {
        System.out.println("PRODUCT_PAGE: Clicking on [ADD_TO_CART] button. \n");
        click(ADD_TO_CART);
    }
}
