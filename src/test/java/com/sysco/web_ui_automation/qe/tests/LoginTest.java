package com.sysco.web_ui_automation.qe.tests;

import com.sysco.web_ui_automation.qe.common.Constants;
import com.sysco.web_ui_automation.qe.functions.homepage.AgeVerificationFromHomepage;
import com.sysco.web_ui_automation.qe.functions.homepage.Homepage;
import com.sysco.web_ui_automation.qe.functions.homepage.LoginFromHomepage;
import com.sysco.web_ui_automation.qe.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Homepage - ValidLogin");
    }

    @BeforeClass
    public void loadHomePage(){
        Homepage.loadHomePage();
        AgeVerificationFromHomepage.enterValidRequiredAgeLevel("1","January","1991");
    }

    @Test(description = "TC-1",priority = 1)
    public void testVerifyMyAccountPage(){
        Homepage.loadMyAccountPage();

        //Page Title Verification
        String myAccountPageTitle=LoginFromHomepage.getTitle();
        softAssert.assertEquals(myAccountPageTitle,"Customer Login", "Invalid Page is loaded");

        //Email Text Box Availability Verification
        boolean ispresentEmailTextBox=LoginFromHomepage.getEmailTextValidityFlag();
        softAssert.assertEquals(ispresentEmailTextBox,true,"Email Text Box is not exist");

        //Password Text Box Availability Verification
        boolean ispresentPasswordTextBox=LoginFromHomepage.getPasswordTextValidityFlag();
        softAssert.assertEquals(ispresentPasswordTextBox,true,"Password Text Box is not exist");

        //Login Button Availability Verification
        boolean ispresentLoginBtn=LoginFromHomepage.getLoginBtnValidityFlag();
        softAssert.assertEquals(ispresentLoginBtn,true,"Login Button is not exist");

        softAssert.assertAll();
    }

    @Test(description = "TC-2",priority = 2)
    public void testVerifyErrorMessageForLoginAttemptWithNoCredentials(){
        LoginFromHomepage.clickLoginButton();

        String emailRequiredMessage=LoginFromHomepage.getEmailRequiredMessage();
        String passwordRequiredMessage=LoginFromHomepage.getPasswordRequiredMessage();

        softAssert.assertEquals(emailRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Inproper Error Message");
        softAssert.assertEquals(passwordRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Inproper Error Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-3",priority = 3)
    public void testVerifyErrorMessageForInvalidEmailStructure(){
        LoginFromHomepage.refreshPage();
        LoginFromHomepage.insertEmailAddress("gayanherath");
        LoginFromHomepage.clickLoginButton();

        String invalidEmailStructureMessage=LoginFromHomepage.getInvalidEmailStructureMessage();
        String passwordRequiredMessage=LoginFromHomepage.getPasswordRequiredMessage();

        softAssert.assertEquals(invalidEmailStructureMessage,Constants.INAVLID_EMAIL_STRUCTURE_MESSAGE, "Inproper Error Message");
        softAssert.assertEquals(passwordRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Inproper Error Message");
        softAssert.assertAll();

    }


    @Test(description = "TC-4",priority = 4)
    public void testVerifyWhenIncorrectUserNameWithCorrectPassword(){
        LoginFromHomepage.refreshPage();
        LoginFromHomepage.insertEmailAddress("gherath@gmail.com");
        LoginFromHomepage.insertPassword(Constants.P_W);
        LoginFromHomepage.clickLoginButton();

        String invalidCredentialMessage=LoginFromHomepage.getInvalidCredentialMessage();
        softAssert.assertEquals(invalidCredentialMessage,Constants.INVALID_LOGIN_CREDENTIALS, "Inproper Error Message");
        softAssert.assertAll();

    }

    @Test(description = "TC-5",priority = 5)
    public void testVerifyWhenCorrectUserNameWithIncorrectPassword(){
        LoginFromHomepage.refreshPage();
        LoginFromHomepage.insertEmailAddress(Constants.USER_NAME);
        LoginFromHomepage.insertPassword("incorrectPassword");
        LoginFromHomepage.clickLoginButton();

        String invalidCredentialMessage=LoginFromHomepage.getInvalidCredentialMessage();
        softAssert.assertEquals(invalidCredentialMessage,Constants.INVALID_LOGIN_CREDENTIALS, "Inproper Error Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-6",priority = 6)
    public void testVerifyWhenBothIncorrectCredentialsGiveErrorMessage(){
        LoginFromHomepage.refreshPage();
        LoginFromHomepage.insertEmailAddress("gherath@gmail.com");
        LoginFromHomepage.insertPassword("incorrectPassword");
        LoginFromHomepage.clickLoginButton();

        String invalidCredentialMessage=LoginFromHomepage.getInvalidCredentialMessage();
        softAssert.assertEquals(invalidCredentialMessage,Constants.INVALID_LOGIN_CREDENTIALS, "Inproper Error Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-7",priority = 7)
    public void testVerifyUserCanLoginWithValidUserNamePassword(){
        LoginFromHomepage.refreshPage();
        LoginFromHomepage.insertEmailAddress(Constants.USER_NAME);
        LoginFromHomepage.insertPassword(Constants.P_W);
        LoginFromHomepage.clickLoginButton();

        String pageTitile=LoginFromHomepage.getTitle();
        String userName=LoginFromHomepage.getUserName();

        softAssert.assertEquals(pageTitile,"My Account", "User has not logged into the Account");
        softAssert.assertEquals(userName,"HELLO, WILLIAM JACOB!", "User has not logged into the Account");
        softAssert.assertAll();
    }


}
