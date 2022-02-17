package sapasoft.reg.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class StatisticReportStatisticPage {

    @Step ("Открыть раздел Статистические отчеты")
    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[7]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Статистические отчеты"));
    }

    @Step("Открыть статистический отчет")
    public void openReport() {
        $(By.xpath("//div[@class=\"ant-radio-group ant-radio-group-solid\"]/label[5]/span[2]")).click();
    }

    @Step("Нажать на кнопку сформировать отчет")
    public void formReportButton(){
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).click();
    }

    @Step("Нажать на кнопку сбросить")
    public void resetButton(){
        $(By.xpath("//button[@class=\"ant-btn administration__button-white\"] ")).click();
    }

    @Step ("Ввести в фильтр значение учетной записи")
    public void fillUserlogin(String userlogin){
        $(By.xpath("//input[@placeholder=\"Введите учетную запись\"]")).setValue(userlogin);
    }

    @Step ("Проверить, что значение Учетная запись в результате соответствует значению в фильтре")
    public void checkUserLogin(String userLogin){
        $(By.xpath("//tr[2]/td[4]")).shouldHave(text(userLogin));
    }

    @Step ("Ввести в фильтр значение ФИО")
    public void fillName(String name){
        $(By.xpath("//input[@placeholder=\"Введите ФИО\"]")).setValue(name);
    }

    @Step ("Проверить, что имя в результате соответствует значению в фильтре")
    public void checkName(String name){
        $(By.xpath("//tr[2]/td[6]")).shouldHave(text(name));
    }

    @Step ("Проверить, что фамилия в результате соответствует значению в фильтре")
    public void checkSurname(String surname){
        $(By.xpath("//tr[2]/td[5]")).shouldHave(text(surname));
    }

    @Step ("Проверить, что отчество в результате соответствует значению в фильтре")
    public void checkMiddlename(String middlename){
        $(By.xpath("//tr[2]/td[7]")).shouldHave(text(middlename));
    }

    @Step ("Ввести в фильтр значение IP адрес")
    public void fillIPAdress(String ipAdress){
        $(By.xpath("//input[@placeholder=\"Введите IP-адрес\"]")).setValue(ipAdress);
    }

    @Step ("Проверить, что значение IP адрес в результате соответствует значению в фильтре")
    public void checkIPAdress(String ipAdress){
        $(By.xpath("//tr[2]/td[11]")).shouldHave(text(ipAdress));
    }

    @Step ("Выбрать в фильтр значение периода даты входа")
    public void chooseDates(String dateFrom, String dateTo){
        $(By.xpath("//input[@placeholder=\"С\"]")).click();
        $(By.xpath("//input[@placeholder=\"С\"]")).setValue(dateFrom);
        $(By.xpath("//input[@placeholder=\"С\"]")).pressEnter();
        $(By.xpath("//input[@placeholder=\"По\"]")).setValue(dateTo);
        $(By.xpath("//input[@placeholder=\"По\"]")).pressEnter();
    }

    @Step ("Проверить, что значение Даты входа в результате соответствует значению в фильтре")
    public void checkDates(String dateFrom, String dateTo){
        $(By.xpath("//tr[2]/td[12]")).shouldHave(text(dateFrom));
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

    @Step("Выбрать Код права в фильтре")
    public void chooseRulesCode(String rolesCode) {
        $(By.xpath("//label[text()=\"Код права\"]/../../div[2]//input")).shouldNotBe(disabled);
        $(By.xpath("//label[text()=\"Код права\"]/../../div[2]//input")).click();
        int n = 100;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + rolesCode + "\")]/div")).is(Condition.not(visible))) {
            $(By.xpath("//label[text()=\"Код права\"]/../../div[2]//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + rolesCode + "\")]/div")).click();
        element(Selectors.byXpath("//div[contains(@title,\"" + rolesCode + "\")]/div")).shouldBe(visible);
    }

    @Step ("Проверить, что значение Код права в результате соответствует значению в фильтре")
    public void checkRulesCode(String rolesCode){
        $(By.xpath("//tr[2]/td[2]")).shouldHave(text(rolesCode));
    }

    @Step("Выбрать значение Тип пользователя в фильтре")
    public void chooseUserType(String usertype){
        $(By.xpath("//label[@title=\"Тип пользователя\"]/../../div[2]//input")).click();
        $(By.xpath("//div[text()=\""+usertype+"\"]")).click();
    }

    @Step ("Проверить, что значение Тип пользователя в результате соответствует значению в фильтре")
    public void checkUserType(String usertype){
        $(By.xpath("//tr[2]/td[3]")).shouldHave(text(usertype));
    }

    @Step("Выбрать орган государственных доходов в фильтре")
    public void chooseSearchDepartment(String department) {
        $(By.xpath("//span[text()=\"Наименование ОГД\"]/..//input")).click();
        int n = 200;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + department + "\")]")).is(Condition.not(visible))) {
            $(By.xpath("//span[text()=\"Наименование ОГД\"]/..//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//div[contains(@title,\"" + department + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + department + "\")]")).shouldBe(visible);
    }

    @Step ("Проверить, что значение Орган государственных доходов в результате соответствует значению в фильтре")
    public void checkSearchDepartment(String department){
        $(By.xpath("//tr[2]/td[9]")).shouldHave(text(department));
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
        $(By.xpath("//tr[2]/td[10]")).shouldHave(text(subdivision));
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

}
