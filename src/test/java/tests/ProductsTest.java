package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest  {

    @Test (groups = {"need account", "regression"}, dataProvider = "testProductsAddToCart", description = "Добавление товара в корзину")
    public void addToCartProductTest ()  {
        String productName = "Sauce Labs Onesie";
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductPrice(productName), "$7.99");
        Assert.assertEquals(productsPage.getProductDescription(productName), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCart();
        Assert.assertEquals(yourCartPage.getProductDescription(productName), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
    }
    @DataProvider
    public Object[][] testProductsAddToCart() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Onesie"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Fleece Jacket"},
                {"Test.allTheThings() T-Shirt (Red)"}};
    }
}

