package sapasoft.reg.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class UsersManagmentPage {

    @Step("Открыть раздел упрваление пользователями")
    public void open() {
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[4]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Управление пользователями"));
    }

    // Открыть данные пользователя
    @Step("Открыть данные пользователя")
    public void openUser() {
        $(By.xpath("//tbody/tr[2]")).click();
        $(By.xpath("//div[text()=\"Редактировать пользователя\"]")).shouldBe(visible);
    }

    @Step("Поиск по ФИО")
    public void searchUser(String searchText) {
        $(By.xpath("//input[@name=\"searchValue\"]")).setValue(searchText);
        $(By.xpath("//tbody/tr[2]")).shouldHave(text(searchText));

    }

    //Кнопка Расширенный поиск
    @Step("Кнопка расширенный поиск")
    public void extendedSearchUser() {
        $(By.xpath("//div[@class=\"filter\"]")).click();
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).shouldBe(visible);
    }

    @Step("Выбрать в расширенном поиске Подсистему/модуль")
    public void chooseSearchModule(String searchModule) {
        $(By.xpath("//label[@title=\"Подсистема/модуль\"]/ancestor::div[@class=\"ant-row ant-form-item\"]/div[2]")).click();
        int n = 50;
        int i = 0;
        while (element(Selectors.byXpath("//span[contains(@title,\"" + searchModule + "\")]")).is(Condition.not(visible))) {
            $(By.xpath("//label[@title=\"Подсистема/модуль\"]/ancestor::div[@class=\"ant-row ant-form-item\"]/div[2]//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//span[contains(@title,\"" + searchModule + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + searchModule + "\")]")).shouldBe(visible);
    }

    @Step("Проверка что Подсистема/модуль соответствует значению в поиске")
    public void checksearchModule(String searchModule) {
        $(By.xpath("//span[contains(@title,\"" + searchModule + "\")]")).shouldBe(exist);
    }

    @Step("Выбрать орган государственных доходов в расширенном поиске")
    public void chooseSearchDepartment(String usersDepartment) {
        $(By.xpath("//span[text()=\"Наименование ОГД\"]/..//input")).click();

        int n = 200;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(text(),\"" + usersDepartment + "\")]")).is(Condition.not(visible))) {
            $(By.xpath("//span[text()=\"Наименование ОГД\"]/..//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//div[contains(text(),\"" + usersDepartment + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + usersDepartment + "\")]")).shouldBe(visible);
    }

    @Step("Проверка, что значение органа государственных доходов в результате соответствует значению в расширенном поиске")
    public void checkSearchDepartment(String searchDepartment) {
        $(By.xpath("//tbody/tr[2]/td[7]")).shouldHave(exactText(searchDepartment));

    }

    @Step("Выбрать подразделение в расширенном поиске")
    public void chooseSearchSubdivision(String searchSubdivision) {
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

    @Step("Проверка, что подразделение в результате соответствует значению в расширенном поиске")
    public void checkSearchSubdivision(String subdivision) {
        $(By.xpath("//tr[2]/td[8]")).shouldHave(text(subdivision));
    }

    @Step("Выбрать должность в расширенном поиске")
    public void chooseSearchPosition(String position) {
        $(By.xpath("//label[@title=\"Должность\"]/../../div[2]//input")).click();
        $(By.xpath("//div[contains(@title,\"" + position + "\")]/div")).click();
    }

    @Step("Проверка, что должность в результате соответствует значению в расширенном поиске")
    public void checkSearchPosition(String position) {
        $(By.xpath("//tr[2]/td[5]")).shouldHave(text(position));
    }

    @Step("Выбрать статус в расширенном поиске")
    public void fillSearchStatus(String status) {
        $(By.xpath("//span[text()=\"Выберите статус\"]/..//input")).click();
        $(By.xpath("//div[@title=\"" + status + "\"]")).click();
    }

    // Кнопка Применить
    @Step("Нажать на кнопку применить в расширенном поиске")
    public void applySearch() {
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).click();

    }

    // Кнопка Сбросить
    @Step("Нажать на кнопку сбросить в расширенном поиске")
    public void resetSearch() {
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Сбросить\"]")).click();
    }

    // Проверка, что статус соотвествует значению в поиске
    @Step("Проверка, что статус соотвествует значению в поиске")
    public void checkSearchStatus(String searchStatus) {
        $(By.xpath("//tbody/tr[2]/td[9]")).shouldHave(exactText(searchStatus));

    }

    @Step("Нажать на кнопку Заблокировать")
    public void blockUser() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//button//span[text()=\"Заблокировать\"]")).click();
    }

    @Step("Нажать на кнопку Разблокировать")
    public void unblockUser() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//button//span[text()=\"Разблокировать\"]")).click();
    }

    @Step("Нажать на кнопку Разблокировать после выбора причины и периода")
    public void unblockUserConfirm() {
        $(By.xpath("//div[text()=\"Разблокировать учетную запись\"]/..//button//span[text()=\"Разблокировать\"]")).click();
    }


    @Step("Выбрать причину блокировки")
    public void reasonOfBlockingUser(String reason) {
        sleep(1000);
        $(By.xpath("//label[text()=\"Причина\"]/..//../div[2]//input")).click();
        $(By.xpath("//div[@title=\"" + reason + "\"]")).click();
    }


    @Step("Выбрать дату С периода блокировки")
    public void chooseDateFrom(String dateFrom) {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Период блокировки\"]/../../div[2]//input[@placeholder=\"С\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Период блокировки\"]/../../div[2]//input[@placeholder=\"С\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Период блокировки\"]/../../div[2]//input[@placeholder=\"С\"]")).sendKeys(dateFrom);
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Период блокировки\"]/../../div[2]//input[@placeholder=\"С\"]")).pressEnter();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Период блокировки\"]/../../div[2]//input[@placeholder=\"По\"]")).pressEnter();
    }

    @Step("Нажать на кнопку Заблокировать после выбора причины и периода")
    public void blockUserConfirm() {
        $(By.xpath("//div[text()=\"Заблокировать учетную запись\"]/..//button//span[text()=\"Заблокировать\"]")).click();
    }

    @Step("Проверка, что пользователь успешно заблокирован")
    public void checkThatUserBlocked() {
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Пользователь успешно заблокирован"));
        $(By.xpath("//div[@class=\"ant-modal-body\"]//button//span")).shouldHave(text("РАЗБЛОКИРОВАТЬ"));
    }

    @Step("Проверка, что пользователь успешно Разблокирован")
    public void checkThatUserUnblocked() {
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Пользователь успешно разблокирован"));
        $(By.xpath("//div[@class=\"ant-modal-body\"]//button[@class=\"ant-btn administration__button-red administration__float-right\"]//span")).shouldHave(text("ЗАБЛОКИРОВАТЬ"));
    }

    @Step("Кнопка закрыть редактирование пользователя (крестик в правом верхнем углу)")
    public void closeUserPage() {
        $(By.xpath("//button[@aria-label=\"Close\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldNotBe(visible);
    }

    @Step("Заполнить поле логин в расширенном поиске")
    public void fillLogin(String existLogin) {
        $(By.xpath("//input[@placeholder=\"Введите логин\"]")).setValue(existLogin);
    }

    @Step("Проверка, что логин в результате соответствует значению в расширенном поиске")
    public void checkLogin(String existLogin) {
        $(By.xpath("//tbody/tr[2]/td[1]")).shouldHave(text(existLogin));
    }

}


