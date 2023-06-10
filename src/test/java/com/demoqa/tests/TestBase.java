package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.config.Browser;
import com.demoqa.config.Environment;
import com.demoqa.config.WebDriverConfig;
import com.demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {


    @BeforeAll
    static void beforeAll(){
        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        Environment env = config.getWebDriver();
        String baseUrl = config.getBaseUrl();
        Browser browser = config.getBrowserName();
        String browserVersion = config.getBrowserVersion();
        String browserSize = config.getBrowserSize();
        String webDriverHost = config.getWebDriverHost();

        Configuration.baseUrl= baseUrl;
        Configuration.pageLoadStrategy="eager";
        Configuration.browser = browser.toString();
        Configuration.browserSize = browserSize;

        switch (env){
            case REMOTE:
            {
                Configuration.remote = String.format("https://%s/wd/hub", webDriverHost);
                Configuration.browserVersion = browserVersion;

            }
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
