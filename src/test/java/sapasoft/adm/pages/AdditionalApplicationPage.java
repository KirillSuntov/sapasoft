package sapasoft.adm.pages;

import org.openqa.selenium.By;


import java.io.File;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AdditionalApplicationPage {



    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[6]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Подача дополнительной заявки на предоставление роли и прав"));
    }

    public void choosePeriod(String dateFrom) {
        $(By.xpath("//label[text()=\"Период времени доступа\"]/../../div[2]//input[@placeholder=\"С\"]")).click();
        //$(By.xpath("//label[text()=\"Период времени доступа\"]/../../div[2]//input[@placeholder=\"С\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Период времени доступа\"]/../../div[2]//input[@placeholder=\"С\"]")).sendKeys(dateFrom);
        $(By.xpath("//label[text()=\"Период времени доступа\"]/../../div[2]//input[@placeholder=\"С\"]")).pressEnter();
        $(By.xpath("//label[text()=\"Период времени доступа\"]/../../div[2]//input[@placeholder=\"С\"]")).pressEnter();
    }

    public void chooseModule(String module) {
        $(By.xpath("//label[text()=\"Подсистема/модуль\"]/../..//input")).click();
        $(By.xpath("//span[@title=\""+module+"\"]")).click();
        $(By.xpath("//label[text()=\"Подсистема/модуль\"]/../..//input")).click();
    }

    public void uploadFile() {
        File file = new File("src/test/resources/тест.xlsx");
        $(By.xpath("//input[@type=\"file\"]")).uploadFile(file);
    }

    public void chooseRole() {
        $(By.xpath("//div[text()=\"Доступные подсиcтемы (модули)/роли\"]/..//span[@class=\"ant-tree-checkbox-inner\"]")).click();
    }

    public void chooseRight() {
        $(By.xpath("//div[text()=\"Выбранные права\"]/..//span[@class=\"ant-tree-checkbox-inner\"]")).click();
    }

    public void agreementText() {
        $(By.xpath("//span[text()=\"ТЕКСТ СОГЛАШЕНИЯ\"]")).click();
    }

    public void checkSignButton() {
        $(By.xpath("//button[@class=\"ant-btn appBtnSecondary btnStyle\"]/span")).shouldBe(enabled);
    }
}
