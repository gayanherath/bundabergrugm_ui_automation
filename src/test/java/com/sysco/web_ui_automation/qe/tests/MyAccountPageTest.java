package com.sysco.web_ui_automation.qe.tests;
import com.sysco.web_ui_automation.qe.functions.myaccount.MyAccount;
import com.sysco.web_ui_automation.qe.common.Constants;
import com.sysco.web_ui_automation.qe.functions.homepage.AgeVerificationFromHomepage;
import com.sysco.web_ui_automation.qe.functions.homepage.Homepage;
import com.sysco.web_ui_automation.qe.functions.homepage.LoginFromHomepage;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class MyAccountPageTest {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Homepage - ValidLogin");
    }

    @BeforeClass
    public void loadHomePage(){
        Homepage.loadHomePage();
        AgeVerificationFromHomepage.enterValidRequiredAgeLevel("1","January","1991");
        Homepage.loadMyAccountPage();

        LoginFromHomepage.insertEmailAddress(Constants.USER_NAME);
        LoginFromHomepage.insertPassword(Constants.P_W);
        LoginFromHomepage.clickLoginButton();
    }

    @Test(priority = 1)
    public void testVerifyUserCanAddItemToCart() throws AWTException {
        MyAccount.clickCart();
        MyAccount.clearCart();
    }

    @Test
    public void testVerifyAddedItemsGoToCart(){

    }



}
