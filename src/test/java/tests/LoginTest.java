package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = "smoke", description = "Успешная авторизация в приложении")
    public void positiveLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCardDisplayed());
    }

    @Test(groups = {"smoke,regression"}, dataProvider = "negativeLoginTest", description = "Негативный тест на авторизацию и проверка сообщения об ошибке")
    public void negativeLoginTest(String email, String password, String errorMessage) {
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isDisplayMessageError());
        Assert.assertEquals(loginPage.getErrorText(), errorMessage);
    }

    @DataProvider(name = "negativeLoginTest")
    public Object[][] negativeLoginTest() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }
}