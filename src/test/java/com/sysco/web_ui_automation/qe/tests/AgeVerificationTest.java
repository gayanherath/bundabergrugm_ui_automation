package com.sysco.web_ui_automation.qe.tests;

import com.sysco.web_ui_automation.qe.common.Constants;
import com.sysco.web_ui_automation.qe.functions.homepage.AgeVerificationFromHomepage;
import com.sysco.web_ui_automation.qe.functions.homepage.Homepage;
import com.sysco.web_ui_automation.qe.utils.DateUtils;
import com.sysco.web_ui_automation.qe.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(SyscoLabListener.class)
public class AgeVerificationTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        syscoLabQCenter.setModule("report_Gayan");
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
        syscoLabQCenter.setClassName(AgeVerificationTest.class.getName());
    }

    @Test(description = "TC-AgeVerification-1",priority = 1)
    public void testVerifyErrorMessageForNoValuesForAge(){
        Homepage.loadHomePage();
        String ageMissingMessage=AgeVerificationFromHomepage.getAgeMissingMessageForNoInput();
        softAssert.assertEquals(ageMissingMessage,Constants.AGE_MISSING_MESSAGE,"Invalid Verification Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-AgeVerification-2",priority = 2)
    public void testVerifyErrorMessageForAge24ByYear(){
        String ageVerificationMessageForMinorAge=AgeVerificationFromHomepage.getAgeVerificationMessageForMinorAge("1","January","1994");
        softAssert.assertEquals(ageVerificationMessageForMinorAge,Constants.AGE_VERIFICATION_MESSAGE_FOR_MINOR_AGE,"Invalid Verification Message");
        softAssert.assertAll();
    }

    @Test(description = "TC-AgeVerification-3",priority = 3)
    public void testVerifyErrorMessageForAge24FromCurrentDate(){
        String date = DateUtils.getPastOrFutureDate(-25,1);
        String[] dateSplit = date.split(" ");
        String day = dateSplit[0].replaceFirst("^0+(?!$)", "");
        String month = dateSplit[1];
        String year = dateSplit[2];

        String ageVerificationMessageForMinorAge=AgeVerificationFromHomepage.getAgeVerificationMessageForMinorAge(day,month,year);
        softAssert.assertEquals(ageVerificationMessageForMinorAge,Constants.AGE_VERIFICATION_MESSAGE_FOR_MINOR_AGE,"Invalid Verification Message");
        softAssert.assertAll();

    }

    @Test(description = "TC-AgeVerification-4",priority = 4)
    public void testVerifyAge25IsValidFromCurrentDate(){
        String date = DateUtils.getPastOrFutureDate(-25,0);
        String[] dateSplit = date.split(" ");
        String day = dateSplit[0].replaceFirst("^0+(?!$)", "");
        String month = dateSplit[1];
        String year = dateSplit[2];

        AgeVerificationFromHomepage.enterValidRequiredAgeLevel(day,month,year);
        String titleAttributeValueHomepageLogoLink=Homepage.getTitleAtributeValueOfHomepageLogoLink();
        softAssert.assertEquals(titleAttributeValueHomepageLogoLink, Constants.WELCOME_LOGO_ATTRIBUTE_TITLE_VALUE,"Invalid Link Title Value");
        softAssert.assertAll();
    }

    @Test(description = "TC-AgeVerification-5",priority = 5)
    public void testVerifyAge25IsValidByYear(){
        Homepage.loadAgeVerificationPopUp();
        AgeVerificationFromHomepage.enterValidRequiredAgeLevel("1","January","1991");
        String titleAttributeValueHomepageLogoLink=Homepage.getTitleAtributeValueOfHomepageLogoLink();
        softAssert.assertEquals(titleAttributeValueHomepageLogoLink, Constants.WELCOME_LOGO_ATTRIBUTE_TITLE_VALUE,"Invalid Link Title Value");
        softAssert.assertAll();

    }
}
