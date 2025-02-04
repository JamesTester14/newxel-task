package com.newxel;

import com.newxel.pageObject.AddToCartPage;
import com.newxel.pageObject.CartPage;
import com.newxel.pageObject.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AddToCartTest extends SeleniumSetup {
    HomePage homePage = new HomePage();
    AddToCartPage itemDetailPage = new AddToCartPage();
    CartPage cartPage = new CartPage();

    @Test
    @Description("Add two items to the cart and check calculation correctness")
    public void addItemsToCart() {
        homePage.openPage(homePage.getBaseUrl());
        homePage.clickOnItem("Samsung galaxy s7");
        itemDetailPage.asserts.assertDetailPageLoaded("Samsung galaxy s7");
        itemDetailPage.addCurrentItemToCart();

        homePage.openPage(homePage.getBaseUrl());
        homePage.clickOnItem("Samsung galaxy s6");
        itemDetailPage.asserts.assertDetailPageLoaded("Samsung galaxy s6");
        itemDetailPage.addCurrentItemToCart();

        cartPage.openPage(cartPage.pageUrl());
        cartPage.asserts.assertItemExistsInCart("Samsung galaxy s7", "800");
        cartPage.asserts.assertItemExistsInCart("Samsung galaxy s6", "360");
        cartPage.asserts.assertTotalAmount("1160");
    }
}