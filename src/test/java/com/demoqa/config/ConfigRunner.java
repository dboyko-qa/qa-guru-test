package com.demoqa.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class ConfigRunner {

    public ConfigRunner runConfig(){
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
        return this;
    }
}
