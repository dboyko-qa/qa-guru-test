package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.demoqa.helpers.Attach;

import java.util.Map;


public class RemoteTestBase {


    @BeforeAll
    static void beforeAll(){
        //get all system properties
        String browser = System.getProperty("browser");
        String browserVersion = System.getProperty("browserVersion");
        String browserSize = System.getProperty("browserSize");
        String webDriverHost = System.getProperty("webDriverHost");
        String baseUrl = System.getProperty("baseUrl");

        Configuration.baseUrl="https://" + baseUrl;
        Configuration.pageLoadStrategy="eager";
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.remote = String.format("https://user1:1234@%s/wd/hub", webDriverHost);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
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
