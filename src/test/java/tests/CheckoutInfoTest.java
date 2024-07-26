package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutInfoTest extends BaseTest {
    @Test
    public void checkoutInfoTest ()  {
        String productNameFirst = "Sauce Labs Onesie";
        String productNameSecond = "Sauce Labs Backpack";
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(productNameFirst);
        productsPage.clickAddToCartButton(productNameSecond);
        productsPage.clickYourCart();
        yourCartPage.clickCheckout();
        Assert.assertTrue(checkoutInfo.isFirstNameDisplayed());
        Assert.assertTrue(checkoutInfo.isLastNameDisplayed());
        Assert.assertTrue(checkoutInfo.isZipCodeDisplayed());
        checkoutInfo.setYourInformation("Jon", "Doe", "94043");
        Assert.assertEquals(checkoutOverviewPage.getPageTitle(), "Checkout: Overview");
    }
}
