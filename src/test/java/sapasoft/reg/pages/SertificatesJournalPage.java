package sapasoft.reg.pages;

import io.qameta.allure.Step;
import sapasoft.reg.testconfigs.BaseSetings;

import static com.codeborne.selenide.Selenide.$;

public class SertificatesJournalPage extends BaseSetings {


    @Step("Журнал выдачи сертификатов резидентства")
    public void open() {

        $("[href*=SertificatesJournal]").click();
//        $(byText("Журнал НДС")).click();

    }

    @Step("Открыть расширенный поиск")
    public void advancedSearch() {
        $("[class*=advancedSearch]").click();
        pause(1000);
//        $(by("data-row-key", "1")).click();
    }





}
