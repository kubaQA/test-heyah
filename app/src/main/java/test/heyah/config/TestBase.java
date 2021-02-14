package test.heyah.config;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.heyah.utils.WaitUtils;

import static test.heyah.config.Constants.BASE_URL;

public abstract class TestBase {

    public WebDriver driver;
    public WaitUtils waitUtils;

    @BeforeClass(alwaysRun = true)
    public void prepareSuite() {
        driver = new DriverFactory().startBrowser();
        waitUtils = new WaitUtils(driver);
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
        waitUtils.waitUntilOnUrl(10, BASE_URL);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
