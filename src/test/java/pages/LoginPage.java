package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class LoginPage extends BasePage {

    private static final By EMAIL_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("h3[data-test=error]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step ("Перейти на сайт SauceDemo")
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }
    @Step ("Заполнить поле Username")
    public void setEmailValue(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }
    @Step ("Заполнить поле Password")
    public void setPasswordValue(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }
    @Step ("Нажать на кнопку Login")
    public void clickLoginButton() {
        AllureUtils.attachScreenshot(driver);
        driver.findElement(LOGIN_BUTTON).click();
    }
    @Step ("Сообщение об ошибке")
    public boolean isDisplayMessageError() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }
    @Step ("Сообщение об ошибке")
    public String getErrorText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    @Step ("Ввести валидные логин и пароль")
    public void login(String email, String password) {
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
    }
}