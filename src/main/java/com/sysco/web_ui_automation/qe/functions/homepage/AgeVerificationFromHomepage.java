package com.sysco.web_ui_automation.qe.functions.homepage;

import com.sysco.web_ui_automation.qe.pages.homepage.AgeVerificationFromHomepagePage;

public class AgeVerificationFromHomepage {

    private static AgeVerificationFromHomepagePage ageVerificationFromHomepagePage = new AgeVerificationFromHomepagePage();

    public static String getAgeMissingMessageForNoInput(){
        ageVerificationFromHomepagePage.clickEnterButton();
        String ageVerificationMessage=ageVerificationFromHomepagePage.getAgeVerificationMessage();
        return ageVerificationMessage;
    }

    public static String getAgeVerificationMessageForMinorAge(String day, String month, String year){
        ageVerificationFromHomepagePage.setAge(day,month,year);
        ageVerificationFromHomepagePage.clickEnterButton();
        String ageVerificationMessage=ageVerificationFromHomepagePage.getAgeVerificationMessage();
        return ageVerificationMessage;
    }

    public static void enterValidRequiredAgeLevel(String day, String month, String year){
        ageVerificationFromHomepagePage.uncheckRememberMeOnThisDevice();
        ageVerificationFromHomepagePage.setAge(day,month,year);
        ageVerificationFromHomepagePage.clickEnterButton();
    }

}
