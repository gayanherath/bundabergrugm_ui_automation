package com.sysco.web_ui_automation.qe.pages.homepage;

import org.openqa.selenium.By;

public class AgeVerificationFromHomepagePage extends HomepagePage {

    private By drpDwnSelectDay = By.xpath("//*[@id=\"age_select_day\"]");
    private By drpDwnSelectMonth = By.xpath("//*[@id=\"age_select_month\"]");
    private By drpDwnSelectYear = By.xpath("//*[@id=\"age_select_year\"]");
    private By btnAgeConfirm = By.xpath("//*[@id=\"age_confirm_btn\"]");
    private By lblAgeValidationMessage = By.xpath("//*[@id=\"age_missing_message\"]/span");
    private By chkAgeRemember =By.xpath("//*[@id=\"age_remember_label\"]/span");

    public void uncheckRememberMeOnThisDevice(){
        syscoLabUI.click(chkAgeRemember);
    }

    public void setAge(String day, String month, String year){
        syscoLabUI.sleep(1);
        syscoLabUI.selectFromDropDown(drpDwnSelectDay,day);
        syscoLabUI.sleep(1);
        syscoLabUI.selectFromDropDown(drpDwnSelectMonth,month);
        syscoLabUI.sleep(1);
        syscoLabUI.selectFromDropDown(drpDwnSelectYear,year);
    }

    public void clickEnterButton(){
        syscoLabUI.click(btnAgeConfirm);
    }

    public String getAgeVerificationMessage(){
        syscoLabUI.sleep(1);
        String ageVerificationMessage= syscoLabUI.getText(lblAgeValidationMessage);
        return ageVerificationMessage;
    }

}
