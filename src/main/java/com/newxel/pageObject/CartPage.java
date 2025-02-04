package com.newxel.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage extends BasePage {
    public Asserts asserts = new Asserts();

    private final SelenideElement totalAmount = $("#totalp");
    private final SelenideElement placeOrderButton = $(".btn.btn-success");
    private final ElementsCollection placedItems = $$("#tbodyid td:nth-child(2)");
    private final ElementsCollection placedPrices = $$("#tbodyid td:nth-child(3)");

    public String pageUrl() {
        return getBaseUrl() + "cart.html";
    }

    @Step
    @Override
    public void openPage(String url) {
        Selenide.open(url);
        placeOrderButton.shouldBe(Condition.visible);
    }

    public class Asserts {
        @Step("Assert that {itemName} is placed in the Cart with price {itemPrice}")
        public void assertItemExistsInCart(String itemName, String itemPrice) {
            placedItems.findBy(Condition.text(itemName)).shouldBe(Condition.visible);
        }

        @Step("Assert total Cart amount is {total}")
        public void assertTotalAmount(String total) {
            totalAmount.shouldHave(Condition.text(total));
        }
    }
}
