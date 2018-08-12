package com.sysco.web_ui_automation.qe.functions.myaccount;

import com.sysco.web_ui_automation.qe.pages.myaccount.CheckoutPage;

import java.awt.*;

public class Checkout {
    private Checkout(){}

    public static CheckoutPage checkoutPage = new CheckoutPage();

    public static String getPageTitle(){
        return checkoutPage.getTitle();
    }

    public static String getFirstName(){
        return checkoutPage.getFirstName();
    }

    public static String getLastName(){
        return checkoutPage.getLastName();
    }

    public static void clickContinueToDelivery(){
        checkoutPage.clickContinueToDelivery();
    }

    public static void refreshBrowser(){
        checkoutPage.refreshBrowser();
    }

    public static String getDeliveryOptionHeaderText(){
        return checkoutPage.getDeliveryOptionHeaderText();
    }

    public static void clearMandatoryFields(){
        checkoutPage.clearMandatoryFields();
    }

    public static String getFirstNameRequiredErrorMessage(){
        return checkoutPage.getFirstNameRequiredError();
    }

    public static String getLastNameeRequiredErrorMessage(){
        return checkoutPage.getLastNameRequiredError();
    }

    public static String getAddress1RequiredErrorMessage(){
        return checkoutPage.getAddress1RequiredError();
    }

    public static String getPostCodeRequiredErrorMessage(){
        return checkoutPage.getPostCodeRequiredError();
    }

    public static String getContactNumberRequiredErrorMessage(){
        return checkoutPage.getContactNumberRequiredError();
    }

    public static void clearPostCodeField(){
        checkoutPage.clearPostCodeFieldFields();
    }

    public static void enter2000AndSelectSecondOneFromSuggestionList() throws AWTException {
        checkoutPage.enter2000PostCodeAndSelectSecondOptionFromSuggestionList();
    }

    public static String getPostCodeText(){
        return checkoutPage.getPostCodeText();
    }

    public static Boolean isCheckoutAuthorizedTrue(){
        return checkoutPage.isCheckoutAuthorizedTrue();
    }

    public static void clickContinueToPayment(){
        checkoutPage.clickContiunueToPayment();
    }

    public static void clickCreditCardOption(){
        checkoutPage.clickCreditCardPaymentMethodRadioButton();
    }

    public static void clickPurchaseMyOrder(){
        checkoutPage.clickPurchaseMyOrderButton();
    }

    public static String getInputRequiredFieldCreditCard(){
        return checkoutPage.getInputRequiredFieldCreditCard();
    }

    public static String getInputRequiredFieldCVV(){
        return checkoutPage.getInputRequiredFieldCVV();
    }

    public static String getValidRequiredCCErrorMessage(){
        return checkoutPage.getValidCCRequiredErrorMessage();
    }

    public static void setCreditCardNumber(String creditCard){
        checkoutPage.setCreditCardNumber(creditCard);
    }

    public static void setCVV(String cvv){
        checkoutPage.setCVV(cvv);
    }


}
