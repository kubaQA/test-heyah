package test.heyah.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class WaitUtils {
    private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilOnUrl(int timeoutInSeconds, String url) {
        new WebDriverWait(driver, timeoutInSeconds)
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(WebDriverException.class)
                .until(urlContains(url));
    }
}
