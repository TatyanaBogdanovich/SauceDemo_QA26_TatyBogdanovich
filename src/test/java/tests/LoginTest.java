package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Retry;

public class LoginTest extends BaseTest {

    @Test (groups = "smoke", description = "Успешная авторизация в приложении")
    public void positiveLoginTest(){
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCardDisplayed());
    }

    @DataProvider (name = "Негативные тесты для проверки логина и пароля")
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}

        };
    }
}