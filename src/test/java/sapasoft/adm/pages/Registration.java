package sapasoft.adm.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import sapasoft.adm.testconfigs.BaseSetings;

import java.io.File;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Registration extends BaseSetings {

    @Step("Ввести ИИН")
    public void fillIIN(String iin) {
        $(By.xpath("//input[@placeholder=\"Введите ИИН/БИН\"]")).setValue(iin);
    }

    @Step("Нажать кнопку Поиск")
    public void pressSearch() {
        $(By.xpath("//button/span[text()=\"Поиск\"]")).click();
    }

    @Step("Ввести IP адрес")
    public void fillIPadress(String ipAdress) {
        $(By.xpath("//label[text()=\"IP адрес\"]/../../div[2]//input")).setValue(ipAdress);
    }

    @Step("Ввести номер подтверждающего документа")
    public void fillNumnerOfdDocunent() {
        $(By.xpath("//label[text()=\"№ подтверждающего документа\"]/../../div[2]//input")).setValue(""+System.currentTimeMillis()+"");
    }
    @Step("Выбрать дату приказа")
    public void chooseDate(String date){
        $(By.xpath("//label[text()=\"Дата приказа\"]/../../div[2]//input")).click();
        $(By.xpath("//label[text()=\"Дата приказа\"]/../../div[2]//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Дата приказа\"]/../../div[2]//input")).sendKeys(date);
        $(By.xpath("//label[text()=\"Дата приказа\"]/../../div[2]//input")).pressEnter();

    }

    @Step("Прикрепить документ")
    public void uploadFile() {
        File file = new File("src/test/resources/тест.xlsx");
        $(By.xpath("//input[@type=\"file\"]")).uploadFile(file);
    }

    @Step("Выбрать модуль")
    public void chooseModule(String module) {
        $(By.xpath("//label[text()=\"Подсистема/модуль\"]/../..//input")).click();
        $(byText(""+module+"")).scrollIntoView(false);
        $(By.xpath("//span[@title=\""+module+"\"]")).click();
        $(By.xpath("//label[text()=\"Подсистема/модуль\"]/../..//input")).click();
    }

    @Step("Выбрать права")
    public void chooseRights(){
        $(By.xpath("//div[text()=\"Доступные подсиcтемы (модули)/роли\"]/..//span[@class=\"ant-tree-checkbox-inner\"]")).click();
        $(By.xpath("//div[text()=\"Выбранные права\"]/..//span[@class=\"ant-tree-checkbox-inner\"]")).click();
    }

    @Step("Проверить что кнопка подписания ЭЦП активна")
    public void checkThatButtonActive(){
        $(By.xpath("//button[@class=\"ant-btn administration administration__button-gold\"]")).shouldBe(enabled);
    }

    @Step("Нажать кнопку отмена")
    public void pressCancel() {
        $(By.xpath("//button[@class=\"ant-btn administration__button-white\"]")).click();
    }
}
