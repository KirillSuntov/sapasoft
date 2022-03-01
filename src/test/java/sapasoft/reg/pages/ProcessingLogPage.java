package sapasoft.reg.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import sapasoft.reg.testconfigs.BaseSetings;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ProcessingLogPage extends BaseSetings {

    public static String Msg_Status;
    public static String Msg_Type;
    public static String Msg_Source;
    public static String Operation_Type;

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
        this.Msg_Type = type;
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
        this.Msg_Source = source;
        $(byId("exchangeSystems")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(3).$(byText(source)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Тип операции")
    public void advancedSearch_Choose_OperationType(String type) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        //$(byXpath("/html/body/div[1]/div/section/section/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[3]/div/div[2]/div/div/div/div")).click();
        this.Operation_Type = type;
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
        for(int i = 0; i < $$(byClassName("ant-table-tbody")).size(); i++){
            System.out.println("MSG_Status: " + this.Msg_Status);
            System.out.println("STATUS: " + $$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6).getText());
            $$(byClassName("ant-table-tbody")).get(i).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).equals(Msg_Status);
            System.out.println("I = " + i + " : " + $$(byClassName("ant-table-tbody")).get(i).$(byClassName("ant-table-row ant-table-row-level-0")));

        }*/
        this.Msg_Status = "SSS";
        if(!$$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6).getText().equals(this.Msg_Status)){
            Assert.fail("Значение статуса не соответствует выброному в расширенном поиске");
        }
    }

    @Step("Проверка вида сообщения с поисковым видом")
    public void Check_Equality_Of_MsgType_To_Search() {
        if(this.Msg_Type == "Исходящее"){
            if(!$$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6).getText().equals("Отправлено")){
                Assert.fail("Значение Вид сообщения не соответствует выброному в расширенном поиске");
            }
        }
        else{
            if($$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6).getText().equals("Отправлено")){
                Assert.fail("Значение Вид сообщения не соответствует выброному в расширенном поиске");
            }
        }
    }

    @Step("Проверка источника сообщения с поисковым статусом")
    public void Check_Equality_Of_MsgSource_To_Search() {
        this.Msg_Source = "ssss";
        if(!$$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(8).getText().equals(this.Msg_Source)){
            Assert.fail("Значение Источника сообщения не соответствует выброному в расширенном поиске");
        }
    }

    @Step("Проверка Типа операции сообщения с поисковым статусом")
    public void Check_Equality_Of_OperationType_To_Search() {
        this.Operation_Type = "sssss";
        System.out.println($$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(3).getText());
        System.out.println(this.Operation_Type);
        if(!$$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(3).getText().equals(this.Operation_Type)){
            Assert.fail("Значение Тип операции не соответствует выброному в расширенном поиске");
        }
    }
}
