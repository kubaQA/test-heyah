package test.heyah.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    @FindBy(xpath = "//input[@id='credit-card-number']")
    private WebElement creditCardNumberField;

    @FindBy(name = "cardholderName")
    private WebElement cardholderName;

    @FindBy(name = "expiration")
    private WebElement expirationDate;

    @FindBy(name = "cvv")
    private WebElement cvv;

    @FindBy(id = "braintree-hosted-field-number")
    private WebElement iFrameCardNumber;

    @FindBy(id = "braintree-hosted-field-expirationDate")
    private WebElement iFrameExpirationDate;

    @FindBy(id = "braintree-hosted-field-cvv")
    private WebElement iFrameCvv;

    @FindBy(css = "button[id='goToSummaryForm3']")
    private WebElement goToSummaryFormButton;

    @FindBy(xpath = "//div[@id='osAppInnerContainer']/descendant::section/descendant::div[contains(text(),'Coś poszło nie tak')]")
    private WebElement somethingWentWrongField;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getCreditCardNumberField() {
        return creditCardNumberField;
    }

    public WebElement getCardholderName() {
        return cardholderName;
    }

    public WebElement getExpirationDate() {
        return expirationDate;
    }

    public WebElement getCvv() {
        return cvv;
    }

    public WebElement getiFrameCardNumber() {
        return iFrameCardNumber;
    }

    public WebElement getiFrameExpirationDate() {
        return iFrameExpirationDate;
    }

    public WebElement getiFrameCvv() {
        return iFrameCvv;
    }

    public WebElement getGoToSummaryFormButton() {
        return goToSummaryFormButton;
    }

    public WebElement getSomethingWentWrongField() {
        return somethingWentWrongField;
    }
}
