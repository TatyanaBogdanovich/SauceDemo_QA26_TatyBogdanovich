package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutInfoTest extends BaseTest {

    @Test (groups = {"regression"}, description = "Добавление информации о пользователе")

    public void checkoutInfoTest ()  {
        String productNameFirst = "Sauce Labs Onesie";
        String productNameSecond = "Sauce Labs Backpack";
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(productNameFirst);
        productsPage.clickAddToCartButton(productNameSecond);
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckout();
        Assert.assertTrue(checkoutInfoPage.isFirstNameDisplayed());
        Assert.assertTrue(checkoutInfoPage.isLastNameDisplayed());
        Assert.assertTrue(checkoutInfoPage.isZipCodeDisplayed());
        checkoutInfoPage.setYourInformation("Jon", "Doe", "94043");
        Assert.assertEquals(checkoutOverviewPage.getPageTitle(), "Checkout: Overview");
    }
}
