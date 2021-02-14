package test.heyah;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.heyah.config.TestBase;
import test.heyah.operations.CardOrderOperations;

import static test.heyah.utils.RandomUtils.getRandomString;

public class HeyahTest extends TestBase {

    private CardOrderOperations cardOrderOperations;

    private String randomEmail;

    @BeforeClass
    public void initOperations() {
        cardOrderOperations = new CardOrderOperations(driver);
        randomEmail = getRandomString(3, 10).toLowerCase() + "@gmail.com";
    }

    @Test
    public void testHeyah() {
        cardOrderOperations.clickOrderCardButton();
        String offerNameInOrderPage = cardOrderOperations.getOfferName();
        cardOrderOperations.clickOrderButton();
        String offerNameInBasket = cardOrderOperations.getOfferNameFromBasket();
        Assert.assertEquals(offerNameInOrderPage, offerNameInBasket);
        cardOrderOperations.clickNextButton();
        cardOrderOperations.fillEmailField(randomEmail);
        cardOrderOperations.clickNextButtonOnEmailStep();
        cardOrderOperations.fillConfirmEmailField(randomEmail);
        cardOrderOperations.clickNextButtonOnConfirmEmailStep();
        cardOrderOperations.selectCourier();
        cardOrderOperations.clickNextButtonOnVerificationStep();
        cardOrderOperations.enterName();
        cardOrderOperations.enterPesel();
        cardOrderOperations.enterLastName();
        cardOrderOperations.enterContactNumber();
        cardOrderOperations.enterHomeNumber();
        cardOrderOperations.enterPostCode();
        cardOrderOperations.enterCity();
        cardOrderOperations.clickGoToDeliveryButton();
        cardOrderOperations.clickGoToPaymentButton();
        cardOrderOperations.enterCardholderName();
        cardOrderOperations.enterCardNumber();
        cardOrderOperations.enterCvv();
        cardOrderOperations.enterExpirationDate();
        cardOrderOperations.clickGoToSummaryFormButton();
        Assert.assertTrue(cardOrderOperations.checkIfErrorFieldDisplayed());
    }
}
