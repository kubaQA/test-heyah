package test.heyah.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//div[@id='osAppInnerContainer']//main//div[@class='htmlTemplate']")
    private WebElement root;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public WebElement getRoot() {
        return root;
    }
}
