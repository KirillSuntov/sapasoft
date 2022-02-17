package sapasoft.reg.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Стаитистические отчеты\"")
public class StatisticReportUserPage {

    @Step ("Открыть раздел Статистические отчеты")
    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[7]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Статистические отчеты"));
    }
    @Step ("Открыть отчеты по пользователям")
    public void openUsers(){
        $(By.xpath("//div[@class=\"ant-radio-group ant-radio-group-solid\"]/label[1]/span[2]")).click();

    }

    @Step ("Ввести в фильтр значение учетной записи")
    public void fillUsername(String usernane){
        $(By.xpath("//input[@placeholder=\"Введите учетную запись\"]")).setValue(usernane);
    }

    @Step ("Ввести в фильтр значение ФИО")
    public void fillName(String name){
        $(By.xpath("//input[@placeholder=\"Введите ФИО\"]")).setValue(name);
    }

    @Step ("Проверить, что значение ФИО в результате соответствует значению в фильтре")
    public void checkName(String name){
        $(By.xpath("//tr[2]/td[4]")).shouldHave(text(name));
    }

    @Step ("Ввести в фильтр значение Кем зарегистрирован")
    public void fillWhoRegister(String nane){
        $(By.xpath("//input[@placeholder=\"Введите наименование\"]")).setValue(nane);
    }

    @Step ("Проверить, что значение Кем зарегистрирован в результате соответствует значению в фильтре")
    public void checkWhoRegister(String name){
        $(By.xpath("//tr[2]/td[14]")).shouldHave(text(name));
    }

    @Step ("Ввести в фильтр значение IP адрес")
    public void fillIPAdress(String ipAdress){
        $(By.xpath("//input[@placeholder=\"Введите IP-адрес\"]")).setValue(ipAdress);
    }

    @Step ("Проверить, что значение IP адрес в результате соответствует значению в фильтре")
    public void checkIPAdress(String ipAdress){
        $(By.xpath("//tr[2]/td[13]")).shouldHave(text(ipAdress));
    }

    @Step ("Выбрать в фильтре значение Статус")
    public void chooseStatus(String status){
        $(By.xpath("//label[text()=\"Статус\"]/../..//input")).click();
        $(By.xpath("//div[@title=\""+status+"\"]/div")).click();
    }

    @Step ("Проверить, что значение Статус в результате соответствует значению в фильтре")
    public void checkStatus(String status){
        $(By.xpath("//tr[2]/td[12]")).shouldHave(text(status));
    }

    @Step ("Выбрать в фильтр значение периода даты регистрации")
    public void chooseDates(String dateFrom, String dateTo){
        $(By.xpath("//input[@placeholder=\"С\"]")).click();
        $(By.xpath("//input[@placeholder=\"С\"]")).setValue(dateFrom);
        $(By.xpath("//input[@placeholder=\"С\"]")).pressEnter();
        $(By.xpath("//input[@placeholder=\"По\"]")).setValue(dateTo);
        $(By.xpath("//input[@placeholder=\"По\"]")).pressEnter();
    }

    @Step ("Проверить, что значение Даты регистрации в результате соответствует значению в фильтре")
    public void checkDates(String dateFrom, String dateTo){
        $(By.xpath("//tr[2]/td[2]")).shouldHave(text(dateFrom));
    }

    @Step("Выбрать значение модуля в фильтре")
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

    @Step("Выбрать значение Тип пользователя в фильтре")
    public void chooseUserType(String usertype){
        $(By.xpath("//label[@title=\"Тип пользователя\"]/../../div[2]//input")).click();
        sleep(500);
        $(By.xpath("//div[text()=\""+usertype+"\"]")).click();
    }

    @Step ("Проверить, что значение Тип пользователя в результате соответствует значению в фильтре")
    public void checkUserType(String usertype){
        $(By.xpath("//tr[2]/td[3]")).shouldHave(text(usertype));
    }

    @Step("Выбрать орган государственных доходов в фильтре")
    public void chooseSearchDepartment(String rolesGroupDepartment) {
        $(By.xpath("//span[text()=\"Наименование ОГД\"]/..//input")).click();
        int n = 200;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + rolesGroupDepartment + "\")]")).is(Condition.not(visible))) {
            $(By.xpath("//span[text()=\"Наименование ОГД\"]/..//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//div[contains(@title,\"" + rolesGroupDepartment + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + rolesGroupDepartment + "\")]")).shouldBe(visible);
    }

    @Step ("Проверить, что значение Орган государственных доходов в результате соответствует значению в фильтре")
    public void checkSearchDepartment(String department){
        $(By.xpath("//tr[2]/td[6]")).shouldHave(text(department));
    }

    @Step("Выбрать подразделение в фильтре")
    public void chooseSubdivision(String searchSubdivision) {
        $(By.xpath("//label[text()=\"Подразделение\"]/../../div[2]")).shouldNotBe(disabled);
        $(By.xpath("//label[text()=\"Подразделение\"]/../../div[2]")).click();
        int n = 100;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + searchSubdivision + "\")]")).is(Condition.not(visible))) {
            $(By.xpath("//label[text()=\"Подразделение\"]/../../div[2]//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + searchSubdivision + "\")]")).click();
        element(Selectors.byXpath("//div[contains(@title,\"" + searchSubdivision + "\")]")).shouldBe(visible);
    }

    @Step ("Проверить, что значение Подразделение в результате соответствует значению в фильтре")
    public void checkSubdivision(String subdivision){
        $(By.xpath("//tr[2]/td[7]")).shouldHave(text(subdivision));
    }

    @Step ("Выбрать значение Должность в фильтре")
    public void choosePosition(String position){
        $(By.xpath("//label[@title=\"Должность\"]/../../div[2]//input")).click();
        $(By.xpath("//div[contains(@title,\""+position+"\")]/div")).click();
    }

    @Step ("Проверить, что значение Должность в результате соответствует значению в фильтре")
    public void checkPosition(String position){
        $(By.xpath("//tr[2]/td[8]")).shouldHave(text(position));
    }

    @Step ("Открыть отчет по действиям администраторов")
    public void openAdmins() {
        $(By.xpath("//div[@class=\"ant-radio-group ant-radio-group-solid\"]/label[4]/span[2]")).click();
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
