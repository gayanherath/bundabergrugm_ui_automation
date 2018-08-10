package com.sysco.web_ui_automation.qe.functions.myaccount;

import com.sysco.web_ui_automation.qe.pages.myaccount.MyAccountPage;

import java.awt.*;

public class MyAccount {
    private MyAccount(){}

    public static MyAccountPage myAccountPage = new MyAccountPage();

    public static void clickCart(){
        myAccountPage.clickCart();
    }

    public static void clearCart() throws AWTException {
        myAccountPage.checkCartItems();
    }
    public static String getItemNameFromCart(){
        String itemName=myAccountPage.getItemNameFromCart();
        return itemName;
    }

    public static String getItemPriceFromCart(){
        String itemPrice=myAccountPage.getItemPriceFromCart();
        return itemPrice;
    }

    public static void clickChechOutButton(){
        myAccountPage.clickCheckOutButton();
    }

}
