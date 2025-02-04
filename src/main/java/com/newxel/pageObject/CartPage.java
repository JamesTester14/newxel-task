package com.newxel.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage extends BasePage {
    private final SelenideElement totalAmount = $("#totalp");
    private final SelenideElement placeOrderButton = $(".btn.btn-success");
    private final ElementsCollection placedItems = $$("tr.success");

    public String pageUrl() {
        return getBaseUrl() + "cart.html";
    }

    @Step
    @Override
    public void openPage(String url) {
        Selenide.open(url);
        placeOrderButton.shouldBe(Condition.visible);
    }

    @Step("Get the price of {itemName}")
    public String getItemPrice(String itemName){
        SelenideElement item = placedItems.findBy(Condition.text(itemName));
        return item.$("td:nth-of-type(3)").getText();
    }

    @Step("Get Total cart amount")
    public String getTotalAmount(){
        return totalAmount.getText();
    }
}
