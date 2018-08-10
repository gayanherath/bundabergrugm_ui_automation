package com.sysco.web_ui_automation.qe.pages.myaccount;


import com.sysco.web_ui_automation.qe.pages.homepage.HomepagePage;
import org.openqa.selenium.By;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyAccountPage extends HomepagePage {

    private By lnkCart=By.xpath("//*[@id=\"cartHeader\"]");
    private By lblEmptyCart=By.className("cart-empty");
    private By lnkFirstRemove=By.xpath("//*[@id=\"mini-cart\"]/li[1]/div/div/a[2]");
    private By lblItemName=By.xpath("//*[@id=\"mini-cart\"]/li/div/p/a");
    private By lblItemPrice=By.xpath("//*[@id=\"mini-cart\"]/li/div/table/tbody/tr[2]/td/span");
    private By btnCheckOut=By.xpath("//*[@id=\"topCartContent\"]/div/div/div/button");

    public void clickCart(){
        syscoLabUI.click(lnkCart);
        syscoLabUI.sleep(3);
    }

    public void checkCartItems() throws AWTException {
        if(syscoLabUI.findElements(lblEmptyCart).size()!=0){
            clickCart();
        }else{
            removeItemsFromCart();
        }
    }

    public void removeItemsFromCart() throws AWTException {
        syscoLabUI.click(lnkFirstRemove);
        syscoLabUI.sleep(5);

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        syscoLabUI.sleep(5);
        clickCart();
        checkCartItems();
    }

    public String getItemNameFromCart(){
        String itemName=syscoLabUI.getText(lblItemName);
        return itemName;
    }

    public String getItemPriceFromCart(){
        String itemPrice=syscoLabUI.getText(lblItemPrice);
        return itemPrice;
    }

    public void clickCheckOutButton(){
        syscoLabUI.click(btnCheckOut);
        syscoLabUI.sleep(4);
    }







}
