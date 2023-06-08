package com.demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${config}.properties",
        "classpath:local_chrome.properties",
})
public interface WebDriverConfig extends Config {

    @Key("webdriver")
    @DefaultValue("LOCAL")
    Environment getWebDriver();

    @Key("baseUrl")
    @DefaultValue("demoqa.com")
    String getBaseUrl();

    @Key("browser.name")
    @DefaultValue("CHROME")
    Browser getBrowserName();

    @Key("browser.version")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("webDriverHost")
    @DefaultValue("selenoid.autotests.cloud")
    String getWebDriverHost();


}
