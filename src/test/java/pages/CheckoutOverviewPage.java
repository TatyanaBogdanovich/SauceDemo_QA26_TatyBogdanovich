package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{

    private final static By CHECKOUT_OVERVIEW = By.xpath("//span[text()='Checkout: Overview']");
    private final static By FINISH_BUTTON = By.name("Finish");
    private final static By TOTAL_AMOUNT = By.className("summary_total_label");
    private final static By CHECKOUT_COMPLETE = By.cssSelector("span[class=title]");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }
    public String getPageTitle() {
        return driver.findElement(CHECKOUT_OVERVIEW).getText();
    }

    public String getTotalAmount () {
        return driver.findElement(TOTAL_AMOUNT).getText();
    }
    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }
    public String getCheckoutComplete () {
        return driver.findElement(CHECKOUT_COMPLETE).getText();
    }
}