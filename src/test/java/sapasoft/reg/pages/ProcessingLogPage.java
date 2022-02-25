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

    @Step("Поиск ФЛ в расширенном поиске")
    public void advancedSearchFL() {
        $("[class*=advancedSearch]").click();
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byClassName("antd-pro-components-search-by-parameters-index-dropDown")).$(byClassName("ant-select-selection-item")).click();
        $(byClassName("antd-pro-components-search-by-parameters-index-dropDown")).$(byText("ФЛ")).click();
        $(byText("Применить")).click();
        $(byClassName("ant-table-tbody")).shouldBe(visible);
        pause(3000);
    }

    @Step("Расширенный поиск выбор НП")
    public void advancedSearch_NP_Choose(String np) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byClassName("antd-pro-components-search-by-parameters-index-dropDown")).$(byClassName("ant-select-selection-item")).click();
        $(byClassName("antd-pro-components-search-by-parameters-index-dropDown")).$(byText(np)).click();
        
        $(byText("Применить")).click();
        $(byClassName("ant-table-tbody")).shouldBe(visible);
        pause(3000);
    }

    @Step("Расширенный поиск Применить")
    public void advancedSearch_Apply() {
        $(byText("Применить")).click();
        pause(3000);
    }



}
