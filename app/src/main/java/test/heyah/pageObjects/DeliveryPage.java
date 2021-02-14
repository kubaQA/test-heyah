package test.heyah.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryPage {

    @FindBy(id = "goToPaymentBtnForm2")
    private WebElement goToPaymentButton;

    public DeliveryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getGoToPaymentButton() {
        return goToPaymentButton;
    }
}
