package test.heyah.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.heyah.pageObjects.*;
import test.heyah.utils.DriverUtils;
import test.heyah.utils.WaitUtils;

import java.util.Arrays;
import java.util.List;

import static test.heyah.utils.RandomUtils.*;

public class CardOrderOperations {

    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;
    private BasketPage basketPage;
    private DriverUtils driverUtils;
    private PurchaserDataPage purchaserDataPage;
    private DeliveryPage deliveryPage;
    private PaymentPage paymentPage;
    private WaitUtils waitUtils;
    private int timeoutInSec = 10;


    public CardOrderOperations(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
        basketPage = new BasketPage(driver);
        driverUtils = new DriverUtils(driver);
        waitUtils = new WaitUtils(driver);
        purchaserDataPage = new PurchaserDataPage(driver);
        deliveryPage = new DeliveryPage(driver);
        paymentPage = new PaymentPage(driver);

    }

    private WebElement getShadowRootElement(WebElement element) {
        WebElement webElement = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", element);
        return webElement;
    }

    public void clickOrderCardButton() {
        WebElement shadowRoot1 = getShadowRootElement(homePage.getRoot());
        WebElement shadowElement = shadowRoot1.findElement(By.cssSelector("button[class='btn btn-black']"));
        shadowElement.click();
    }

    public void clickOrderButton() {
        driverUtils.clickTheButton(orderPage.getOrderButton());
    }

    public String getOfferName() {
        return driverUtils.getText(orderPage.getOfferName());
    }

    public String getOfferNameFromBasket() {
        return driverUtils.getText(basketPage.getHeyahOfferName());
    }

    public void clickNextButton() {
        driverUtils.clickTheButton(basketPage.getNextButton());
    }

    public void fillEmailField(String email) {
        driverUtils.typeText(basketPage.getEmailField(), email);
    }

    public void fillConfirmEmailField(String email) {
        driverUtils.typeText(basketPage.getConfirmEmailField(), email);
    }

    public void clickNextButtonOnEmailStep() {
        driverUtils.clickTheButton(basketPage.getNextButtonOnEmailStep());
    }

    public void clickNextButtonOnConfirmEmailStep() {
        driverUtils.clickTheButton(basketPage.getNextButtonOnConfirmEmailStep());
    }

    public void clickNextButtonOnVerificationStep() {
        driverUtils.clickTheButton(basketPage.getNextButtonOnVerificationStep());
    }

    public void selectCourier() {
        driverUtils.clickTheButton(basketPage.getVerifyingSelectList());
        driverUtils.clickTheButton(basketPage.getCourierButton());
    }

    public void enterName() {
        driverUtils.typeText(purchaserDataPage.getFirstName(), getRandomString(3, 10));
        driverUtils.clickTheButton(purchaserDataPage.getFirstName());
    }

    public void enterLastName() {
        driverUtils.typeText(purchaserDataPage.getLastName(), getRandomString(3, 10));
        driverUtils.clickTheButton(purchaserDataPage.getLastName());
    }

    public void enterContactNumber() {
        driverUtils.typeText(purchaserDataPage.getContactNumber(), String.valueOf(getRandomInt(100000000, 999999999)));
        driverUtils.clickTheButton(purchaserDataPage.getContactNumber());
    }

    public void enterPesel() {
        driverUtils.typeText(purchaserDataPage.getPesel(), getPesel());
        driverUtils.clickTheButton(purchaserDataPage.getPesel());
    }

    public void enterHomeNumber() {
        driverUtils.typeText(purchaserDataPage.getStreetNumber(), String.valueOf(getRandomInt(1, 100)).toLowerCase());
        driverUtils.clickTheButton(purchaserDataPage.getStreetNumber());
    }

    public void enterCity() {
        driverUtils.typeText(purchaserDataPage.getCity(), getRandomString(3, 10));
        driverUtils.clickTheButton(purchaserDataPage.getCity());
    }

    public void enterPostCode() {
        driverUtils.typeText(purchaserDataPage.getPostCode(), randomPostCode());
        driverUtils.clickTheButton(purchaserDataPage.getPostCode());
    }

    public String randomPostCode() {
        List<String> postCodes = Arrays.asList(
                "08-110",
                "00-001",
                "05-070",
                "05-071",
                "05-074",
                "05-079",
                "05-080",
                "05-082",
                "05-083",
                "05-084",
                "05-085",
                "05-088",
                "05-090"

        );
        return randomItem(postCodes);
    }

    public void clickGoToDeliveryButton() {
        driverUtils.clickTheButton(purchaserDataPage.getTitle());
        driverUtils.bringElementToViewport(purchaserDataPage.getGoToDeliveryButton());
        driverUtils.executeClick(driver, purchaserDataPage.getGoToDeliveryButton());
    }

    public void clickGoToPaymentButton() {
        driverUtils.clickTheButton(deliveryPage.getGoToPaymentButton());
    }

    public void enterCardNumber() {
        waitUtils.waitForVisibilityOf(paymentPage.getiFrameCardNumber(), timeoutInSec);
        driver.switchTo().frame(paymentPage.getiFrameCardNumber());
        driverUtils.clickTheButton(paymentPage.getCreditCardNumberField());
        driverUtils.typeText(paymentPage.getCreditCardNumberField(), generateMasterCardNumber());
        driver.switchTo().defaultContent();
    }

    public void enterCvv() {
        waitUtils.waitForVisibilityOf(paymentPage.getiFrameCvv(), timeoutInSec);
        driver.switchTo().frame(paymentPage.getiFrameCvv());
        driverUtils.clickTheButton(paymentPage.getCvv());
        driverUtils.typeText(paymentPage.getCvv(), String.valueOf(getRandomInt(100, 999)));
        driver.switchTo().defaultContent();
    }

    public void enterCardholderName() {
        String name = getRandomString(3, 10);
        String lastName = getRandomString(3, 15);
        String cardholderName = name + " " + lastName;
        driverUtils.clickTheButton(paymentPage.getCardholderName());
        driverUtils.typeText(paymentPage.getCardholderName(), cardholderName);
    }

    public void enterExpirationDate() {
        waitUtils.waitForVisibilityOf(paymentPage.getiFrameExpirationDate(), timeoutInSec);
        driver.switchTo().frame(paymentPage.getiFrameExpirationDate());
        driverUtils.clickTheButton(paymentPage.getExpirationDate());
        driverUtils.typeText(paymentPage.getExpirationDate(), randomDateGenerator(1, 10));
        driver.switchTo().defaultContent();
    }

    public void clickGoToSummaryFormButton() {
        driverUtils.clickTheButton(paymentPage.getGoToSummaryFormButton());
    }

    public boolean checkIfErrorFieldDisplayed() {
        waitUtils.waitForVisibilityOf(paymentPage.getSomethingWentWrongField(), timeoutInSec);
        return paymentPage.getSomethingWentWrongField().isDisplayed();
    }

}
