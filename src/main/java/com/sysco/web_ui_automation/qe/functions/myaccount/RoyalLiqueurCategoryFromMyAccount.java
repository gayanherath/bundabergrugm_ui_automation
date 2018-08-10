package com.sysco.web_ui_automation.qe.functions.myaccount;


import com.sysco.web_ui_automation.qe.pages.myaccount.RoyalLiqueurCategoryFromMyAccountPage;

public class RoyalLiqueurCategoryFromMyAccount {
    private RoyalLiqueurCategoryFromMyAccount(){}


    public static RoyalLiqueurCategoryFromMyAccountPage royalLiqueurCategoryFromMyAccountPage = new RoyalLiqueurCategoryFromMyAccountPage();

    public static void selectRoyalLiqiuorCategory() {
        royalLiqueurCategoryFromMyAccountPage.selectRoyalLiqueurCategory();
    }

    public static void clickPineappleCoconutTropicItem(){
        royalLiqueurCategoryFromMyAccountPage.clickPineappleCoconutTropicItem();
    }
}
