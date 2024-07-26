package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest {

    @Test
    public void checkingPageDisplayTest() {
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickYourCart();
        yourCartPage.clickCheckout();
        checkoutInfo.setYourInformation ("Jon", "Doe","94043");
        checkoutOverviewPage.clickFinishButton();
       // Assert.assertEquals(checkoutOverviewPage.getCheckoutComplete(), "Checkout: Complete!");
    }
}
