package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {
    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_POSTAL_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstNameValue(String firstNameValue) {
        driver.findElement(FIRST_NAME).sendKeys(firstNameValue);
    }

    public void setLastNameValue(String lastNameValue) {
        driver.findElement(LAST_NAME).sendKeys(lastNameValue);
    }

    public void setZipCodeValue(String zipCodeValue) {
        driver.findElement(ZIP_POSTAL_CODE).sendKeys(zipCodeValue);
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void setYourInformation(String firstNameValue, String lastNameValue, String zipCodeValue) {
        setFirstNameValue(firstNameValue);
        setLastNameValue(lastNameValue);
        setZipCodeValue(zipCodeValue);
        clickContinueButton();
    }

    public boolean isFirstNameDisplayed() {
        return driver.findElement(FIRST_NAME).isDisplayed();
    }

    public boolean isLastNameDisplayed() {
        return driver.findElement(LAST_NAME).isDisplayed();
    }

    public boolean isZipCodeDisplayed() {
        return driver.findElement(ZIP_POSTAL_CODE).isDisplayed();
    }
}