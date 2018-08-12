package com.sysco.web_ui_automation.qe.pages.myaccount;

import com.sysco.web_ui_automation.qe.pages.homepage.HomepagePage;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CheckoutPage  extends HomepagePage {

    private By txtFirstName=By.xpath("//*[@id=\"billing:firstname\"]");
    private By txtLastName=By.xpath("//*[@id=\"billing:lastname\"]");
    private By txtAddress1=By.xpath("//*[@id=\"billing:street1\"]");
    private By txtAddress2=By.xpath("//*[@id=\"billing:street2\"]");
    private By txtContactNumber=By.xpath("//*[@id=\"billing:telephone\"]");
    private By btnPostCode=By.xpath("//*[@id=\"billing:postcodesuburbremove\"]");
    private By btnContinueToDelivery=By.xpath("//*[@id=\"delivery-address-button\"]");
    private By lblDeliveryOptions=By.xpath("//*[@id=\"opc-shipping_method\"]/div[1]/h2");
    private By lblFirstNameFieldRequiredError=By.xpath("//*[@id=\"advice-required-entry-billing:firstname\"]");
    private By lblLastNameFieldRequiredError=By.xpath("//*[@id=\"advice-required-entry-billing:lastname\"]");
    private By lblAddress1FieldRequiredError=By.xpath("//*[@id=\"advice-required-entry-billing:street1\"]");
    private By lblPostCodeFieldRequiredError=By.xpath("//*[@id=\"advice-required-entry-billing:postcodesuburb\"]");
    private By lblContactNumberRequiredError=By.xpath("//*[@id=\"advice-required-entry-billing:telephone\"]");
    private By txtPostCode=By.xpath("//*[@id=\"billing:postcodesuburb\"]");
    private By lblSecondOptionFromSuggetionPostCode=By.xpath("//*[@id=\"Autocomplete_billing:postcodesuburb\"]/div[2]");
    private By chkDeliveryConfirm=By.xpath("//*[@id=\"ns-checkout-shipping-authorize_mm\"]");
    private By btnContinueToPayment=By.xpath("//*[@id=\"shipping-method-button\"]");
    private By rdBtnCreditCardPaymentMethod=By.xpath("//*[@id=\"checkout-payment-method-load\"]/div[1]/dt/label");
    private By btnPurchaseMyOrder=By.xpath("//*[@id=\"payment-method-button\"]");
    private By lblCreditCardInputRequiredValidationError=By.xpath("//*[@id=\"advice-required-entry-braintree_cc_number\"]");
    private By lblCVVInputRequiredValidationError=By.xpath("//*[@id=\"advice-required-entry-braintree_cc_cid\"]");
    private By txtCreditCard=By.xpath("//*[@id=\"braintree_cc_number\"]");
    private By txtCVV=By.xpath("//*[@id=\"braintree_cc_cid\"]");
    private By lblValidCCRequiredMessage=By.xpath("//*[@id=\"advice-validate-cc-number-braintree_cc_number\"]");

    public String getFirstName(){
        return getTextFromAttribute(txtFirstName);
    }

    public String getLastName(){
        return getTextFromAttribute(txtLastName);
    }

    public void clickContinueToDelivery(){
        syscoLabUI.click(btnContinueToDelivery);
        syscoLabUI.sleep(4);
    }

    public String getDeliveryOptionHeaderText(){
        return syscoLabUI.getText(lblDeliveryOptions);
    }

    public String getPostCodeText(){
        syscoLabUI.sleep(2);
        return getTextFromAttribute(txtPostCode);
    }

    public String getTextFromAttribute(By webElementLocation){
        String getTextFromAttribute=syscoLabUI.getAttribute(webElementLocation, "value");
        return getTextFromAttribute;
    }

    public void clearMandatoryFields(){
        syscoLabUI.clear(txtFirstName);
        syscoLabUI.sleep(1);
        syscoLabUI.clear(txtLastName);
        syscoLabUI.sleep(1);
        syscoLabUI.clear(txtAddress1);
        syscoLabUI.sleep(1);
        syscoLabUI.clear(txtAddress2);
        syscoLabUI.sleep(1);
        syscoLabUI.click(btnPostCode);
        syscoLabUI.sleep(1);
        syscoLabUI.clear(txtContactNumber);
        syscoLabUI.sleep(1);
    }

    public void clearPostCodeFieldFields(){
        syscoLabUI.click(btnPostCode);
        syscoLabUI.sleep(1);

    }

    public String getFirstNameRequiredError(){
        return getLblText(lblFirstNameFieldRequiredError);
    }

    public String getLastNameRequiredError(){
        return getLblText(lblLastNameFieldRequiredError);
    }

    public String getAddress1RequiredError(){
        return getLblText(lblAddress1FieldRequiredError);
    }

    public String getPostCodeRequiredError(){
        return getLblText(lblPostCodeFieldRequiredError);
    }

    public String getContactNumberRequiredError(){
        return getLblText(lblContactNumberRequiredError);
    }

    public String getInputRequiredFieldCreditCard(){
        syscoLabUI.sleep(2);
        return getLblText(lblCreditCardInputRequiredValidationError);
    }

    public String getInputRequiredFieldCVV(){
        syscoLabUI.sleep(2);
        return getLblText(lblCVVInputRequiredValidationError);
    }

    public String getValidCCRequiredErrorMessage(){
        syscoLabUI.sleep(2);
        return getLblText(lblValidCCRequiredMessage);
    }

    public String getLblText(By webElementLocation){
        String getLblText=syscoLabUI.getText(webElementLocation);
        return getLblText;
    }

    public void enter2000PostCodeAndSelectSecondOptionFromSuggestionList() throws AWTException {
        syscoLabUI.sendKeys(txtPostCode,"2000");
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        syscoLabUI.sleep(2);
        syscoLabUI.click(lblSecondOptionFromSuggetionPostCode);

    }

    public Boolean isCheckoutAuthorizedTrue(){
        return syscoLabUI.isSelected(chkDeliveryConfirm);
    }

    public void clickContiunueToPayment(){
        syscoLabUI.click(btnContinueToPayment);
    }

    public void clickCreditCardPaymentMethodRadioButton(){
        syscoLabUI.sleep(1);
        syscoLabUI.mouseHover(rdBtnCreditCardPaymentMethod);
        syscoLabUI.sleep(1);
        syscoLabUI.click(rdBtnCreditCardPaymentMethod);
        syscoLabUI.sleep(1);
    }

    public void clickPurchaseMyOrderButton(){
        syscoLabUI.click(btnPurchaseMyOrder);
    }

    public void setCreditCardNumber(String cc){
        syscoLabUI.sendKeys(txtCreditCard,cc);
        syscoLabUI.sleep(1);
    }

    public void setCVV(String cvv){
        syscoLabUI.sendKeys(txtCVV,cvv);
        syscoLabUI.sleep(1);
    }

    public void clearCreditCardField(){
        syscoLabUI.clear(txtCreditCard);
    }

    public void clearCVV(){
        syscoLabUI.clear(txtCVV);
    }





}
