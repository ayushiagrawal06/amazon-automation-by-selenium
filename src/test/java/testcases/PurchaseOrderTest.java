package testcases;


import com.selenium.projects.amazon.actions.OrderActions;
import com.selenium.projects.amazon.domains.Book;
import com.selenium.projects.amazon.enums.Products;
import com.selenium.projects.amazon.exceptions.TestException;
import com.selenium.projects.amazon.pages.ShoppingCartReviewPage;
import com.selenium.projects.amazon.utils.CommonUtils;
import com.selenium.projects.amazon.utils.LoadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverUtils;

import static org.testng.Assert.assertEquals;

public class PurchaseOrderTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver = DriverUtils.getDriver();
        CommonUtils._driver=driver;
    }

    @Test()
    public void test_Login() throws TestException {
        OrderActions orderActions = new OrderActions();
        String username = LoadProperties.user.getProperty("tester.username");
        String password = LoadProperties.user.getProperty("tester.password");
        orderActions.navigateToHomePage();
        orderActions.loginAs(username, password);
        orderActions.initializeLogin();
    }

    @Test()
    public void test_createPurchaseOrderForSingleProduct() throws TestException {
        Products testBook = Products.HITCHHIKERS_GUIDE;
        String username = LoadProperties.user.getProperty("tester.username");
        String password = LoadProperties.user.getProperty("tester.password");
        OrderActions orderActions = new OrderActions();
        ShoppingCartReviewPage shoppingCartReviewPage = new ShoppingCartReviewPage();

        orderActions.initializeLogin();
        orderActions.navigateToHomePage();
        orderActions.loginAs(username, password);
        orderActions.initializeCart();

        Book bookProductPage = orderActions.loadProductPageDataIntoProductObject(testBook);
        orderActions.addProductToShoppingCartReview(testBook);
        String actualCartSubtotalPrice = shoppingCartReviewPage.getCartSubtotal();
        String expectedBookPrice =  bookProductPage.getOfferPrice();
        orderActions.checkMatchingValues("Verify the Price Listed for the book:", actualCartSubtotalPrice, expectedBookPrice);
        assertEquals(actualCartSubtotalPrice, expectedBookPrice, "SHOPPING_CART_REVIEW: Cart Subtotal not what is expected!");
        //Book bookShoppingCart = orderActions.loadShoppingCartDataIntoProductObject(testBook);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
