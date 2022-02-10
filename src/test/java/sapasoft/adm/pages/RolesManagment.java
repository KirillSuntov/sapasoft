package sapasoft.adm.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RolesManagment {

    //Открываем раздел Управление ролями
    @Step("Открываем раздел \"Управление ролями\"")
    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[2]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Управление ролями"));
    }

    /*Создание и редактирование роли*/

    //Кнопка создать новую роль
    @Step("Нажать на кнопку Создать новую роль")
    public void createNewRole(){
        $(By.xpath("//button/span[text()=\"Создать новую роль\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);
    }

    //Заполнить поля наименования на русском, казахском, казахском (латиница)
    @Step("Заполнить поля наименования на русском, казахском, казахском (латиница)")
    public void fillNames(String rusName, String engName){
        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на английском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        Selenide.sleep(1000);
        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).sendKeys(rusName);
        Selenide.sleep(1000);
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).sendKeys(rusName);
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).sendKeys(engName);
        $(By.xpath("//label[text()=\"Наименование на английском\"]/parent::div/parent::div//input")).sendKeys(engName);
    }
    //Выбрать модуль
    @Step("Выбрать модуль")
    public void chooseModule(String module) {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подсистема/модуль\"]/../..//input")).click();
        if(module =="Отчетность"|| module =="Регистрация налогоплательщиков и ККМ" ||module =="АРМ ОГД" ||module == "Кабинет налогоплательщика" ){
            $(By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]")).hover();
            $(By.xpath("//div[@title=\""+module+"\"]/ancestor::div[@class=\"rc-virtual-list-holder-inner\"]")).scrollIntoView(false);
            $(By.xpath("//div[@title=\""+module+"\"]")).click();
        }else{
            $(By.xpath("//div[@title=\""+module+"\"]")).click();
        }
        $(By.xpath("//span[@title=\""+module+"\"]")).shouldBe(visible);
    }

    //Заполнить поле код
    @Step("Заполнить поле код")
    public void fillCode(String code) {
        $(By.xpath("//input[@placeholder=\"Введите код роли\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//input[@placeholder=\"Введите код роли\"]")).setValue(code);
    }

    @Step("Выбрать уровень")
    public void chooseLevel(String level){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Уровень\"]/../..//input/../..")).click();
        $(By.xpath("//div[@title=\""+level+"\"]")).click();
        $(By.xpath("//span[@title=\""+level+"\"]")).shouldBe(visible);
    }
    @Step("Выбрать дату С периода действия")
    public void chooseDate(String dateFrom){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//input[@placeholder=\"С\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//input[@placeholder=\"С\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//div[@class=\"ant-modal-body\"]//input[@placeholder=\"С\"]")).sendKeys(dateFrom);
        $(By.xpath("//div[@class=\"ant-modal-body\"]//input[@placeholder=\"С\"]")).pressEnter();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//input[@placeholder=\"По\"]")).pressEnter();
    }

    @Step("Выбрать первое право из списка прав")
    public void  chooseRights(){
        $(By.xpath("//ul[@class=\"ant-list-items\"]/div[1]//span[@class=\"ant-checkbox\"]")).click();
        $(By.xpath("//div[@class=\"ant-row\"]/div/button")).click();
        $(By.xpath("//div[text()=\"Выбранные права\"]/parent::div//ul/div")).shouldBe(visible);
    }

    //Кнопка создать
    @Step("Кнопка создать")
    public void create(){
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).shouldNotBe(disabled);
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).click();
    }

    //Кнопка отмена
    @Step("Кнопка отмена")
    public void cancel(){
        $(By.xpath("//span[text()=\"Отмена\"]")).click();
    }

    //Проверка что роль создалась
    @Step("Проверка, что роль создалась")
    public void checkRoleWasCreated(String rusName) {
        $(byText("Роль успешно создана")).shouldBe(visible);
        $(By.xpath("//div[@class=\"ant-modal-content\"]")).shouldNotBe(visible);
        $(By.xpath("//tbody/tr[2]/td[2]")).shouldHave(text(rusName));
    }

    // Открыть роль
    @Step("Открыть роль")
    public void openRole(){
        $(By.xpath("//tbody/tr[2]")).click();
        $(By.xpath("//div[text()=\"Общая информация\"]")).shouldBe(visible);
    }

    //Редактировать роль
    @Step("Кнопка редактировать роль")
    public void editRole(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Редактировать\"]")).click();
    }

    //Применить изменения
    @Step("Кнопка Применить в редактировании роли")
    public void editRoleApply(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Применить\"]")).click();
        $(byText("Роль успешно изменена")).shouldBe(visible);
    }



    // Кнопка деактивировать роль
    @Step("Нажать на кнопку деактивировать роль")
    public void deactivateRole(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Деактивировать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        //$(byText("Роль успешно деактивирована")).shouldBe(visible);
    }

    @Step("Проверить, что роль деактивирована")
    public void checkThatRoleDeactivated(){

        $(byText("Роль успешно деактивирована")).shouldBe(visible);
    }


    // Кнопка активировать роль
    @Step("Нажать на кнопку активировать роль")
    public void activateRole(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Активировать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();

    }

    @Step("Проверить, что роль активирована")
    public void checkThatRoleActivated(){

        $(byText("Роль успешно активирована")).shouldBe(visible);
    }


    @Step("Открыть пункт Пользователи в карточке пользователя")
    public void openRoleUsers() {
        $(By.xpath("//div[text()=\"Пользователи\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//tr/th")).shouldBe(visible);

    }

    @Step("Открыть пункт Служебная информация в карточке пользователя")
    public void openRoleServiceInfo() {
        $(By.xpath("//div[text()=\"Служебная информация\"]")).click();
        $(By.xpath("//label[text()=\"Кем зарегестрирован\"]")).shouldBe(visible);
    }

    @Step("Кнопка закрыть роль (крестик в правом верхнем углу)")
    public void closeRole() {
        $(By.xpath("//button[@aria-label=\"Close\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldNotBe(visible);
    }

    @Step("Проверка что уровень соответствует заданому параметру")
    public void checkLevel(String level){
        if(level == "УГД"){
            $(By.xpath("//tbody/tr[2]/td[4]")).shouldHave(text("UGD"));
        }
        if(level == "КГД"){
            $(By.xpath("//tbody/tr[2]/td[4]")).shouldHave(text("KGD"));
        }
        if(level == "ДГД"){
            $(By.xpath("//tbody/tr[2]/td[4]")).shouldHave(text("DGD"));
        }
    }

    @Step("Проверка что код уже зарегистрирован в системе")
    public void checkThatCodeExist(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);
        $(byText("Роль с таким кодом уже существует в системе")).shouldBe(visible);
    }

    @Step("Проверка того, что такое наименование уже существует в системе")
    public void checkThatNamesExist(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);
        $(byText("Роль с таким названием уже существует в системе")).shouldBe(visible);
    }


    //Кнопка создать неактивна
    @Step("Проверка, что кнопка Создать неактивна")
    public void checkThatButtonDisabled(){
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).shouldBe(disabled);
    }


    /*Поиск*/

    //Поиск по коду или наименованию
    @Step("Поиск роли по коду или наименованию")
    public void searchRole(String searchText){
        $(By.xpath("//input[@name=\"searchValue\"]")).setValue(searchText);
        $(By.xpath("//tbody/tr[2]")).shouldHave(text(searchText));

    }

    //Кнопка Расширенный поиск
    @Step("Нажать на кнопку Расширенный поиск роли")
    public void extendedSearch(){
        $(By.xpath("//div[@class=\"filter\"]")).click();
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).shouldBe(visible);
    }

    // Выбрать значение статуса в поиске
    @Step("Выбрать значение статуса в поиске")
    public void fillSearchStatus(String status){
        $(By.xpath("//span[text()=\"Выберите статус\"]/..//input")).click();
        $(By.xpath("//div[@title=\""+status+"\"]")).click();
    }

    // Выбрать значение модуля в поиске
    @Step("Выбрать значение модуля в поиске")
    public void chooseSearchModule(String searchModule){
        $(By.xpath("//label[@title=\"Подсистема/модуль\"]/../../div[2]//input")).click();
        if(searchModule =="Отчетность"|| searchModule =="Регистрация налогоплательщиков и ККМ" ||searchModule =="АРМ ОГД" ||searchModule == "Кабинет налогоплательщика" ){
            $(By.xpath("//div[@title=\"Лицевые счета\"]/..")).hover();
            $(By.xpath("//div[@title=\""+searchModule+"\"]")).scrollIntoView(false);
            $(By.xpath("//div[@title=\""+searchModule+"\"]")).click();
        }else{
            $(By.xpath("//div[@title=\""+searchModule+"\"]")).click();
        }

        $(By.xpath("//span[@title=\""+searchModule+"\"]")).shouldBe(visible);
    }

    // Выбрать значение модуля в поиске
    @Step("Выбрать значение уровня в поиске")
    public void chooseSearchLevel(String searchlevel){
        $(By.xpath("//label[text()=\"Уровень\"]/../..//input/../..")).click();
        $(By.xpath("//div[@title=\""+searchlevel+"\"]")).click();
    }

    // Кнопка Применить
    @Step("Нажать на кнопку применить в поиске")
    public void applySearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).click();
        $(By.xpath("//div[@class=\"filter opened\"]")).click();
    }

    // Кнопка Сбросить
    @Step("Нажать на кнопку сбросить в поиске")
    public void resetSearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Сбросить\"]")).click();

    }

    // Проверка, что статус соотвествует значению в поиске
    @Step("Проверка, что статус соотвествует значению в поиске")
    public void checkSearchStatus(String searchStatus) {
        $(By.xpath("//tbody/tr[2]/td[7]")).shouldHave(exactText(searchStatus));
    }



    // Проверка, что значение модуля соответствует значению в поиске
    @Step("Проверка, что значение модуля соответствует значению в поиске")
    public void checkSearchModule(String searchModule) {
        $(By.xpath("//tbody/tr[2]/td[3]")).shouldHave(text(searchModule));
    }

}
