package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage extends BasePage {

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    private final static By QTY = By.className("cart_quantity_label");
    private final static By ITEM_DESCRIPTION = By.className("inventory_item_desc");
    private final static String ITEM_CONTAINER = "//div[text()='%s']/ancestor::div[@class='cart_item_label']";
    private final static By ITEM_PRICE = By.className("inventory_item_price");
    private final static By REMOVE_BUTTON = By.cssSelector("button[id^='remove']");
    private final static By CHECKOUT_BUTTON = By.cssSelector("button[id=checkout]");

    public boolean isShoppingCardDisplayed() {
        return driver.findElement(QTY).isDisplayed();
    }

    public String getProductDescription(String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
    }

    private WebElement getProductCardByName(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER, productName)));
    }

    public String getProductPrice(String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_PRICE).getText();
    }

    public void clickRemoveButton(String productName) {
        this.getProductCardByName(productName).findElement(REMOVE_BUTTON).click();
    }

    public void clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
