package com.sysco.web_ui_automation.qe.tests;


import com.sysco.web_ui_automation.qe.data.LoginData;
import com.sysco.web_ui_automation.qe.functions.homepage.Homepage;
import com.sysco.web_ui_automation.qe.utils.ExcelUtil;
import com.sysco.web_ui_automation.qe.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HomepageTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Homepage - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        // Sample way to retrive data from excel
        LoginData loginData = ExcelUtil.getLoginData("$as238l");

        //UI Automation  sample
        Homepage.loadHomePage();
        Homepage.quiteDriver();

    }
}