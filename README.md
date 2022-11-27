#  Проект по автоматизации тестирования сайта rabota.by

##	Содержание

- [Технологии и инструменты](#technologist-технологии-и-инструменты)
- [Реализованные проверки](#bookmark_tabs-реализованные-проверки)
- [Запуск тестов из терминала](#computer-запуск-тестов-из-терминала)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)



## Технологии и инструменты:

<p  align="center">

<code><img width="5%" title="Java" src="images/Java.svg"></code>
<code><img width="5%" title="GitHub" src="images/GitHub.svg"></code>
<code><img width="5%" title="IntelliJ IDEA" src="images/Idea.svg"></code>
<code><img width="5%" title="Selenoid" src="images/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="images/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="images/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/Junit5.svg"></code>
<code><img width="5%" title="Allure Report" src="images/Allure.svg"></code>
<code><img width="5%" title="Jenkins" src="images/Jenkins_logo.svg"></code>
<code><img width="5%" title="Telegram" src="images/Telegram.svg"></code>
</p>



## Реализованные проверки:
### UI Tests

- Проверка отображения главной страницы 
- Проверка результатов поиска работы 
- Проверка отображаения приложений для скачивания 
- Проверка отображения формы 'Регистрация соискателя'



## Запуск тестов из терминала:


### Локальный запуск тестов:

```bash
gradle clean test
```


### Удаленный запуск тестов:

```bash
gradle clean test
-Dbrowser=${browser}
-DbrowserVersion=${browserVersion}
-DbrowserSize=${browserSize}
-DremoteUrl=${remoteUrl}
```


## Параметры сборки:

 <strong>*browser*</strong> – браузер, в котором будут выполняться тесты (_по умолчанию - <strong>*chrome*</strong>_).

 <strong>*browserVersion*</strong> – версия браузера (_по умолчанию - <strong>*99*</strong>_).

 <strong>*browserSize*</strong> – размер окна браузера, в котором будут выполняться тесты (_по умолчанию - <strong>*1920x1080*</strong>_).

 <strong>*remoteUrl*</strong> – логин, пароль и адрес удаленного сервера Selenoid (_по умолчанию указаны в сборке Jenkins_).



## Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/hw_project_15/):

Для запуска сборки необходимо указать значения параметров и нажать кнопку <code><strong>*Собрать*</strong></code>.

<p align="center">
  <img src="images/jenkins.png" alt="Jenkins" width="800">
</p>

После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок *Allure Report*, кликнув по которому, откроется страница с сформированным html-отчетом.

<p align="center">
  <img src="images/allure.png" alt="allure" width="800">
</p>



## Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/hw_project_15/2/allure/):

<p align="center">
  <img src="images/allure1.png" alt="allure1" width="900">
</p>


## Уведомления в Telegram с использованием бота:
После завершения сборки специальный бот, созданный в <strong>Telegram</strong>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notification" src="images/tl.jpg">
</p>


## Пример запуска теста в Selenoid:

К каждому тесту в отчете прилагается видео.

<p align="center">
  <img title="Selenoid Video" src="images/video.gif">
</p>
