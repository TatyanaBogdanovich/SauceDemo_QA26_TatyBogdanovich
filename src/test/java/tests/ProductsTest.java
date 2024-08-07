package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class ProductsTest extends BaseTest {
    public final static String DESCRIPTION_PRODUCT = "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";
    public final static String PRICE_PRODUCT = "$7.99";

    @Test(groups = {"regression"}, description = "Добавление товара в корзину", retryAnalyzer = Retry.class)
    public void AddToCartButton() {
        String productName = "Sauce Labs Onesie";

        loginPage.login(LOGIN, PASSWORD);
        Assert.assertEquals(productsPage.getProductPrice(productName), PRICE_PRODUCT);
        Assert.assertEquals(productsPage.getProductDescription(productName), DESCRIPTION_PRODUCT);
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCart();
        Assert.assertEquals(yourCartPage.getProductDescription(productName), DESCRIPTION_PRODUCT);
    }
}

