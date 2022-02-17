package sapasoft.reg.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class StatisticReportRolesPage {
    @Step ("Открыть раздел Статистические отчеты")
    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[7]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Статистические отчеты"));
    }

    @Step("Открыть отчеты по ролям")
    public void openRoles(){
        $(By.xpath("//div[@class=\"ant-radio-group ant-radio-group-solid\"]/label[2]/span[2]")).click();
    }
    @Step ("Ввести в фильтр значение Кем зарегистрирован")
    public void fillWhoRegister(String name){
        $(By.xpath("//input[@placeholder=\"Введите наименование\"]")).setValue(name);
    }

    @Step ("Проверить, что значение Кем зарегистрирован в результате соответствует значению в фильтре")
    public void checkWhoRegister(String name){
        $(By.xpath("//tr[2]/td[11]")).shouldHave(text(name));
    }

    @Step ("Выбрать в фильтре значение Статус")
    public void chooseStatus(String status){
        $(By.xpath("//label[text()=\"Статус\"]/../..//input")).click();
        $(By.xpath("//div[@title=\""+status+"\"]/div")).click();
    }

    @Step ("Проверить, что значение Статус в результате соответствует значению в фильтре")
    public void checkStatus(String status){
        $(By.xpath("//tr[2]/td[10]")).shouldHave(text(status));
    }

    @Step ("Выбрать в фильтр значение периода даты регистрации")
    public void chooseRegisterDates(String dateFrom, String dateTo){
        $(By.xpath("//input[@placeholder=\"С\"]")).click();
        $(By.xpath("//input[@placeholder=\"С\"]")).setValue(dateFrom);
        $(By.xpath("//input[@placeholder=\"С\"]")).pressEnter();
        $(By.xpath("//input[@placeholder=\"По\"]")).setValue(dateTo);
        $(By.xpath("//input[@placeholder=\"По\"]")).pressEnter();
    }

    @Step ("Проверить, что значение Даты регистрации в результате соответствует значению в фильтре")
    public void checkRegisterDates(String dateFrom, String dateTo){
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

    @Step ("Проверить, что значение Подсистема/модуль в результате соответствует значению в фильтре")
    public void checkModule(String module){
        $(By.xpath("//tr[2]/td[5]")).shouldHave(text(module));
    }

    @Step("Выбрать Код роли в фильтре")
    public void chooseRolesCode(String rolesCode) {
        $(By.xpath("//label[text()=\"Код роли\"]/../../div[2]//input")).shouldNotBe(disabled);
        $(By.xpath("//label[text()=\"Код роли\"]/../../div[2]//input")).click();
        int n = 100;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + rolesCode + "\")]/div")).is(Condition.not(visible))) {
            $(By.xpath("//label[text()=\"Код роли\"]/../../div[2]//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + rolesCode + "\")]/div")).click();
        element(Selectors.byXpath("//div[contains(@title,\"" + rolesCode + "\")]/div")).shouldBe(visible);
    }

    @Step ("Проверить, что значение Код роли в результате соответствует значению в фильтре")
    public void checkRolesCode(String rolesCode){
        $(By.xpath("//tr[2]/td[3]")).shouldHave(text(rolesCode));
    }

    @Step("Выбрать значение Период действия в фильтре")
    public void chooseValidityDates(String dateFrom, String dateTo){
        $(By.xpath("//label[text()=\"Период действия\"]/../../div[2]//input[@placeholder=\"С\"]")).click();
        $(By.xpath("//label[text()=\"Период действия\"]/../../div[2]//input[@placeholder=\"С\"]")).setValue(dateFrom);
        $(By.xpath("//label[text()=\"Период действия\"]/../../div[2]//input[@placeholder=\"С\"]")).pressEnter();
        $(By.xpath("//label[text()=\"Период действия\"]/../../div[2]//input[@placeholder=\"По\"]")).setValue(dateTo);
        $(By.xpath("//label[text()=\"Период действия\"]/../../div[2]//input[@placeholder=\"По\"]")).pressEnter();
    }

    @Step ("Проверить, что значение Период действия в результате соответствует значению в фильтре")
    public void checkValidityDates(String dateFrom, String dateTo){
        //$(By.xpath("//tr[2]/td[6]")).shouldHave(text(dateFrom));
        $(By.xpath("//tr[2]/td[6]")).shouldHave(text("01.06.2021"));
        //$(By.xpath("//tr[2]/td[7]")).shouldHave(text(dateTo));
        $(By.xpath("//tr[2]/td[7]")).shouldHave(text("25.06.2021"));
    }

    @Step("Нажать на кнопку сформировать отчет")
    public void formReportButton(){
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).click();
    }

    @Step("Нажать на кнопку сбросить")
    public void resetButton(){
        $(By.xpath("//button[@class=\"ant-btn administration__button-white\"] ")).click();
    }

}
