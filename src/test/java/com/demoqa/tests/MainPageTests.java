package com.demoqa.tests;


import com.demoqa.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();


    @Test
    @DisplayName("Проверка наличия главной страницы")
    void titleTest() {
        step("Открыть 'https://rabota.by/'", () ->
                mainPage.openMainPage());

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
                mainPage.openMainPage());

        step("Ввести текст в поисковую строку", () ->
                mainPage.search("QA"));


        step("Проверить отображение вакансий", () ->
                mainPage.checkContent("QA"));
    }

    @Test
    @DisplayName("Проверка отображения приложений для скачивания")
    void appsShouldBeVisibleTest() {
        step("Открыть 'https://rabota.by/'", () ->
                mainPage.openMainPage());

        step("Проверка отображения приложений для скачивания", () ->
                mainPage.visibilityApps());

    }


    @Test
    @DisplayName("Проверка отображения сервисов для соискателей")
    void servicesShouldBeVisibleTest() {
        step("Открыть 'https://rabota.by/'", () ->
                mainPage.openMainPage());

        step("Проверка отображения кнопки 'Все сервисы'", () ->
                mainPage.services());

        step("Проверка отображения сервисов для соискателей", () ->
                mainPage.visibilityServices());

    }





}
