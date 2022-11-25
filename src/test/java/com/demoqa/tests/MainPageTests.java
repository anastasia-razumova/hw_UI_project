package com.demoqa.tests;


import com.demoqa.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Проверка наличия главной страницы")
    void titleTest() {
        step("Открыть 'https://rabota.by/'", () ->
                open("https://rabota.by/"));

        step("Заголовок страницы имеет текст 'Работа в Минске, свежие вакансии - rabota.by'", () -> {
            String expectedTitle = "Работа в Минске, свежие вакансии - rabota.by";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Поиск работы")
    void jobSearchTest() {
        step("Открыть 'https://rabota.by/'", () ->
                open("https://rabota.by/"));

        step("Ввести текст в поисковую строку", () ->
                $("#a11y-search-input").setValue("QA").pressEnter());

        step("Проверить отображение вакансий", () ->
                $("#a11y-main-content").shouldHave(text("QA")));
    }

    @Test
    @DisplayName("Проверка отображения приложений для скачивания")
    void servicesShouldBeVisibleTest() {
        step("Открыть 'https://rabota.by/'", () ->
                open("https://rabota.by/"));

        step("Проверка отображения приложений для скачивания", () ->
                $(".supernova-dashboard-footer-app-buttons").shouldBe(visible));

    }

    @Test
    @DisplayName("Отображения формы 'Регистрация соискателя'")
    void dashboardShouldBeVisibleTest() {
        step("Открыть 'https://rabota.by/'", () ->
                open("https://rabota.by/"));

        step("Проверка отображения кнопки 'Создать резюме'", () ->
            $(byText("Создать резюме")).click());

        step("Проверка отображения формы 'Регистрация соискателя'", () ->
                $(".bloko-header-1").shouldHave(text("Регистрация соискателя")));

        };




}
