package com.newxel.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class AddToCartPage extends BasePage {
    public Asserts asserts = new Asserts();

    private final SelenideElement itemTitle = $("#tbodyid h2.name");
    private final SelenideElement addToCartButton = $(".btn.btn-success.btn-lg");

    @Step("Add current item to the Cart")
    public void addCurrentItemToCart() {
        addToCartButton.click();
        Assert.assertEquals(Selenide.switchTo().alert().getText(), "Product added");
        Selenide.switchTo().alert().accept();
    }

    public class Asserts{
        @Step("Check that item {itemName} detail page is loaded")
        public void assertDetailPageLoaded(String itemName) {
            itemTitle.shouldHave(Condition.text(itemName));
        }
    }
}
