package com.sysco.web_ui_automation.qe.functions.myaccount;

import com.sysco.web_ui_automation.qe.pages.myaccount.ShoppingCartPage;

public class ShoppingCart {
    private ShoppingCart(){}

    public static ShoppingCartPage shoppingCartPage=new ShoppingCartPage();

    public static String getPageTitle(){
        String pageTitle=shoppingCartPage.getTitle();
        return pageTitle;
    }

    public static void clickProceedToCheckOut(){
        shoppingCartPage.clickProceedToCheckOut();
    }



}
