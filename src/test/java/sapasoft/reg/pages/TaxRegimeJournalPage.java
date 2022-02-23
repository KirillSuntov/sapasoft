package sapasoft.reg.pages;

import io.qameta.allure.Step;
import sapasoft.reg.testconfigs.BaseSetings;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TaxRegimeJournalPage extends BaseSetings {


    @Step("Открыть раздел Реестр налогоплательщиков")
    public void open() {

        $("[href*=np-journal]").click();
//        $(byText("Журнал НДС")).click();

    }

    @Step("Открыть расширенный поиск")
    public void advancedSearch() {
        $("[class*=advancedSearch]").click();
        pause(1000);
//        $(by("data-row-key", "1")).click();
    }



}
