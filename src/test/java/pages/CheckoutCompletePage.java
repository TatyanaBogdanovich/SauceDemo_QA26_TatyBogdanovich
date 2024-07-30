package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By FINAL_MESSAGE = By.cssSelector("h2[data-test=complete-header]");
    private final By BACK_HOME_BUTTON = By.id("back-to-products");
    private final static By CHECKOUT_COMPLETE = By.cssSelector("span[class=title]");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplaySuccessMessage() {
        return driver.findElement(FINAL_MESSAGE).isDisplayed();
    }

    public void clickToBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }

    public String getCheckoutComplete() {
        return driver.findElement(CHECKOUT_COMPLETE).getText();
    }
}

