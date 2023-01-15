package com.demoqa.tests;


import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.PageObject;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends TestBase {

    PageObject pageObjects = new PageObject();


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
                pageObjects.search("QA"));


        step("Проверить отображение вакансий", () ->
                pageObjects.checkContent("QA"));
    }

    @Test
    @DisplayName("Проверка отображения приложений для скачивания")
    void appsShouldBeVisibleTest() {
        step("Открыть 'https://rabota.by/'", () ->
                open("https://rabota.by/"));

        step("Проверка отображения приложений для скачивания", () ->
                pageObjects.visibilityApps());

    }


    @Test
    @DisplayName("Проверка отображения сервисов для соискателей")
    void servicesShouldBeVisibleTest() {
        step("Открыть 'https://rabota.by/'", () ->
                open("https://rabota.by/"));

        step("Проверка отображения кнопки 'Все сервисы'", () ->
                pageObjects.services());

        step("Проверка отображения сервисов для соискателей", () ->
                pageObjects.visibilityServices());

    }


    @Test
    @DisplayName("Отображения формы 'Регистрация соискателя'")
    void formShouldBeVisibleTest() {
        step("Открыть 'https://rabota.by/'", () ->
                open("https://rabota.by/"));

        step("Проверка отображения кнопки 'Создать резюме'", () ->
                pageObjects.checkCreateResume());

        step("Проверка отображения формы 'Регистрация соискателя'", () ->
                pageObjects.checkRegistrationPage());

    }



}
