package sapasoft.reg.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import sapasoft.reg.testconfigs.BaseSetings;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class NdsJournalPage extends BaseSetings {


    @Step("Открыть раздел Журнал НДС")
    public void open() {
        $(byText("Журнал НДС")).click();

    }

    //    @Step("Выбрать период времени доступа")
//    public void choosePeriod(String dateFrom) {
//        $(By.xpath("//label[text()=\"Период времени доступа\"]/../../div[2]//input[@placeholder=\"С\"]")).click();
//        //$(By.xpath("//label[text()=\"Период времени доступа\"]/../../div[2]//input[@placeholder=\"С\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
//        $(By.xpath("//label[text()=\"Период времени доступа\"]/../../div[2]//input[@placeholder=\"С\"]")).sendKeys(dateFrom);
//        $(By.xpath("//label[text()=\"Период времени доступа\"]/../../div[2]//input[@placeholder=\"С\"]")).pressEnter();
//        $(By.xpath("//label[text()=\"Период времени доступа\"]/../../div[2]//input[@placeholder=\"С\"]")).pressEnter();
//    }
//
    @Step("Выбрать запись в журнале по ИИН/БИН")
    public void chooseMessage(String IinBin) {

        $(By.className("ant-select-selection-overflow")).click();
        $(By.className("ant-select-selection-search-input")).sendKeys(IinBin);
        $(By.className("ant-select-selection-search-input")).sendKeys(Keys.ENTER);
        pause(1000);
        $(by("data-row-key", "1")).click();
    }

    @Step("Проверка значений.  \n Столбец: {0}\n Значение: {1}")
    public static Boolean getCellText(String tablethead, String expectedCellText, int rowNumber) throws IOException {
        int Cell = 0;

        for (int i = 0; i < $(By.className("ant-modal-body")).$(By.className("ant-table-thead")).$$(By.className("ant-table-cell")).size(); i++) {
            if (($(By.className("ant-modal-body")).$(By.className("ant-table-thead")).$$(By.className("ant-table-cell")).get(i).getText()).equals(tablethead)) {
                System.out.println("порядковый номер: " + i);
                Cell = i;
            }
        }

        if (expectedCellText.equals($(By.className("ant-table-tbody")).$$("[class*=ant-table-row-level-0]").get(rowNumber).$$(By.className("ant-table-cell")).get(Cell).getText())) {
            return true;

        } else {

            Assert.fail("Ответ не соответствует ожидаемому: "+$(By.className("ant-table-tbody")).$$("[class*=ant-table-row-level-0]").get(rowNumber).$$(By.className("ant-table-cell")).get(Cell).getText());

            return false;
        }


    }


    @Step("Выбрать запись в журнале НДС, вкладка \"Плательшики НДС\" по ИИН/БИН")
    public void chooseCertificate(String IinBin) {

        $(byText("Плательщики НДС")).click();
        $(by("placeholder", "Поиск по ИИН/БИН или ФИО/Наименование (минимум 3 символа)")).sendKeys(IinBin);
        $(by("data-row-key", "1")).click();
        $(byText("НЗ о регистрационном учете по НДС")).shouldBe(visible);
        $(byText("Выдано свидетельство")).shouldBe(visible);

    }

    @Step("Фронт. Проверка ответа в журнале сообщений по постановке на учет по НДС. Ожидаемый ответ: {0}")
    public void checkMessage(String expectedRejectCause, String IinBin) {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.ndsJournal().open();

        reg.ndsJournal().chooseMessage(IinBin);
        $$(By.className("mb-disable")).get(1).shouldBe(text("Регистрационные сведения")).click();
        $(byText(expectedRejectCause)).shouldBe(visible);
    }

    @Step("Фронт. Проверка ответа в журнале сообщений по постановке на учет по НДС. Ожидаемый ответ: {0}")
    public void checkCertificate(String expectedCause, String IinBin) {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.ndsJournal().open();

        reg.ndsJournal().chooseCertificate(IinBin);
        $(byText("Снят с учета")).shouldBe(visible);
        $(byText(expectedCause)).shouldBe(visible);
//        $$(By.className("mb-disable")).get(1).shouldBe(text("Регистрационные сведения")).click();
//        $(byText(expectedCause)).shouldBe(visible);
    }

//
//    @Step("Прикрепить файл")
//    public void uploadFile() {
//        File file = new File("src/test/resources/тест.xlsx");
//        $(By.xpath("//input[@type=\"file\"]")).uploadFile(file);
//    }
//
//    @Step("Выбрать роль")
//    public void chooseRole() {
//        $(By.xpath("//div[text()=\"Доступные подсиcтемы (модули)/роли\"]/..//span[@class=\"ant-tree-checkbox-inner\"]")).shouldBe(visible);
//        $(By.xpath("//div[text()=\"Доступные подсиcтемы (модули)/роли\"]/..//span[@class=\"ant-tree-checkbox-inner\"]")).click();
//    }
//
//    @Step("Выбрать права")
//    public void chooseRight() {
//        $(By.xpath("//div[text()=\"Выбранные права\"]/..//span[@class=\"ant-tree-checkbox-inner\"]")).click();
//    }
//
//    @Step("Подтвердить текст соглашения")
//    public void agreementText() {
//        $(By.xpath("//span[text()=\"ТЕКСТ СОГЛАШЕНИЯ\"]")).click();
//    }
//
//    @Step("Проверка, что кнопка подписать активна")
//    public void checkSignButton() {
//        $(By.xpath("//button[@class=\"ant-btn appBtnSecondary btnStyle\"]/span")).shouldBe(enabled);
//    }
}
