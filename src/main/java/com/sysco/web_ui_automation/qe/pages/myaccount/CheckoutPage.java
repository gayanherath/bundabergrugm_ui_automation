package com.sysco.web_ui_automation.qe.pages.myaccount;

import com.sysco.web_ui_automation.qe.pages.homepage.HomepagePage;
import org.openqa.selenium.By;

public class CheckoutPage  extends HomepagePage {

    private By txtFirstName=By.xpath("//*[@id=\"billing:firstname\"]");
    private By txtLastName=By.xpath("//*[@id=\"billing:lastname\"]");
    private By btnContinueToDelivery=By.xpath("//*[@id=\"delivery-address-button\"]");
    private By lblDeliveryOptions=By.xpath("//*[@id=\"opc-shipping_method\"]/div[1]/h2");

    public String getFirstName(){
        String firstName=getText(txtFirstName);
        return firstName;
    }

    public String getLastName(){
        String lastName=getText(txtLastName);
        return  lastName;
    }

    public void clickContinueToDelivery(){
        syscoLabUI.click(btnContinueToDelivery);
    }

    public String getDeliveryOptionHeaderText(){
        String deliveryLableText=syscoLabUI.getText(lblDeliveryOptions);
        return deliveryLableText;
    }

    public String getText(By webElementLocation){
        String getText=syscoLabUI.getAttribute(webElementLocation, "value");
        return getText;
    }
}
