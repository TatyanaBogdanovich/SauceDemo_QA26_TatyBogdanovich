package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
        private final static String ITEM_CONTAINER = "//div[text()='%s']/ancestor::div[@class='inventory_item']";
        private final static By SHOPPING_CART = By.className("shopping_cart_link");
        private final static By ADD_TO_CART_BUTTON = By.cssSelector("button[id^=add-to-cart]");
        private final static By REMOVE_TO_CART_BUTTON = By.cssSelector("button[id^=remove]");

        private final static By ITEM_PRICE = By.className("inventory_item_price");
        private final static By ITEM_DESCRIPTION = By.className("inventory_item_desc");

    public ProductsPage(WebDriver driver) {
            super(driver);
        }
        public boolean isShoppingCardDisplayed() {
            return driver.findElement(SHOPPING_CART).isDisplayed();
        }
        public void clickAddToCartButton(String productName) {
            this.getProductCardByName(productName).findElement(ADD_TO_CART_BUTTON).click();
        }
        public String getProductPrice(String productName) {
            return this.getProductCardByName(productName).findElement(ITEM_PRICE).getText();
        }
        public String getProductDescription(String productName) {
            return this.getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
        }
        public String getNameOfButtonRemoveProduct (String productName) {
            return this.getProductCardByName(productName).findElement(REMOVE_TO_CART_BUTTON).getText();
        }
        public void clickShoppingCart() {
            driver.findElement(SHOPPING_CART).click();
        }
        private WebElement getProductCardByName(String productName) {
            return driver.findElement(By.xpath(String.format(ITEM_CONTAINER, productName)));
        }
    }

