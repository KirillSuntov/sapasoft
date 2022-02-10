package sapasoft.adm.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class RolesGroupsManagmentPage {

    @Step("Открываем раздел \"Управление группами ролей\"")
    public void open() {
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[3]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Управление группами ролей"));
    }

    @Step("Нажать на кнопку создать новую группу ролей")
    public void createNewRolesGroup() {
        $(By.xpath("//button/span[text()=\"Создать группу ролей\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);

    }

    @Step("Ввести код группы ролей")
    public void fillCode(String rolesGroupCode) {
        $(By.xpath("//input[@placeholder=\"Введите код группы\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//input[@placeholder=\"Введите код группы\"]")).setValue(rolesGroupCode);
    }

    @Step("Ввести наименования группы ролей")
    public void fillNames(String rusName, String engName) {
        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на английском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);

        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).sendKeys(rusName);
        Selenide.sleep(1000);
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).sendKeys(rusName);
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).sendKeys(engName);
        $(By.xpath("//label[text()=\"Наименование на английском\"]/parent::div/parent::div//input")).sendKeys(engName);
    }

    @Step("Выбрать модуль группу ролей")
    public void chooseModule(String module) {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подсистема/модуль\"]/../..//input")).click();
        $(By.xpath("//span[@title=\"" + module + "\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подсистема/модуль\"]/../..//input")).click();
        $(By.xpath("//span[@title=\"" + module + "\"]")).shouldBe(visible);
    }

    @Step("Выбрать орган государственных доходов")
    public void chooseDepartment(String rolesGroupDepartment) {
        $(By.xpath("//span[@class=\"ant-input-group ant-input-group-compact\"]/div[2]//input")).click();
        int n = 200;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + rolesGroupDepartment + "\")]")).is(Condition.not(visible))) {
            $(By.xpath("//span[@class=\"ant-input-group ant-input-group-compact\"]/div[2]//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//div[contains(@title,\"" + rolesGroupDepartment + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + rolesGroupDepartment + "\")]")).shouldBe(visible);

    }

    @Step("Выбрать подразделение")
    public void chooserolesGroupSubdivision(String rolesGroupSubdivision) {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подразделение\"]/../../div[2]")).shouldNotBe(disabled);
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подразделение\"]/../../div[2]")).click();
        int n = 100;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + rolesGroupSubdivision + "\")]")).is(Condition.not(visible))) {
            $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подразделение\"]/../../div[2]//input")).sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + rolesGroupSubdivision + "\")]")).click();
        element(Selectors.byXpath("//div[contains(@title,\"" + rolesGroupSubdivision + "\")]")).shouldBe(visible);
    }

    @Step("Выбрать должность")
    public void chooserolesGroupPosition() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Должность\"]/../..//input")).click();
        $(By.xpath("//div[6]/div/div/div/div[2]/div[1]/div/div/div[1]")).click();
    }

    @Step("Выбрать доступную роль")
    public void chooseRoles() {
        $(By.xpath("//ul[@class=\"ant-list-items\"]/div[1]//span[@class=\"ant-checkbox\"]")).click();
        $(By.xpath("//*[@class=\"ant-btn administration__button-white administration__button-arrow\"][1]")).click();
        $(By.xpath("//div[text()=\"Выбранные роли\"]/parent::div//ul/div[1]")).shouldBe(visible);
    }


    @Step("Нажать на кнопку создать")
    public void create() {
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).shouldNotBe(disabled);
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).click();
    }

    //Кнопка отмена
    @Step("Кнопка отмена")
    public void cancel() {
        $(By.xpath("//span[text()=\"Отмена\"]")).click();
    }

    @Step("Проверка, что роль была создана")
    public void checkRoleWasCreated() {
        $(byText("Группа ролей успешно создана")).shouldBe(visible);
        $(By.xpath("//div[@class=\"ant-modal-content\"]")).shouldNotBe(visible);

    }

    @Step("Нажать на группу ролей для открытия информации")
    public void openRolesGroup() {
        $(By.xpath("//tbody/tr[2]")).click();
        $(By.xpath("//div[text()=\"Роли\"]")).shouldBe(visible);
    }

    @Step("Нажать на кнопку редактировать")
    public void editRolesGroup() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Редактировать\"]")).click();
    }

    @Step("Кнопка Применить в редактировании группы ролей")
    public void editRolesGroupApply() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Применить\"]")).click();
        $(byText("Группа ролей успешно изменена")).shouldBe(visible);
    }


    @Step("Нажать на кнопку деактивировать группу ролей")
    public void deactivateRolesGroup() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Деактивировать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Группа ролей успешно деактивирована"));
    }

    @Step("Нажать на кнопку активировать группу ролей")
    public void activateRolesGroup() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Активировать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        $(byText("Группа ролей успешно активирована")).shouldBe(visible);
    }

    @Step("Поиск группы ролей по названию")
    public void searchRolesGroup(String searchText) {
        $(By.xpath("//input[@name=\"searchValue\"]")).setValue(searchText);
        Selenide.sleep(1000);
        $(By.xpath("//tbody/tr[2]")).shouldHave(text(searchText));

    }

    @Step("Нажать на кнопку расширенный поиск")
    public void extendedSearch() {
        $(By.xpath("//div[@class=\"filter\"]")).click();
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).shouldBe(visible);
    }


    @Step("Выбрать статус в расширенном поиске")
    public void fillSearchStatus(String status) {
        $(By.xpath("//span[text()=\"Выберите статус\"]/..//input")).click();
        $(By.xpath("//div[@title=\"" + status + "\"]")).click();
    }


    @Step("Нажать на кнопку применить в расширенном поиске")
    public void applySearch() {
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).click();
    }


    @Step("Нажать на кнопку сбросить в расширенном поиске")
    public void resetSearch() {
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Сбросить\"]")).click();
    }


    @Step("Проверка, что статус соотвествует значению в поиске")
    public void checkSearchStatus(String searchStatus) {
        $(By.xpath("//tbody/tr[2]/td[9]")).shouldHave(exactText(searchStatus));
    }

    @Step("Выбрать подсистему/модуль в поиске")
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

    @Step("Проверка, что значение органа государственных доходов соответствует значению в расширенном поиске")
    public void checkSearchModule(String searchModule) {
        $(By.xpath("//span[text()=\"Подсистема/модуль\"]/div/div")).shouldHave(exactText(searchModule));
    }

    @Step("Выбрать орган государственных доходов в расширенном поиске")
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

    @Step("Проверка, что значение органа государственных доходов соответствует значению в расширенном поиске")
    public void checkSearchDepartment(String searchDepartment) {
        $(By.xpath("//tbody/tr[2]/td[3]")).shouldHave(exactText(searchDepartment));

    }

    @Step("Выбрать подразделение в расширенном поиске")
    public void chooserolesGroupSearchSubdivision(String searchSubdivision) {
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

    @Step("Проверка, что значение подразделения соответствует значению в расширенном поиске")
    public void checkSearchSubdivision(String searchSubdivision) {
        $(By.xpath("//tbody/tr[2]/td[4]")).shouldHave(exactText(searchSubdivision));
    }

    @Step("Открыть пункт Пользователи в карточке группы ролей")
    public void openRolesGroupUsers() {
        $(By.xpath("//div[text()=\"Пользователи\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//tr/th")).shouldBe(visible);

    }

    @Step("Открыть пункт Служебная информация в карточке группы ролей")
    public void openRolesGroupServiceInfo() {
        $(By.xpath("//div[text()=\"Служебная информация\"]")).click();
        $(By.xpath("//label[text()=\"Кем зарегестрирован\"]")).shouldBe(visible);
    }

    @Step("Кнопка закрыть группу ролей (крестик в правом верхнем углу)")
    public void closeRolesGroup() {
        $(By.xpath("//button[@aria-label=\"Close\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldNotBe(visible);
    }

    @Step("Проверка что код уже зарегистрирован в системе")
    public void checkThatCodeExist() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);
        $(byText("Группа ролей с таким кодом уже существует в системе")).shouldBe(visible);
    }

    @Step("Проверка что название уже зарегистрировано в системе")
    public void checkThatCodeNameExist() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);
        $(byText("Группа ролей с таким названием уже существует в системе")).shouldBe(visible);
    }

    @Step("Очистить поле поиска")
    public void clearSearchField() {
        $(By.xpath("//input[@name=\"searchValue\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);

    }
}
