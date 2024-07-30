package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YourCartTest extends BaseTest {
    @Test(groups = {"smoke"}, description = "Проверка  товара добавленного в корзину")
    public void yourCardTest() {
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCart();
        Assert.assertTrue(yourCartPage.isShoppingCardDisplayed());
        Assert.assertEquals(yourCartPage.getProductPrice(productName), "$29.99");
        Assert.assertEquals(yourCartPage.getProductDescription(productName), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        yourCartPage.clickCheckout();
    }
}
