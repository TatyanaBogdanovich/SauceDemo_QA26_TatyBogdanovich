package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class YourCartTest extends BaseTest {
    @Test(groups = {"smoke"}, dataProvider = "addProductToCard", description = "Проверка  товара добавленного в корзину")
    public void yourCardTest(String productName) {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCart();
        Assert.assertTrue(yourCartPage.isShoppingCardDisplayed());
        yourCartPage.clickCheckout();
    }

    @DataProvider(name = "addProductToCard")
    public Object[][] addProductToCard() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"}};
    }
}

