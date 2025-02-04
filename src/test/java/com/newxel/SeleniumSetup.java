package com.newxel;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SeleniumSetup {

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true));
        System.setProperty("selenide.baseUrl", "https://www.demoblaze.com/");
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.timeout = 5000;

    }

    @AfterClass
    public void removeAllure() {
        SelenideLogger.removeListener("allure");
    }

}
