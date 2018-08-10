package com.sysco.web_ui_automation.qe.pages.myaccount;


import com.sysco.web_ui_automation.qe.pages.homepage.HomepagePage;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MyAccountPage extends HomepagePage {

    private By lnkCart=By.xpath("//*[@id=\"cartHeader\"]");
    private By lblEmptyCart=By.className("cart-empty");
    private By lnkRemove=By.className("btn-remove");
    private By lnkFirstRemove=By.xpath("//*[@id=\"mini-cart\"]/li[1]/div/div/a[2]");
    private By drpDwnProducts=By.xpath("//*[@id=\"nav-wrapper\"]/div/ul[1]/li[1]/a");
    private By lnkRoyalLiqueurCategory=By.xpath("//*[@id=\"nav-wrapper\"]/div/div[4]/div[1]/div[1]/ul/li/ul/li[2]/a");

    public void clickCart(){
        syscoLabUI.click(lnkCart);
        syscoLabUI.sleep(3);
    }

    public void checkCartItems() throws AWTException {
        if(syscoLabUI.findElements(lblEmptyCart).size()!=0){
            System.out.print("Cart eka his");
        }else{
            removeItemsFromCart();
        }
    }

    public void removeItemsFromCart() throws AWTException {
        System.out.print(syscoLabUI.findElements(lnkRemove).size());

        syscoLabUI.click(lnkFirstRemove);
        syscoLabUI.sleep(5);

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        syscoLabUI.sleep(5);
        clickCart();
        checkCartItems();
    }

    public void selectRoyalLiqueurCategory(){
        syscoLabUI.click(drpDwnProducts);
        syscoLabUI.selectFromDropDown(lnkRoyalLiqueurCategory,);
    }


}
