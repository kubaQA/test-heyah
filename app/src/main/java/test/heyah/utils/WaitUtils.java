package test.heyah.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WaitUtils {

    private WebDriver driver;
    private int defaultMaxTimeoutForAllWaits = 200;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilOnUrl(int timeoutInSeconds, String url) {
        new WebDriverWait(driver, timeoutInSeconds)
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(WebDriverException.class)
                .until(urlContains(url));
    }

    public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds)
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(WebDriverException.class)
                .until(elementToBeClickable(element));
    }

    public void waitForVisibilityOf(WebElement element, int maxTimeInSeconds) {
        new WebDriverWait(driver, maxTimeInSeconds)
                .until(visibilityOf(element));
    }

    public void waitForInvisibilityOfElement(WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds)
                .until(invisibilityOf(element));
    }

}
