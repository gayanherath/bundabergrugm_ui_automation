package com.sysco.web_ui_automation.qe.pages.homepage;

import com.sysco.web_ui_automation.qe.common.Constants;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;


public class HomepagePage {
    protected static SyscoLabUI syscoLabUI;

    private By lnkHomepageLogo=By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/a[1]");
    private By lnkMyAccountPage=By.xpath("//*[@id=\"quick-access-list\"]/li[1]/ul/li[2]/ul/li/a");

    public static void loadHomepagePage(Capabilities capabilities, String url) {
        syscoLabUI = new SyscoLabWUI(capabilities);
        syscoLabUI.navigateTo(url);
        syscoLabUI.driver.manage().window().maximize();
    }

    public String getTitleAtributeValue(){
        syscoLabUI.sleep(1);
        String titleAttributeValue=syscoLabUI.getAttribute(lnkHomepageLogo,"title");
        return titleAttributeValue;
    }

    public void removeCookies(){
        syscoLabUI.driver.manage().deleteAllCookies();

    }

    public void refreshBrowser(){
        syscoLabUI.sleep(2);
        syscoLabUI.refreshBrowser();
        syscoLabUI.sleep(3);
    }

    public void loadMyAccount(){
        syscoLabUI.sleep(3);
        syscoLabUI.click(lnkMyAccountPage);
    }


    public void quitDriver() {
        if (syscoLabUI != null) {
            syscoLabUI.quit();
        }
    }


}
