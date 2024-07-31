package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class CheckoutOverviewPage extends BasePage {

    private final static By CHECKOUT_OVERVIEW = By.xpath("//span[text()='Checkout: Overview']");
    private final static By FINISH_BUTTON = By.cssSelector("button[id=finish]");
    private final static By TOTAL_AMOUNT = By.className("summary_total_label");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.findElement(CHECKOUT_OVERVIEW).getText();
    }

    public String getTotalAmount() {
        return driver.findElement(TOTAL_AMOUNT).getText();
    }

    public void clickFinishButton() {
        AllureUtils.attachScreenshot(driver);
        driver.findElement(FINISH_BUTTON).click();
    }
}