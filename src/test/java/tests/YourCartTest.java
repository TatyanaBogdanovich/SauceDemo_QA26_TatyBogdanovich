package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YourCartTest extends BaseTest {
    @Test
    public void yourCardTest ()  {
        String productNameFirst = "Sauce Labs Onesie";
        String productNameSecond = "Sauce Labs Backpack";
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(productNameFirst);
        productsPage.clickAddToCartButton(productNameSecond);
        productsPage.clickYourCart();
        Assert.assertTrue(yourCartPage.isShoppingCardDisplayed());
        Assert.assertEquals(yourCartPage.getProductPrice(productNameFirst), "$7.99");
        Assert.assertEquals(yourCartPage.getProductDescription(productNameFirst), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
        Assert.assertEquals(yourCartPage.getProductPrice(productNameSecond), "$29.99");
        Assert.assertEquals(yourCartPage.getProductDescription(productNameSecond), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        yourCartPage.clickCheckout();
       }
}
