package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.TestListener;

import java.time.Duration;

@Listeners({TestListener.class, InvokedListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected YourCartPage yourCartPage;
    protected CheckoutInfoPage checkoutInfoPage;
    protected CheckoutOverviewPage checkoutOverviewPage;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
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
    public void tearDown() {
        driver.quit();
    }
}
