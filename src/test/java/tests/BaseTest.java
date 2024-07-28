package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected YourCartPage yourCartPage;
    protected CheckoutInfoPage checkoutInfoPage;
    protected CheckoutOverviewPage checkoutOverviewPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp()
    {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.yourCartPage = new YourCartPage(driver);
        this.checkoutInfoPage = new CheckoutInfoPage(driver);
        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
        loginPage.open();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
