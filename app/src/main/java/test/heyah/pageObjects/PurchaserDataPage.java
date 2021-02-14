package test.heyah.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaserDataPage {

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "contactNumber")
    private WebElement contactNumber;

    @FindBy(id = "pesel")
    private WebElement pesel;

    @FindBy(id = "streetNumber")
    private WebElement streetNumber;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "postCode")
    private WebElement postCode;

//    @FindBy(xpath = "//button[@id='goToDeliveryBtn']")
    @FindBy(xpath = "//button")
    private WebElement goToDeliveryButton;

    @FindBy(xpath = "//div[contains(text(),'Dane zamawiającego')]")
    private WebElement title;

    public PurchaserDataPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getContactNumber() {
        return contactNumber;
    }

    public WebElement getPesel() {
        return pesel;
    }

    public WebElement getStreetNumber() {
        return streetNumber;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getPostCode() {
        return postCode;
    }

    public WebElement getGoToDeliveryButton() {
        return goToDeliveryButton;
    }

    public WebElement getTitle() {
        return title;
    }
}
