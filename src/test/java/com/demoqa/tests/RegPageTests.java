package com.demoqa.tests;

import com.demoqa.pages.MainPage;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class RegPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    RegistrationPage regPage = new RegistrationPage();

    @Test
    @DisplayName("Отображения формы 'Регистрация соискателя'")
    void formShouldBeVisibleTest() {
        step("Открыть 'https://rabota.by/'", () ->
                mainPage.openMainPage());

        step("Проверка отображения кнопки 'Создать резюме'", () ->
                regPage.checkCreateResume());

        step("Проверка отображения формы 'Регистрация соискателя'", () ->
                regPage.checkRegistrationPage());

    }

    @Test
    @DisplayName("Попытка регистрации без телефона")
    void withoutPhoneRegTest() {
        step("Открыть 'https://rabota.by/'", () ->
                mainPage.openMainPage());

        step("Проверка отображения кнопки 'Создать резюме'", () ->
                regPage.checkCreateResume());

        step("Проверка регистрации без телефона", () ->
                $(byText("Зарегистрироваться")).click());

        step("Отображение ошибки", () ->
                $(byText("Поле обязательно для заполнения")).shouldBe(visible));


    }

    @Test
    @DisplayName("Проверка отображения 'Соглашение об использовании сайта и оказании услуг'")
    void googleRegTest() {
        step("Открыть 'https://rabota.by/'", () ->
                mainPage.openMainPage());

        step("Проверка отображения кнопки 'Создать резюме'", () ->
                regPage.checkCreateResume());

        step("Проверка наличия условия Соглашения", () ->
                $(byText("Соглашения")).click());

        step("Проверка отображения текста условия Соглашения", () ->
                $(byText("Соглашение об использовании сайта и оказании услуг")).shouldBe(visible));

    }

}
