package com.sysco.web_ui_automation.qe.pages.myaccount;

import com.sysco.web_ui_automation.qe.pages.homepage.HomepagePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RoyalLiqueurCategoryFromMyAccountPage extends HomepagePage {

    private By drpDwnProducts=By.xpath("//*[@id=\"nav-wrapper\"]/div/ul[1]/li[1]/a");
    private By lnkRoyalLiqueurCategory=By.xpath("//*[@id=\"nav-wrapper\"]/div/div[4]/div[1]/div[1]/ul/li/ul/li[2]/a");
    private By lnkPineappleCoconutTropic=By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]/ul/li[2]/h2/a");

    public void selectRoyalLiqueurCategory(){
        WebElement element = syscoLabUI.findElement(drpDwnProducts);
        Actions action = new Actions(syscoLabUI.driver);
        action.moveToElement(element).build().perform();
        syscoLabUI.findElement(lnkRoyalLiqueurCategory).click();
        syscoLabUI.sleep(2);
    }

    public void clickPineappleCoconutTropicItem(){
        syscoLabUI.click(lnkPineappleCoconutTropic);
        syscoLabUI.sleep(2);
    }
}
