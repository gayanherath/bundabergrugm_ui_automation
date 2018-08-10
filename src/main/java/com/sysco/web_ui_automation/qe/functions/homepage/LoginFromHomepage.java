package com.sysco.web_ui_automation.qe.functions.homepage;

import com.sysco.web_ui_automation.qe.pages.homepage.LoginFromHomepagePage;

public class LoginFromHomepage {

    private static LoginFromHomepagePage myAccountFromHomepagePage = new LoginFromHomepagePage();

    public static String getTitle(){
        String myAccountPageTitle=myAccountFromHomepagePage.getPageTitle();
        return myAccountPageTitle;
    }

    public static boolean getEmailTextValidityFlag(){
        boolean isEmailTextBoxPresent = myAccountFromHomepagePage.checkEmailTextBox();
        return isEmailTextBoxPresent;
    }

    public static boolean getPasswordTextValidityFlag() {
        boolean isPasswordTextBoxPresent = myAccountFromHomepagePage.checkPasswordTextBox();
        return isPasswordTextBoxPresent;

    }

    public static boolean getLoginBtnValidityFlag() {
        boolean isLoginBtnPresent = myAccountFromHomepagePage.checkLoginButton();
        return isLoginBtnPresent;
    }

    public static void clickLoginButton(){
        myAccountFromHomepagePage.clickLoginButton();
    }

    public static String getEmailRequiredMessage(){
        String emailRequiredMessage=myAccountFromHomepagePage.getMessageEmailRequired();
        return emailRequiredMessage;
    }

    public static String getPasswordRequiredMessage(){
        String passwordRequiredMessage=myAccountFromHomepagePage.getMessagePasswordRequired();
        return passwordRequiredMessage;
    }

    public static String getInvalidEmailStructureMessage(){
        String invalidEmailStructureMessage=myAccountFromHomepagePage.getInvalidEmailStructureMessage();
        return invalidEmailStructureMessage;
    }

    public static String getInvalidCredentialMessage(){
        String invalidCredentialsMessage=myAccountFromHomepagePage.getMessageInvalidCredentials();
        return invalidCredentialsMessage;
    }

    public static void insertEmailAddress(String email){
        myAccountFromHomepagePage.insertEmailAddress(email);
    }

    public static void insertPassword(String password){
        myAccountFromHomepagePage.insertPasswordAddress(password);
    }

    public static void refreshPage(){
        myAccountFromHomepagePage.refreshBrowserForSlowCase();
    }

    public static String getUserName(){
        String userName=myAccountFromHomepagePage.getUserName();
        return userName;
    }

}
