package com.sysco.web_ui_automation.qe.pages.myaccount;

import com.sysco.web_ui_automation.qe.pages.homepage.HomepagePage;
import org.openqa.selenium.By;

public class PineappleCocountTropicFromRLCategoryPage extends HomepagePage {

    private By btnAddToCart=By.xpath("//*[@id=\"price-inner-content\"]/div[2]/div/div[2]/button");
    private By lblPrice=By.xpath("//*[@id=\"product-price-1712\"]/span");
    private By lblItemName=By.xpath("//*[@id=\"product-info\"]/div/div[1]/h1");


    public String  getPrice(){
        String price = syscoLabUI.getText(lblPrice);
        return price;
    }

    public String getItemName(){
        String itemName=syscoLabUI.getText(lblItemName);
        return itemName;
    }

    public void clickAddToCart(){
        syscoLabUI.click(btnAddToCart);
        syscoLabUI.sleep(2);
    }






}
