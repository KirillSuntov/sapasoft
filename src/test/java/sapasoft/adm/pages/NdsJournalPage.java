package sapasoft.adm.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import sapasoft.adm.testconfigs.BaseSetings;

import java.io.File;

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
        $(by("data-row-key","1")).click();
    }

    @Step("Проверка ответа по постановке на учет по НДС. Ожидаемый ответ: {0}")
    public void checkMessage(String expectedRejectCause) {
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.ndsJournal().open();

        adm.ndsJournal().chooseMessage("430216434014");
        $$(By.className("mb-disable")).get(1).shouldBe(text("Регистрационные сведения")).click();
//        $(By.className("antd-pro-components-modal-index-modalFooter")).scrollTo();

        $(byText(expectedRejectCause)).shouldBe(visible);

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
