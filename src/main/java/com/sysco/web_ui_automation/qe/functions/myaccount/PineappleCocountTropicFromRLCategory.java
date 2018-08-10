package com.sysco.web_ui_automation.qe.functions.myaccount;

import com.sysco.web_ui_automation.qe.pages.myaccount.PineappleCocountTropicFromRLCategoryPage;

public class PineappleCocountTropicFromRLCategory {
    private PineappleCocountTropicFromRLCategory(){}

    public static PineappleCocountTropicFromRLCategoryPage pineappleCocountTropicFromRLCategoryPage=new PineappleCocountTropicFromRLCategoryPage();

    public static void clickAddToCart(){
        pineappleCocountTropicFromRLCategoryPage.clickAddToCart();
    }


    public static String getPriceFromPage(){
        String itemPrice=pineappleCocountTropicFromRLCategoryPage.getPrice();
        return itemPrice;
    }

    public static String getItemNameFromPage(){
        String itemPrice=pineappleCocountTropicFromRLCategoryPage.getItemName();
        return itemPrice;
    }
}
