package com.sysco.web_ui_automation.qe.tests;
import com.sysco.web_ui_automation.qe.functions.myaccount.MyAccount;
import com.sysco.web_ui_automation.qe.common.Constants;
import com.sysco.web_ui_automation.qe.functions.homepage.AgeVerificationFromHomepage;
import com.sysco.web_ui_automation.qe.functions.homepage.Homepage;
import com.sysco.web_ui_automation.qe.functions.homepage.LoginFromHomepage;
import com.sysco.web_ui_automation.qe.functions.myaccount.PineappleCocountTropicFromRLCategory;
import com.sysco.web_ui_automation.qe.functions.myaccount.RoyalLiqueurCategoryFromMyAccount;
import com.sysco.web_ui_automation.qe.functions.myaccount.ShoppingCart;
import com.sysco.web_ui_automation.qe.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class MyAccountPageTest extends TestBase {

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
        RoyalLiqueurCategoryFromMyAccount.selectRoyalLiqiuorCategory();
        RoyalLiqueurCategoryFromMyAccount.clickPineappleCoconutTropicItem();
        String itemNameFromPage=PineappleCocountTropicFromRLCategory.getItemNameFromPage();
        String itemPriceFromPage=PineappleCocountTropicFromRLCategory.getPriceFromPage();
        PineappleCocountTropicFromRLCategory.clickAddToCart();

        String itemNameFromCart = MyAccount.getItemNameFromCart();
        String itemPriceFromCart = MyAccount.getItemPriceFromCart();

        softAssert.assertEquals(itemNameFromCart,itemNameFromPage, "Added Item's name does not match with item in Cart");
        softAssert.assertEquals(itemPriceFromCart,itemPriceFromPage,"Added Item's price does not match with item in Cart");
        softAssert.assertAll();
    }

    @Test(description = "TC-2",priority = 2)
    public void testVerifyUserCanGoToShoppingCartPageClickingCheckout(){
        LoginFromHomepage.refreshPage();
        MyAccount.clickCart();
        MyAccount.clickChechOutButton();
        String pageTitle=ShoppingCart.getPageTitle();
        softAssert.assertEquals(pageTitle,"Shopping Cart","Invalid Page is loaded");
        softAssert.assertAll();
    }

  /*  @Test(description = "TC-3",priority = 3)
    public void testVerifyUserCanGoToCheckoutPageClickingProceedToCheckOut(){
        LoginFromHomepage.refreshPage();
        MyAccount.clickCart();
        MyAccount.clickChechOutButton();
        String pageTitle=ShoppingCart.getPageTitle();
        softAssert.assertEquals(pageTitle,"Shopping Cart","Invalid Page is loaded");
        softAssert.assertAll();
    }*/





}
