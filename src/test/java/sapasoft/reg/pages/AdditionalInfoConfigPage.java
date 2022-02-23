package sapasoft.reg.pages;

import io.qameta.allure.Step;
import sapasoft.reg.testconfigs.BaseSetings;

import static com.codeborne.selenide.Selenide.$;

public class AdditionalInfoConfigPage extends BaseSetings {


    @Step("Конфигуратор дополнительных сведений")
    public void open() {

        $("[href*=AdditionalInfoConfig]").click();
//        $(byText("Журнал НДС")).click();

    }

    @Step("Открыть расширенный поиск")
    public void advancedSearch() {
        $("[class*=advancedSearch]").click();
        pause(1000);
//        $(by("data-row-key", "1")).click();
    }





}
