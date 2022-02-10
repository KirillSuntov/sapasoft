package sapasoft.adm.pages;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class UsersManagmentPage {

    @Step("Открыть раздел упрваление пользователями")
    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[4]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Управление пользователями"));
    }

    // Открыть данные пользователя
    @Step("Открыть данные пользователя")
    public void openUser(){
        $(By.xpath("//tbody/tr[2]")).click();
        $(By.xpath("//div[text()=\"Редактировать пользователя\"]")).shouldBe(visible);
    }

    @Step("Поиск по ФИО")
    public void searchUser(String searchText){
        $(By.xpath("//input[@name=\"searchValue\"]")).setValue(searchText);
        $(By.xpath("//tbody/tr[2]")).shouldHave(text(searchText));

    }

    //Кнопка Расширенный поиск
    @Step("Кнопка расширенный поиск")
    public void extendedSearchUser(){
        $(By.xpath("//div[@class=\"filter\"]")).click();
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).shouldBe(visible);
    }

    public void chooseSearchModule(String searchModule){
        $(By.xpath("//label[@title=\"Подсистема/модуль\"]/ancestor::div[@class=\"ant-row ant-form-item\"]/div[2]")).click();
        $(By.xpath("//span[@title=\""+searchModule+"\"]")).click();

        // $(By.xpath("//div[@class=\"ant-modal-body\"]//div[@class=\"ant-select-selection-overflow\"]")).click();
        $(By.xpath("//span[@title=\""+searchModule+"\"]")).shouldBe(visible);
    }

    @Step("Выбрать орган государственных доходов в расширенном поиске")
    public void chooseSearchDepartment(String rolesGroupDepartment) {
        $(By.xpath("//span[text()=\"Наименование ОГД\"]/..//input")).click();

        $(By.xpath("//div[@title=\""+rolesGroupDepartment+"\"]")).click();

        //$(By.xpath("//div[@title=\""+rolesGroupDepartment+"\"]")).shouldBe(visible);

    }

    @Step("Выбрать статус в расширенном поиске")
    public void fillSearchStatus(String status){
        $(By.xpath("//span[text()=\"Выберите статус\"]/..//input")).click();
        $(By.xpath("//div[@title=\""+status+"\"]")).click();
    }

    // Кнопка Применить
    @Step("Нажать на кнопку применить в расширенном поиске")
    public void applySearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).click();
        $(By.xpath("//div[@class=\"filter opened\"]")).click();
    }

    // Кнопка Сбросить
    @Step("Нажать на кнопку сбросить в расширенном поиске")
    public void resetSearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Сбросить\"]")).click();
    }

    // Проверка, что статус соотвествует значению в поиске
    @Step("Проверка, что статус соотвествует значению в поиске")
    public void checkSearchStatus(String searchStatus) {
        $(By.xpath("//tbody/tr[2]/td[9]")).shouldHave(exactText(searchStatus));

    }

    @Step("Нажать на кнопку Заблокировать")
    public void blockUser(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//button//span[text()=\"Заблокировать\"]")).click();
    }

    @Step("Нажать на кнопку Разблокировать")
    public void unblockUser(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//button//span[text()=\"Разблокировать\"]")).click();
    }

    @Step("Нажать на кнопку Разблокировать после выбора причины и периода")
    public void unblockUserConfirm(){
        $(By.xpath("//div[text()=\"Разблокировать учетную запись\"]/..//button//span[text()=\"Разблокировать\"]")).click();
    }


    @Step("Выбрать причину блокировки")
    public void reasonOfBlockingUser(){
        $(By.xpath("//label[text()=\"Причина\"]/..//../div[2]//input")).click();
        $(By.xpath("//div[@title=\"Отпуск\"]")).click();
    }


    @Step("Выбрать дату С периода блокировки")
    public void chooseDateFrom(String dateFrom){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Период блокировки\"]/../../div[2]//input[@placeholder=\"С\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Период блокировки\"]/../../div[2]//input[@placeholder=\"С\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Период блокировки\"]/../../div[2]//input[@placeholder=\"С\"]")).sendKeys(dateFrom);
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Период блокировки\"]/../../div[2]//input[@placeholder=\"С\"]")).pressEnter();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Период блокировки\"]/../../div[2]//input[@placeholder=\"По\"]")).pressEnter();
    }

    @Step("Нажать на кнопку Заблокировать после выбора причины и периода")
    public void blockUserConfirm(){
        $(By.xpath("//div[text()=\"Заблокировать учетную запись\"]/..//button//span[text()=\"Заблокировать\"]")).click();
    }

    @Step("Проверка, что пользователь успешно заблокирован")
    public void checkThatUserBlocked(){
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Пользователь успешно заблокирован"));
        $(By.xpath("//div[@class=\"ant-modal-body\"]//button//span")).shouldHave(text("РАЗБЛОКИРОВАТЬ"));
    }

    @Step("Проверка, что пользователь успешно Разблокирован")
    public void checkThatUserUnblocked(){
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Пользователь успешно разблокирован"));
        $(By.xpath("//div[@class=\"ant-modal-body\"]//button[@class=\"ant-btn administration__button-red administration__float-right\"]//span")).shouldHave(text("ЗАБЛОКИРОВАТЬ"));
    }

    @Step("Кнопка закрыть редактирование пользователя (крестик в правом верхнем углу)")
    public void closeUserPage() {
        $(By.xpath("//button[@aria-label=\"Close\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldNotBe(visible);
    }





}


