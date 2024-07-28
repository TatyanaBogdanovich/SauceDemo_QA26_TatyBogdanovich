package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;

public class CheckoutOverviewTest extends BaseTest {

    @Test
    public void checkingPageDisplayTest() {
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckout();
        checkoutInfoPage.setYourInformation ("Jon", "Doe","94043");
        checkoutOverviewPage.getTotalAmount();
        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage (driver);
        Assert.assertEquals(checkoutCompletePage.getCheckoutComplete(), "Checkout: Complete!");
    }
}
