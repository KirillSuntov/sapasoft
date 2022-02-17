package sapasoft.reg.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class StatisticReportRulesPage {
    @Step("Открыть раздел Статистические отчеты")
    public void open() {
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[7]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Статистические отчеты"));
    }

    @Step("Открыть отчеты по правам")
    public void openRules() {
        $(By.xpath("//div[@class=\"ant-radio-group ant-radio-group-solid\"]/label[3]/span[2]")).click();
    }

    @Step ("Ввести в фильтр значение Кем зарегистрирован")
    public void fillWhoRegister(String nane) {
        $(By.xpath("//input[@placeholder=\"Введите наименование\"]")).setValue(nane);
    }

    @Step ("Проверить, что значение Кем зарегистрирован в результате соответствует значению в фильтре")
    public void checkWhoRegister(String name) {
        $(By.xpath("//tr[2]/td[8]")).shouldHave(text(name));
    }

    @Step ("Выбрать в фильтре значение Статус")
    public void chooseStatus(String status) {
        $(By.xpath("//label[text()=\"Статус\"]/../..//input")).click();
        $(By.xpath("//div[@title=\"" + status + "\"]/div")).click();
    }

    @Step ("Проверить, что значение Статус в результате соответствует значению в фильтре")
    public void checkStatus(String status) {
        $(By.xpath("//tr[2]/td[5]")).shouldHave(text(status));
    }

    @Step ("Выбрать в фильтр значение периода даты регистрации")
    public void chooseDates(String dateFrom, String dateTo) {
        $(By.xpath("//input[@placeholder=\"С\"]")).click();
        $(By.xpath("//input[@placeholder=\"С\"]")).setValue(dateFrom);
        $(By.xpath("//input[@placeholder=\"С\"]")).pressEnter();
        $(By.xpath("//input[@placeholder=\"По\"]")).setValue(dateTo);
        $(By.xpath("//input[@placeholder=\"По\"]")).pressEnter();

    }

    @Step ("Проверить, что значение Даты регистрации в результате соответствует значению в фильтре")
    public void checkDates(String dateFrom, String dateTo) {
        $(By.xpath("//tr[2]/td[2]")).shouldHave(text(dateFrom));
    }

    @Step("Выбрать значение Подсистема/модуль в фильтре")
    public void chooseSearchModule(String searchModule) {
        $(By.xpath("//label[@title=\"Подсистема/модуль\"]/../../div[2]//input")).click();
        int n = 50;
        int i = 0;
        while (element(Selectors.byXpath("//span[contains(@title,\"" + searchModule + "\")]")).is(Condition.not(visible))) {
            $(By.xpath("//label[@title=\"Подсистема/модуль\"]/ancestor::div[@class=\"ant-row ant-form-item\"]/div[2]//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//span[contains(@title,\"" + searchModule + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + searchModule + "\")]")).shouldBe(visible);
        $(By.xpath("//label[@title=\"Подсистема/модуль\"]/../../div[2]//input")).pressEscape();
    }

    @Step("Выбрать Код права в фильтре")
    public void chooseRulesCode(String rulesCode) {
        $(By.xpath("//label[text()=\"Код права\"]/../../div[2]//input")).shouldNotBe(disabled);
        $(By.xpath("//label[text()=\"Код права\"]/../../div[2]//input")).click();
        int n = 100;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + rulesCode + "\")]/div")).is(Condition.not(visible))) {
            $(By.xpath("//label[text()=\"Код права\"]/../../div[2]//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + rulesCode + "\")]/div")).click();
        element(Selectors.byXpath("//div[contains(@title,\"" + rulesCode + "\")]/div")).shouldBe(visible);
    }

    @Step ("Проверить, что значение Код права в результате соответствует значению в фильтре")
    public void checkRulesCode(String rulesCode) {
        $(By.xpath("//tr[2]/td[3]")).shouldHave(text(rulesCode));
    }


    @Step("Нажать на кнопку сформировать отчет")
    public void formReportButton() {
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).click();
    }

    @Step("Нажать на кнопку сбросить")
    public void resetButton() {
        $(By.xpath("//button[@class=\"ant-btn administration__button-white\"] ")).click();
    }
}
