package com.newxel.pageObject;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class BasePage {

    public String getBaseUrl() {
        return System.getProperty("selenide.baseUrl");
    }

    @Step("Open {url} page")
    public void openPage(String url) {
        Selenide.open(url);
    }
}
