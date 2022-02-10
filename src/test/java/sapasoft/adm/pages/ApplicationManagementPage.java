package sapasoft.adm.pages;


import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ApplicationManagementPage {
    @DisplayName("Открываем раздел \"Управление заявками\"")
    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[5]")).click();
         $(By.xpath("//div/h1")).shouldHave(text("Управление заявками"));
    }

    @Step("Открыть заявку для просмотра")
    public void openApplication(){
        $(By.xpath("//tbody/tr[1]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);

    }

    @Step("Нажать на кнопку отмена")
    public void cancelButton(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//button/span[text()=\"Отмена\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldNotBe(visible);
    }

    @Step("Ввести значение в строку поиска")
    public void searchLine(String searchLine){
        $(By.xpath("//input[@placeholder=\"Поиск по ФИО или ИИН\"]")).setValue(searchLine);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text(searchLine));

    }

    //Кнопка Расширенный поиск
    @Step("Кнопка расширенный поиск")
    public void extendedSearch(){
        $(By.xpath("//div[@class=\"filter\"]")).click();
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).shouldBe(visible);
    }

    // Кнопка Применить
    @Step("Нажать кнопку применить в поиске")
    public void applySearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).click();
    }

    // Кнопка Сбросить
    @Step("Нажать кнопку сбросить в поиске")
    public void resetSearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Сбросить\"]")).click();
    }

    @Step("Выбрать тип заявки")
    public void typeOfApplication(String type) {
        $(By.xpath("//label[@title=\"Тип заявки\"]/../../div[2]//input")).click();
        $(By.xpath("//div[@title=\""+type+"\"]")).click();
    }

    @Step("Выбрать статус")
    public void status(String status) {
        $(By.xpath("//label[@title=\"Статус\"]/../../div[2]//input")).click();
        $(By.xpath("//div[@title=\""+status+"\"]")).click();
    }

    @Step("Выбрать период создания")
    public void periodOfCreation(String period) {
    }

    @Step("Выбрать подсистему/модуль")
    public void module(String module) {
        $(By.xpath("//label[@title=\"Подсистема/модуль\"]/../../div[2]//div[@class=\"ant-select-selector\"]")).click();
        $(By.xpath("//span[@title=\""+module+"\"]")).click();
        $(By.xpath("//label[@title=\"Подсистема/модуль\"]/../../div[2]//div[@class=\"ant-select-selector\"]")).click();
    }

    @Step("Выбрать орган государственных доходов")
    public void ogd(String ogd) {
        $(By.xpath("//label[@title=\"Орган государственных доходов\"]/../../div[2]//span/div[2]//input")).click();
        $(By.xpath("//div[@class=\"ant-select-item-option-content\"][text()=\""+ogd+"\"]")).click();

    }

    @Step("Выбрать подразделение")
    public void subdivision(String subdivision) {
        $(By.xpath("//label[@title=\"Подразделение\"]/../../div[2]//input")).click();
        $(By.xpath("//div[@title=\""+subdivision+"\"]")).click();
    }

    @Step("Выбрать должность")
    public void position(String position) {
        $(By.xpath("//label[@title=\"Должность\"]/../../div[2]//input")).click();
        $(By.xpath("//div[text()=\""+position+"\"]")).click();
    }

    @Step("Проверка, что значение Тип заявки соответствует значению в расширенном поиске")
    public void checkTypeOfApplication(String typeOfApplication){
        $(By.xpath("//tbody/tr[1]/td[6]")).shouldHave(exactText(typeOfApplication));
    }

    @Step("Проверка, что значение Статус соответствует значению в расширенном поиске")
    public void checkStatus(String status){
        $(By.xpath("//tbody/tr[1]/td[7]")).shouldHave(exactText(status));
    }

    @Step("Проверка, что значение Подсистема/модуль соответствует значению в расширенном поиске")
    public void checkModule(String module){
        $(By.xpath("//tbody/tr[1]/td[7]")).shouldHave(exactText(module));
    }


    @Step("Нажать кнопку Создать учетную запись")
    public void createAccountAdmin(){

        $(By.xpath("//span[text()=\"Создать учетную запись\"]")).click();
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Учетная запись создана"));
        //$(byText("Заявка успешно согласована")).shouldBe(visible);

    }


    @Step("Проверить что учетная запись согласована")
    public void checkThatAccountCreated(String iin){
        $(By.xpath("//input[@placeholder=\"Поиск по ФИО или ИИН\"]")).setValue(iin);
        $(By.xpath("//tbody/tr[1]/td[2]")).shouldHave(exactText(iin));
        $(By.xpath("//tbody/tr[1]/td[7]")).shouldHave(exactText("Согласована"));
    }

    @Step("Нажать кнопку Подписать ЭЦП")
    public String signKey(){
        String iin = $(By.xpath("//tbody/tr[1]/td[2]/span")).getText();
        $(By.xpath("//span[text()=\"Подписать ЭЦП\"]")).click();
//        $(byText("Заявка успешно согласована")).shouldBe(visible);
        return iin;
    }

    @Step("Нажать кнопку Отклонить")
    public void decline(){
        String iin = $(By.xpath("//tbody/tr[1]/td[2]/span")).getText();
        $(By.xpath("//span[text()=\"Отклонить\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        $(byText("Заявка успешно отклонена")).shouldBe(visible);
    }

    @Step("Проверить что заявка отклонена")
    public void checkThatAppWasDeclined(String iin){
        $(By.xpath("//tbody/tr[1]/td[2]")).shouldHave(exactText(iin));
        $(By.xpath("//tbody/tr[1]/td[7]")).shouldHave(exactText("Отклонена"));
    }

    @Step("Проверить что результат соответствует значению в поиске")
    public void checkSearchResult(String s) {
        $(By.xpath("//tbody/tr[1]")).shouldHave(text(s));


    }

    @Step("Нажать на кнопку согласовать")
    public void applyButton() {
        $(By.xpath("//span[text()=\"Согласовать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Заявка успешно согласована"));
    }

}
