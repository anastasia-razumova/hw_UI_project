package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import java.net.URL;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    SelenideElement
            searchModule = $("#a11y-search-input"),
            content = $("#a11y-main-content"),
            services = $(byText("Все сервисы")),
            servicesModule = $(".bloko-header-1"),
            apps = $(".supernova-dashboard-footer-app-buttons");


    public MainPage openMainPage() {
        open("https://rabota.by");
        return this;
    }

    public com.demoqa.pages.MainPage search(String query) {
        searchModule.setValue(query).pressEnter();
        return this;
    }

    public com.demoqa.pages.MainPage checkContent(String query) {
        content.shouldHave(text(query));
        return this;
    }

    public com.demoqa.pages.MainPage visibilityApps() {
        apps.shouldBe(visible);
        return this;
    }

    public com.demoqa.pages.MainPage services() {
        services.click();
        return this;
    }

    public com.demoqa.pages.MainPage visibilityServices() {
        servicesModule.shouldBe(visible);
        return this;
    }


}
