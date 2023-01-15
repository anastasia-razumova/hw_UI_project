package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class PageObject {

    SelenideElement
            searchModule = $("#a11y-search-input"),
            content = $("#a11y-main-content"),
            services = $(byText("Все сервисы")),
            servicesModule = $(".bloko-header-1"),
            apps = $(".supernova-dashboard-footer-app-buttons"),
            createResume = $(byText("Создать резюме")),
            registrationPage = $(".bloko-header-1");

    public com.demoqa.pages.PageObject search(String query) {
        searchModule.setValue(query).pressEnter();
        return this;
    }

    public com.demoqa.pages.PageObject checkContent(String query) {
        content.shouldHave(text(query));
        return this;
    }

    public com.demoqa.pages.PageObject visibilityApps() {
        apps.shouldBe(visible);
        return this;
    }

    public com.demoqa.pages.PageObject services() {
        services.click();
        return this;
    }

    public com.demoqa.pages.PageObject visibilityServices() {
        servicesModule.shouldBe(visible);
        return this;
    }

    public com.demoqa.pages.PageObject checkCreateResume() {
        createResume.click();
        return this;
    }

    public com.demoqa.pages.PageObject checkRegistrationPage() {
        registrationPage.shouldHave(text("Регистрация соискателя"));
        return this;
    }



}
