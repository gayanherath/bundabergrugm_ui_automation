package com.sysco.web_ui_automation.qe.functions.homepage;

import com.sysco.web_ui_automation.qe.common.Constants;
import com.sysco.web_ui_automation.qe.pages.homepage.HomepagePage;
import com.sysco.web_ui_automation.qe.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class Homepage {

    public static HomepagePage homepagePage = new HomepagePage();


    public static void loadHomePage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            homepagePage.loadHomepagePage(capabilities, Constants.APP_URL);
        } else {
            homepagePage.loadHomepagePage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    public static String getTitleAtributeValueOfHomepageLogoLink(){
        String titleAttributeValue=homepagePage.getTitleAtributeValue();
        return titleAttributeValue;
    }

    public static void loadAgeVerificationPopUp(){
        homepagePage.removeCookies();
        homepagePage.refreshBrowser();

    }

    public static void loadMyAccountPage(){
        homepagePage.loadMyAccount();
    }


    public static void quiteDriver() {
        homepagePage.quitDriver();
    }

    public static void loginToFtr() {

    }
}
