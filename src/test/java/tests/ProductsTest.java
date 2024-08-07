package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

import static pages.ProductsPage.*;
import static pages.ProductsPage.DESCRIPTION_PRODUCT;

public class ProductsTest extends BaseTest {

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

