package com.sysco.web_ui_automation.qe.tests;

import com.sysco.web_ui_automation.qe.common.Constants;
import com.sysco.web_ui_automation.qe.functions.homepage.Homepage;
import com.sysco.web_ui_automation.qe.functions.homepage.LoginFromHomepage;
import com.sysco.web_ui_automation.qe.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(SyscoLabListener.class)
public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        syscoLabQCenter.setModule("report_Gayan");
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
        syscoLabQCenter.setClassName(LoginTest.class.getName());
    }


    @Test(description = "TC-6",priority = 1)
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

    @Test(description = "TC-7",priority = 2)
    public void testVerifyErrorMessageForLoginAttemptWithNoCredentials(){
        LoginFromHomepage.clickLoginButton();

        String emailRequiredMessage=LoginFromHomepage.getEmailRequiredMessage();
        String passwordRequiredMessage=LoginFromHomepage.getPasswordRequiredMessage();

        softAssert.assertEquals(emailRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Improper Error Message");
        softAssert.assertEquals(passwordRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Improper Error Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-8",priority = 3)
    public void testVerifyErrorMessageForInvalidEmailStructure(){
        LoginFromHomepage.refreshPage();
        LoginFromHomepage.insertEmailAddress("gayanherath");
        LoginFromHomepage.clickLoginButton();

        String invalidEmailStructureMessage=LoginFromHomepage.getInvalidEmailStructureMessage();
        String passwordRequiredMessage=LoginFromHomepage.getPasswordRequiredMessage();

        softAssert.assertEquals(invalidEmailStructureMessage,Constants.INAVLID_EMAIL_STRUCTURE_MESSAGE, "Improper Error Message");
        softAssert.assertEquals(passwordRequiredMessage,Constants.INPUT_REQUIRED_MESSAGE, "Improper Error Message");
        softAssert.assertAll();

    }


    @Test(description = "TC-9",priority = 4)
    public void testVerifyErrorMessageWhenIncorrectUserNameWithCorrectPassword(){
        LoginFromHomepage.refreshPage();
        LoginFromHomepage.insertEmailAddress("gherath@gmail.com");
        LoginFromHomepage.insertPassword(Constants.P_W);
        LoginFromHomepage.clickLoginButton();

        String invalidCredentialMessage=LoginFromHomepage.getInvalidCredentialMessage();
        softAssert.assertEquals(invalidCredentialMessage,Constants.INVALID_LOGIN_CREDENTIALS, "Improper Error Message");
        softAssert.assertAll();

    }

    @Test(description = "TC-10",priority = 5)
    public void testVerifyErrorMessageWhenCorrectUserNameWithIncorrectPassword(){
        LoginFromHomepage.refreshPage();
        LoginFromHomepage.insertEmailAddress(Constants.USER_NAME);
        LoginFromHomepage.insertPassword("incorrectPassword");
        LoginFromHomepage.clickLoginButton();

        String invalidCredentialMessage=LoginFromHomepage.getInvalidCredentialMessage();
        softAssert.assertEquals(invalidCredentialMessage,Constants.INVALID_LOGIN_CREDENTIALS, "Improper Error Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-11",priority = 6)
    public void testVerifyWhenBothIncorrectCredentialsGiveErrorMessage(){
        LoginFromHomepage.refreshPage();
        LoginFromHomepage.insertEmailAddress("gherath@gmail.com");
        LoginFromHomepage.insertPassword("incorrectPassword");
        LoginFromHomepage.clickLoginButton();

        String invalidCredentialMessage=LoginFromHomepage.getInvalidCredentialMessage();
        softAssert.assertEquals(invalidCredentialMessage,Constants.INVALID_LOGIN_CREDENTIALS, "Improper Error Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-12",priority = 7)
    public void testUserCanLoginWithValidUserNameAndPassword(){
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
