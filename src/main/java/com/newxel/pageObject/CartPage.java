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

    public class Asserts {
        @Step("Assert that {itemName} is placed in the Cart with price {itemPrice}")
        public void assertItemExistsInCart(String itemName, String itemPrice) {
            SelenideElement item = placedItems.findBy(Condition.text(itemName));
            item.$("td:nth-of-type(3)").shouldHave(Condition.text(itemPrice));
        }

        @Step("Assert total Cart amount is {total}")
        public void assertTotalAmount(String total) {
            totalAmount.shouldHave(Condition.text(total));
        }
    }
}
