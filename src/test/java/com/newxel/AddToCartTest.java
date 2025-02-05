package com.newxel;

import com.newxel.pageObject.AddToCartPage;
import com.newxel.pageObject.CartPage;
import com.newxel.pageObject.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCartTest extends SelenideSetup {
    HomePage homePage = new HomePage();
    AddToCartPage itemDetailPage = new AddToCartPage();
    CartPage cartPage = new CartPage();

    @Test
    @Description("Add two items to the cart and check calculation correctness")
    public void addItemsToCart() {
        SoftAssert softAssert = new SoftAssert();

        addItemToCart("Samsung galaxy s7");
        addItemToCart("Samsung galaxy s6");

        cartPage.openPage(cartPage.pageUrl());

        softAssert.assertEquals(cartPage.getItemPrice("Samsung galaxy s7"), "800");
        softAssert.assertEquals(cartPage.getItemPrice("Samsung galaxy s6"), "360");
        softAssert.assertEquals(cartPage.getTotalAmount(), "1160");
        softAssert.assertAll();
    }

    private void addItemToCart(String itemName) {
        homePage.openPage(homePage.getBaseUrl());
        homePage.clickOnItem(itemName);
        itemDetailPage.asserts.assertDetailPageLoaded(itemName);
        itemDetailPage.addCurrentItemToCart();
    }
}