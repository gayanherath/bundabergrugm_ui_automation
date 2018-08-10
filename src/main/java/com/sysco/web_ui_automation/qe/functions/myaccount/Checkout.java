package com.sysco.web_ui_automation.qe.functions.myaccount;

import com.sysco.web_ui_automation.qe.pages.myaccount.CheckoutPage;

public class Checkout {
    private Checkout(){}

    public static CheckoutPage checkoutPage = new CheckoutPage();

    public static String getPageTitle(){
        String pageTitle=checkoutPage.getTitle();
        return pageTitle;
    }

    public static String getFirstName(){
        String firstName=checkoutPage.getFirstName();
        return firstName;
    }

    public static String getLastName(){
        String lastName=checkoutPage.getLastName();
        return lastName;
    }

    public static void clickContinueToDelivery(){
        checkoutPage.clickContinueToDelivery();
    }

    public static void refreshBrowser(){
        checkoutPage.refreshBrowser();
    }

    public static String getDeliveryOptionHeaderText(){
        String getDeliveryOptionHeaderText=checkoutPage.getDeliveryOptionHeaderText();
        return getDeliveryOptionHeaderText;
    }
}
