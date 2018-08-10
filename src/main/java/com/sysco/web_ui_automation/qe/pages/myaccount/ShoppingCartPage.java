package com.sysco.web_ui_automation.qe.pages.myaccount;

import com.sysco.web_ui_automation.qe.pages.homepage.HomepagePage;
import org.openqa.selenium.By;

public class ShoppingCartPage extends HomepagePage {

    private By btnProceedToCheckOut=By.xpath("/html/body/div[2]/div[3]/div[2]/div/div[1]/div[1]/div/ul/li[2]/button");

    public void clickProceedToCheckOut(){
        syscoLabUI.click(btnProceedToCheckOut);
    }



}
