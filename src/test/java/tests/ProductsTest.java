package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class ProductsTest extends BaseTest {

    @Test(groups = {"regression"}, description = "Добавление товара в корзину", retryAnalyzer = Retry.class)
    public void AddToCartButton() {
        String productName = "Sauce Labs Onesie";
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductPrice(productName), "$7.99");
        Assert.assertEquals(productsPage.getProductDescription(productName), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCart();
        Assert.assertEquals(yourCartPage.getProductDescription(productName), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
    }
}

