package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    SelenideElement
            createResume = $(byText("Создать резюме")),
            registrationPage = $(".bloko-header-1");


    public com.demoqa.pages.RegistrationPage checkCreateResume() {
        createResume.click();
        return this;
    }

    public com.demoqa.pages.RegistrationPage checkRegistrationPage() {
        registrationPage.shouldHave(text("Регистрация соискателя"));
        return this;
    }
}
