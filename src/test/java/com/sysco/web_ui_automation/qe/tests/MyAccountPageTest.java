package com.sysco.web_ui_automation.qe.tests;
import com.sysco.web_ui_automation.qe.functions.myaccount.*;
import com.sysco.web_ui_automation.qe.common.Constants;
import com.sysco.web_ui_automation.qe.functions.homepage.AgeVerificationFromHomepage;
import com.sysco.web_ui_automation.qe.functions.homepage.Homepage;
import com.sysco.web_ui_automation.qe.functions.homepage.LoginFromHomepage;
import com.sysco.web_ui_automation.qe.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class MyAccountPageTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        syscoLabQCenter.setModule("report_Gayan");
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
        syscoLabQCenter.setClassName(MyAccountPageTest.class.getName());
        Homepage.loadHomePage();
        AgeVerificationFromHomepage.enterValidRequiredAgeLevel("1","January","1991");
        Homepage.loadMyAccountPage();
        LoginFromHomepage.insertEmailAddress(Constants.USER_NAME);
        LoginFromHomepage.insertPassword(Constants.P_W);
        LoginFromHomepage.clickLoginButton();
    }

    @Test(description = "TC-13",priority = 1)
    public void testUserCanAddItemToCart() throws AWTException {
        MyAccount.clickCart();
        MyAccount.clearCart();
        RoyalLiqueurCategoryFromMyAccount.selectRoyalLiqiuorCategory();
        RoyalLiqueurCategoryFromMyAccount.clickPineappleCoconutTropicItem();
        String itemNameFromPage=PineappleCocountTropicFromRLCategory.getItemNameFromPage();
        String itemPriceFromPage=PineappleCocountTropicFromRLCategory.getPriceFromPage();
        PineappleCocountTropicFromRLCategory.clickAddToCart();

        String itemNameFromCart = MyAccount.getItemNameFromCart();
        String itemPriceFromCart = MyAccount.getItemPriceFromCart();

        softAssert.assertEquals(itemNameFromCart,itemNameFromPage, "Added Item's name does not match with item in Cart");
        softAssert.assertEquals(itemPriceFromCart,itemPriceFromPage,"Added Item's price does not match with item in Cart");
        softAssert.assertAll();
    }

    @Test(description = "TC-14",priority = 2)
    public void testUserCanGoToShoppingCartPageClickingCheckout(){
        LoginFromHomepage.refreshPage();
        MyAccount.clickCart();
        MyAccount.clickChechOutButton();
        String pageTitle=ShoppingCart.getPageTitle();
        softAssert.assertEquals(pageTitle,"Shopping Cart","Invalid Page is loaded");
        softAssert.assertAll();
    }

    @Test(description = "TC-15",priority = 3)
    public void testUserCanGoToCheckoutPageClickingProceedToCheckOut(){
        ShoppingCart.clickProceedToCheckOut();

        String pageTitle=Checkout.getPageTitle();
        softAssert.assertEquals(pageTitle,"Checkout","Invalid Page is loaded");

        String firstName=Checkout.getFirstName();
        String lastName=Checkout.getLastName();
        softAssert.assertEquals(firstName,"william","Invalid First Name");
        softAssert.assertEquals(lastName,"jacob","Invalid Last Name");
        softAssert.assertAll();

    }

    @Test(description = "TC-16",priority = 4)
    public void testUserCanNotContinueWithoutMandatoryInputFieldsinCheckout(){
        Checkout.clearMandatoryFields();
        Checkout.clickContinueToDelivery();

        String firstNameFieldRequiredMessage=Checkout.getFirstNameRequiredErrorMessage();
        softAssert.assertEquals(firstNameFieldRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Invalid Error Message");

        String lastNameRequiredMessage=Checkout.getLastNameeRequiredErrorMessage();
        softAssert.assertEquals(lastNameRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Invalid Error Message");

        String address1FieldRequiredMessage=Checkout.getAddress1RequiredErrorMessage();
        softAssert.assertEquals(address1FieldRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Invalid Error Message");

        String postCodeFieldRequiredMessage=Checkout.getPostCodeRequiredErrorMessage();
        softAssert.assertEquals(postCodeFieldRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Invalid Error Message");

        String contactNumberRequiredMessage=Checkout.getContactNumberRequiredErrorMessage();
        softAssert.assertEquals(contactNumberRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Invalid Error Message");

        softAssert.assertAll();
    }

    @Test(description = "TC-17",priority = 5)
    public void testUserCanAddPostCodeWithAutoSuggestion() throws AWTException {
        Checkout.refreshBrowser();
        Checkout.clearPostCodeField();
        Checkout.enter2000AndSelectSecondOneFromSuggestionList();

        String postCode=Checkout.getPostCodeText();
        softAssert.assertEquals(postCode,"2000 DAWES POINT NSW","Invalid Post Code is selected");
        softAssert.assertAll();
    }


    @Test(description = "TC-18",priority = 6)
    public void testUserCanGotoBillingAndShippingInfoWhenClickProceedToCheckout(){
        Checkout.clickContinueToDelivery();
        String getDeliverOptionsHeader=Checkout.getDeliveryOptionHeaderText();
        softAssert.assertEquals(getDeliverOptionsHeader,"DELIVERY OPTIONS","Invalid Header");
        softAssert.assertTrue(Checkout.isCheckoutAuthorizedTrue(),"Checkout Authorization Check box is not marked");
        softAssert.assertAll();
    }

    @Test(description = "TC-19",priority = 7)
    public void testUserIsNotAbleToProceedWithEmptyCCAndCVV(){
        Checkout.clickContinueToPayment();
        Checkout.clickCreditCardOption();
        Checkout.clickPurchaseMyOrder();

        String inputRequiredErrorMessageCC=Checkout.getInputRequiredFieldCreditCard();
        String inputRequiredErrorMessageCVV=Checkout.getInputRequiredFieldCVV();
        softAssert.assertEquals(inputRequiredErrorMessageCC,Constants.INPUT_REQUIRED_MESSAGE,"Invalid Error Message");
        softAssert.assertEquals(inputRequiredErrorMessageCVV,Constants.INPUT_REQUIRED_MESSAGE,"Invalid Error Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-20",priority = 8)
    public void testUserIsNotAbleToProceedWithInvalidAnd8DigitCCInputAndEmptyCVV(){
        Checkout.setCreditCardNumber("12345678");
        Checkout.setCVV("");
        Checkout.clickPurchaseMyOrder();

        String validCCRequiredErrorMessage=Checkout.getValidRequiredCCErrorMessage();
        softAssert.assertEquals(validCCRequiredErrorMessage,"Please enter a valid credit card number.","Invalid Error Message");
        String inputRequiredErrorMessageCVV=Checkout.getInputRequiredFieldCVV();
        softAssert.assertEquals(inputRequiredErrorMessageCVV,Constants.INPUT_REQUIRED_MESSAGE,"Invalid Error Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-21",priority = 9)
    public void testUserIsNotAbleToProceedWithEmptyCCInputAndIncorrectCVV(){
        Checkout.setCreditCardNumber("");
        Checkout.setCVV("321");
        Checkout.clickPurchaseMyOrder();

        String inputRequiredErrorMessageCC=Checkout.getInputRequiredFieldCreditCard();
        softAssert.assertEquals(inputRequiredErrorMessageCC,Constants.INPUT_REQUIRED_MESSAGE,"Invalid Error Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-22",priority = 10)
    public void testUserIsNotAbleToProceedWithInvalidAnd8DigitCCInputAndIncorrectCVV(){
        Checkout.setCreditCardNumber("12345678");
        Checkout.setCVV("321");
        Checkout.clickPurchaseMyOrder();

        String validCCRequiredErrorMessage=Checkout.getValidRequiredCCErrorMessage();
        softAssert.assertEquals(validCCRequiredErrorMessage,"Please enter a valid credit card number.","Invalid Error Message");
        softAssert.assertAll();
    }

   @Test(description = "TC-23",priority = 11)
    public void testUserIsNotAbleToProceedWithInvalidAnd16DigitCCAndIncorrectCVV(){
       Checkout.setCreditCardNumber("1234123412341234");
       Checkout.setCVV("321");
       Checkout.clickPurchaseMyOrder();

       String validCCRequiredErrorMessage=Checkout.getValidRequiredCCErrorMessage();
       softAssert.assertEquals(validCCRequiredErrorMessage,"Please enter a valid credit card number.","Invalid Error Message");
       softAssert.assertAll();
    }


}
