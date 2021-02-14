package test.heyah.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    @FindBy(xpath = "//span[contains(text(),'zamów')]/parent::button")
    private WebElement orderButton;

    @FindBy(xpath = "//div[@data-qa='TRF_Name0']")
    private WebElement offerName;

    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getOrderButton() {
        return orderButton;
    }

    public WebElement getOfferName() {
        return offerName;
    }
}
