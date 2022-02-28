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

public class ProcessingLogPage extends BaseSetings {

    public static String Msg_Status;

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

    @Step("Расширенный поиск выбор НП")
    public void advancedSearch_Choose_NP(String np) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("//*[@id=\"searchByParameters\"]/div[2]/div/div/div/div/form/div[1]/div[1]/div/div[2]")).click();
        //$(byId("personType")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(0).$(byText(np)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Статус сообщения: {0}")
    public void advancedSearch_Choose_Status(String status) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        //$(byXpath("//*[@id=\"searchByParameters\"]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div[2]/div/div/div/div/div")).click();
        $(byId("messageStatus")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(1).$(byText(status)).click();
        this.Msg_Status = status;
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Вид сообщения")
    public void advancedSearch_Choose_MsgType(String type) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("//*[@id=\"searchByParameters\"]/div[2]/div/div/div/div/form/div[2]/div[1]/div/div[2]/div/div/div/div")).click();
        //$(byId("messageMode")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(2).$(byText(type)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Источник сообщения")
    public void advancedSearch_Choose_MsgSource(String source) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        //$(byXpath("/html/body/div[1]/div/section/section/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[2]/div/div[2]/div/div/div/div")).click();
        $(byId("exchangeSystems")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(3).$(byText(source)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Тип операции")
    public void advancedSearch_Choose_OperationType(String type) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        //$(byXpath("/html/body/div[1]/div/section/section/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[3]/div/div[2]/div/div/div/div")).click();
        $(byId("operationType")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(4).$(byText(type)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Код типа сообщения")
    public void advancedSearch_Choose_CodeTypeMsg(String type) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
       //$(byXpath("/html/body/div[1]/div/section/section/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[4]/div/div[2]/div/div/div/div")).click();
        $(byId("messageType")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(5).$(byText(type)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск Применить")
    public void advancedSearch_Apply() {
        $(byText("Применить")).click();
        pause(3000);
    }

    @Step("Проверка статуса сообщения с поисковым статусом")
    public void Check_Equality_Of_Status_To_Search() {
       /*System.out.println("CHECK START: ");
        System.out.println("II: " + $(byClassName("ant-table-tbody")).$$(byClassName("ant-table-row")).get(1));
        System.out.println("III: " + $(byClassName("ant-table-tbody")).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")));
        System.out.println("IIII: " + $$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")));
        System.out.println("IIIII: " + $$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6));
        */
        for(int i = 0; i < $$(byClassName("ant-table-tbody")).size(); i++){
            /*System.out.println("MSG_Status: " + this.Msg_Status);
            System.out.println("STATUS: " + $$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6).getText());
            */
            $$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6).getText().equals(this.Msg_Status);


            //$$(byClassName("ant-table-tbody")).get(i).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).equals(Msg_Status);
            //System.out.println("I = " + i + " : " + $$(byClassName("ant-table-tbody")).get(i).$(byClassName("ant-table-row ant-table-row-level-0")));
        }
        pause(3000);
    }

}
