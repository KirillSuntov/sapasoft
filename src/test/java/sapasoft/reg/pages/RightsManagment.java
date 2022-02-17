package sapasoft.reg.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.element;


public class RightsManagment {
    //Открываем раздел Управление правами
    @Step("Открываем раздел Управление правами")
    public void open() {
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[1]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Управление правами"));
    }


    @Step("Кнопка создать новое прво")
    public void createNewRight() {
        $(By.xpath("//button/span[text()=\"Создать новое право\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);
    }


    @Step("Заполняем поля наименования на русском, казахском и казахском (латиница), английском")
    public void fillNames(String rusName, String engName) {
        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на английском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).setValue(rusName);
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).sendKeys(rusName);
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).sendKeys(engName);
        $(By.xpath("//label[text()=\"Наименование на английском\"]/parent::div/parent::div//input")).sendKeys(engName);
    }

    @Step("Выбрать модуль")
    public void chooseModule(String module) {
        $(By.xpath("//div[@class=\"ant-modal-content\"]//input[@type=\"search\"]")).click();
        int n=20;
        int i=0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + module + "\")]")).is(Condition.not(visible))) {
            $(By.xpath("//div[@class=\"ant-modal-content\"]//input[@type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
            i=i+1;
            if(i==n)break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + module + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + module + "\")]")).shouldBe(visible);
    }


    @Step("Заполнить поле код")
    public void fillCode(String code) {
        $(By.xpath("//input[@placeholder=\"Введите код права\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//input[@placeholder=\"Введите код права\"]")).setValue(code);
    }


    @Step("Синхронизировать с КГП (чекбокс)")
    public void synchronizeKNP() {
        $(By.xpath("//label/span[@class=\"ant-checkbox\"]")).click();
        $(By.xpath("//span[@class=\"ant-checkbox ant-checkbox-checked\"]")).shouldBe(visible);
    }

    //Кнопка создать
    @Step("Кнопка создать")
    public void create() {
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).click();
    }


    @Step("Кнопка отмена")
    public void cancel() {
        $(By.xpath("//span[text()=\"Отмена\"]")).click();
    }


    @Step("Проверка что право создалось")
    public void checkRightWasCreated(String rusName) {
        $(byText("Право успешно создано")).shouldBe(visible);
        $(By.xpath("//div[@class=\"ant-modal-content\"]")).shouldNotBe(visible);
        $(By.xpath("//tbody/tr[1]/td[2]")).shouldHave(text(rusName));
    }


    @Step("Открыть право")
    public void openRight() {
        $(By.xpath("//tbody/tr[1]")).click();
        $(By.xpath("//div[text()=\"Общая информация\"]")).shouldBe(visible);
    }


    @Step("Редактировать право")
    public void editRight() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Редактировать\"]")).click();
    }


    @Step("Применить измения")
    public void editRightApply() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Применить\"]")).click();
        $(byText("Право успешно изменено")).shouldBe(visible);
    }


    @Step("Кнопка деактивировать право")
    public void deactivateRight() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Деактивировать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        $(byText("Право успешно деактивировано")).shouldBe(visible);
    }


    @Step("Кнопка активировать право")
    public void activateRight() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Активировать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        $(byText("Право успешно активировано")).shouldBe(visible);
    }

    @Step("Проверка что право с таким кодом уже существует")
    public void checkThatCodeExist() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Право с таким кодом уже существует в системе"));

    }

    @Step("Проверка что право с таким именем уже существует")
    public void checkThatNamesExist() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Право с таким названием уже существует в системе"));
        //$(byText("Право с таким названием уже существует в системе")).shouldBe(visible);
    }


    @Step("Поиск по коду или наименованию")
    public void searchRight(String searchText) {
        $(By.xpath("//input[@name=\"searchValue\"]")).setValue(searchText);

        $(By.xpath("//tbody/tr[1]")).shouldHave(text(searchText));

    }


    @Step("Кнопка расширенный поиск")
    public void extendedSearch() {
        $(By.xpath("//div[@class=\"filter\"]")).click();
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).shouldBe(visible);
    }


    @Step("Выбрать значение статуса в поиске")
    public void fillSearchStatus(String status) {
        $(By.xpath("//span[text()=\"Выберите статус\"]/..//input")).click();
        $(By.xpath("//div[@title=\"" + status + "\"]")).click();
    }


    @Step("Выбрать значение модуля в поиске")
    public void chooseSearchModule(String searchModule) {
        $(By.xpath("//label[@title=\"Подсистема/модуль\"]/../../div[2]//input")).click();
        int n=20;
        int i=0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + searchModule + "\")]")).is(Condition.not(visible))) {
            $(By.xpath("//label[@title=\"Подсистема/модуль\"]/../../div[2]//input")).sendKeys(Keys.ARROW_DOWN);
            i=i+1;
            if (i==n)break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + searchModule + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + searchModule + "\")]")).shouldBe(visible);
    }


    @Step("Нажать кнопку применить в поиске")
    public void applySearch() {
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).click();
        //$(By.xpath("//div[@class=\"filter opened\"]")).click();
    }


    @Step("Нажать кнопку сбросить в поиске")
    public void resetSearch() {
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Сбросить\"]")).click();
    }


    @Step("Проверка, что статус соответствует значению в поиске")
    public void checkSearchStatus(String searchStatus) {
        $(By.xpath("//tbody/tr[1]/td[6]")).shouldHave(exactText(searchStatus));
    }


    @Step("Проверка, что значение модуля соответствует значению в поиске")
    public void checkSearchModule(String searchModule) {
        $(By.xpath("//tbody/tr[1]/td[3]")).shouldHave(exactText(searchModule));
    }

    @Step("Очистить поле поиска")
    public void clearSearchField() {
        $(By.xpath("//input[@name=\"searchValue\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);

    }
}
