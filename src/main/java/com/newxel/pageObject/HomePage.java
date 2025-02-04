package com.newxel.pageObject;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;


public class HomePage extends BasePage {
    public Asserts asserts = new Asserts();

    private final ElementsCollection items = $$("#tbodyid .card h4 a");


    @Step
    @Override
    public void openPage(String url) {
        Selenide.open(url);
        asserts.assertItemsDisplayed();
    }

    @Step("Open {itemName} detail page")
    public void clickOnItem(String itemName) {
        items.findBy(text(itemName)).click();
    }


    public class Asserts {
        @Step("Assert that there are 9 items on the HomePage")
        public void assertItemsDisplayed(){
            items.shouldHave(size(9));
        }
    }
}
