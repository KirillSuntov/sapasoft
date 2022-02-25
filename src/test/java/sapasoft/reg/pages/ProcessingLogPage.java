package sapasoft.reg.pages;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import sapasoft.reg.testconfigs.BaseSetings;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProcessingLogPage extends BaseSetings {


    @Step("Открыть раздел Журнал обработки сообщений")
    public void open() {

        $("[href*=processing-log]").click();
//        $(byText("Журнал НДС")).click();

    }

    @Step("Открыть расширенный поиск")
    public void advancedSearch() {
        $("[class*=advancedSearch]").click();
        pause(1000);
//        $(by("data-row-key", "1")).click();
    }

    @Step("Поиск ИП в расширенном поиске")
    public void advancedSearchFL() {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("//*[@id=\"searchByParameters\"]/div[2]/div/div/div/div/form/div[1]/div[1]/div/div[2]/div/div/div/div")).$(byClassName("ant-select-selection-item")).click();
        $(byClassName("rc-virtual-list-holder-inner")).$(byText("ИП")).click();
        $(byText("Применить")).click();
        $(byClassName("ant-table-tbody")).shouldBe(visible);
        pause(3000);
    }

    @Step("Расширенный поиск выбор НП")
    public void advancedSearch_Choose_NP(String np) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("//*[@id=\"searchByParameters\"]/div[2]/div/div/div/div/form/div[1]/div[1]/div/div[2]")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(0).$(byText(np)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Статус сообщения")
    public void advancedSearch_Choose_Status(String status) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("//*[@id=\"searchByParameters\"]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div[2]/div/div/div/div/div")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(1).$(byText(status)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Вид сообщения")
    public void advancedSearch_Choose_MsgType(String type) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("//*[@id=\"searchByParameters\"]/div[2]/div/div/div/div/form/div[2]/div[1]/div/div[2]/div/div/div/div")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(2).$(byText(type)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Источник сообщения")
    public void advancedSearch_Choose_MsgSource(String source) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("/html/body/div[1]/div/section/section/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[2]/div/div[2]/div/div/div/div")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(3).$(byText(source)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Тип операции")
    public void advancedSearch_Choose_OperationType(String type) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("/html/body/div[1]/div/section/section/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[3]/div/div[2]/div/div/div/div")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(4).$(byText(type)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Код типа сообщения")
    public void advancedSearch_Choose_CodeTypeMsg(String type) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("/html/body/div[1]/div/section/section/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[4]/div/div[2]/div/div/div/div")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(5).$(byText(type)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск Применить")
    public void advancedSearch_Apply() {
        $(byText("Применить")).click();
        pause(3000);
    }



}
