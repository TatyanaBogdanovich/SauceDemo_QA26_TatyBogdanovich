package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;
import utils.Retry;

public class CheckoutOverviewTest extends BaseTest {

    @Test(groups = {"regression"}, description = "Проверка введенных данных о пользователе", retryAnalyzer = Retry.class)

    public void checkingPageDisplayTest() {
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckout();
        checkoutInfoPage.setYourInformation("Jon", "Doe", "94043");
        checkoutOverviewPage.getTotalAmount();
        checkoutOverviewPage.clickFinishButton();
        Assert.assertEquals(checkoutCompletePage.getCheckoutComplete(), "Checkout: Complete!");
    }
}
