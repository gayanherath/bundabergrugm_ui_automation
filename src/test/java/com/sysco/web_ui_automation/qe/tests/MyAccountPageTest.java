package com.sysco.web_ui_automation.qe.tests;
import com.sysco.web_ui_automation.qe.functions.myaccount.*;
import com.sysco.web_ui_automation.qe.common.Constants;
import com.sysco.web_ui_automation.qe.functions.homepage.AgeVerificationFromHomepage;
import com.sysco.web_ui_automation.qe.functions.homepage.Homepage;
import com.sysco.web_ui_automation.qe.functions.homepage.LoginFromHomepage;
import com.sysco.web_ui_automation.qe.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class MyAccountPageTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {

        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
    }

    @BeforeClass
    public void loadHomePage(){
        Homepage.loadHomePage();
        AgeVerificationFromHomepage.enterValidRequiredAgeLevel("1","January","1991");
        Homepage.loadMyAccountPage();

        LoginFromHomepage.insertEmailAddress(Constants.USER_NAME);
        LoginFromHomepage.insertPassword(Constants.P_W);
        LoginFromHomepage.clickLoginButton();
    }

    @Test(priority = 1)
    public void testVerifyUserCanAddItemToCart() throws AWTException {
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

    @Test(description = "TC-2",priority = 2)
    public void testVerifyUserCanGoToShoppingCartPageClickingCheckout(){
        LoginFromHomepage.refreshPage();
        MyAccount.clickCart();
        MyAccount.clickChechOutButton();
        String pageTitle=ShoppingCart.getPageTitle();
        softAssert.assertEquals(pageTitle,"Shopping Cart","Invalid Page is loaded");
        softAssert.assertAll();
    }

    @Test(description = "TC-3",priority = 3)
    public void testVerifyUserCanGoToCheckoutPageClickingProceedToCheckOut(){
        ShoppingCart.clickProceedToCheckOut();

        String pageTitle=Checkout.getPageTitle();
        softAssert.assertEquals(pageTitle,"Checkout","Invalid Page is loaded");

        String firstName=Checkout.getFirstName();
        String lastName=Checkout.getLastName();
        softAssert.assertEquals(firstName,"william","Invalid First Name");
        softAssert.assertEquals(lastName,"jacob","Invalid Last Name");
        softAssert.assertAll();

    }

    @Test(description = "TC-MyAccountPageTest-4",priority = 4)
    public void testVerifyUserCanNotContinueWithoutMandatoryInputFieldsinCheckout(){
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

    @Test(description = "TC-MyAccountPageTest-5",priority = 5)
    public void testVerifyUserCanAddPostCodeWithAutoSuggestion() throws AWTException {
        Checkout.refreshBrowser();
        Checkout.clearPostCodeField();
        Checkout.enter2000AndSelectSecondOneFromSuggestionList();

        String postCode=Checkout.getPostCodeText();
        softAssert.assertEquals(postCode,"2000 DAWES POINT NSW","Invalid Post Code is selected");
        softAssert.assertAll();
    }


    @Test(description = "TC-MyAccountPageTest-6",priority = 6)
    public void testVerifyUserCanGotoBillingAndShippingInfoWhenClickProceedToCheckout(){
        Checkout.clickContinueToDelivery();
        String getDeliverOptionsHeader=Checkout.getDeliveryOptionHeaderText();
        softAssert.assertEquals(getDeliverOptionsHeader,"DELIVERY OPTIONS","Invalid Header");
        softAssert.assertTrue(Checkout.isCheckoutAuthorizedTrue(),"Checkout Authorization Check box is not marked");
        softAssert.assertAll();
    }

    @Test(description = "TC-MyAccountPageTest-7",priority = 7)
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

    @Test(description = "TC-MyAccountPageTest-8",priority = 8)
    public void testUserIsNotAbleToProceedWithInvalidAnd8DigitCCInputAndIncorrectCVV(){
        Checkout.setCreditCardNumber("12345678");
        Checkout.setCVV("321");
        Checkout.clickPurchaseMyOrder();

        String inputRequiredErrorMessageCC=Checkout.getInputRequiredFieldCreditCard();
        String inputRequiredErrorMessageCVV=Checkout.getInputRequiredFieldCVV();
        softAssert.assertEquals(inputRequiredErrorMessageCC,Constants.INPUT_REQUIRED_MESSAGE,"Invalid Error Message");
        softAssert.assertEquals(inputRequiredErrorMessageCVV,Constants.INPUT_REQUIRED_MESSAGE,"Invalid Error Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-MyAccountPageTest-9",priority = 9)
    public void testUserIsNotAbleToProceedWithInvalidAnd16DigitCCAndIncorrectCVV(){

    }




}
