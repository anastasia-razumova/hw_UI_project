package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import com.demoqa.properties.BrowserProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.codeborne.selenide.Selenide;


public class TestBase {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browserCapabilities = capabilities;
        Configuration.browser = BrowserProperties.browser();
        Configuration.browserVersion = BrowserProperties.browserVersion();
        Configuration.browserSize = BrowserProperties.browserSize();
        if (System.getProperty("remoteUrl") != null) {
            Configuration.remote = System.getProperty("remoteUrl");

            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();
        Attach.addVideo();
        Attach.browserConsoleLogs();
        Selenide.closeWebDriver();
    }




}
