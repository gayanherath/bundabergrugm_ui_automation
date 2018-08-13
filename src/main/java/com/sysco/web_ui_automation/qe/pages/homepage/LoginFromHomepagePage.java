package com.sysco.web_ui_automation.qe.pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginFromHomepagePage extends HomepagePage{

    private By txtEmail = By.xpath("//*[@id=\"email\"]");
    private By txtPassword = By.xpath("//*[@id=\"pass\"]");
    private By btnLogin = By.xpath("//*[@id=\"send2\"]/span/span");
    private By lblRequiredFieldEmail=By.xpath("//*[@id=\"advice-required-entry-email\"]");
    private By lblInvalidEmailStructure=By.xpath("//*[@id=\"advice-validate-email-email\"]");
    private By lblRequiredFieldPassword=By.xpath("//*[@id=\"advice-required-entry-pass\"]");
    private By lblInvalidCredential=By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/ul/li/ul/li/span");
    private By lblUserName=By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[1]/h2");



    public String getPageTitle(){
        syscoLabUI.sleep(3);
        String pageTitle = syscoLabUI.getTitle();
        return pageTitle;
    }

    public boolean checkEmailTextBox(){
        Boolean isPresentEmailTxtBox = checkWebElementPresense(txtEmail);
        return isPresentEmailTxtBox;
    }

    public boolean checkPasswordTextBox(){
        Boolean isPresentPasswordTxtBox = checkWebElementPresense(txtPassword);
        return isPresentPasswordTxtBox;
    }

    public boolean checkLoginButton(){
        Boolean isPresentLoginButton = checkWebElementPresense(btnLogin);
        return isPresentLoginButton;
    }

    public boolean checkWebElementPresense(By webElementLocation){
        List<WebElement> webElemelentList=syscoLabUI.findElements(webElementLocation);
        Boolean isPresentWebElement = webElemelentList.size()!=0 && webElemelentList.size()==1 ;
        return isPresentWebElement;
    }

    public void clickLoginButton(){
        syscoLabUI.sleep(3);
        syscoLabUI.click(btnLogin);
        syscoLabUI.sleep(2);
    }

    public String getMessageEmailRequired(){
        String emailRequiredMessage=syscoLabUI.getText(lblRequiredFieldEmail);
        return emailRequiredMessage;
    }

    public String getInvalidEmailStructureMessage(){
        String invalidEmailStructureMessage=syscoLabUI.getText(lblInvalidEmailStructure);
        return invalidEmailStructureMessage;
    }

    public String getMessagePasswordRequired(){
        String passwordRequiredMessage=syscoLabUI.getText(lblRequiredFieldPassword);
        return passwordRequiredMessage;
    }

    public String getMessageInvalidCredentials(){
        String invalidCredential=syscoLabUI.getText(lblInvalidCredential);
        return invalidCredential;
    }



    public void insertEmailAddress(String email){
        syscoLabUI.sendKeys(txtEmail,email);
    }

    public void insertPasswordAddress(String password){
        syscoLabUI.sendKeys(txtPassword,password);
    }


    public String getUserName(){
        String userName=syscoLabUI.getText(lblUserName);
        return userName;
    }


}
