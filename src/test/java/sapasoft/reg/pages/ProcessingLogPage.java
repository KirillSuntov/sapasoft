package sapasoft.reg.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import sapasoft.reg.testconfigs.BaseSetings;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
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
//        $(By.className("ant-select-selection-overflow")).click();
//        $(By.className("ant-select-selection-search-input")).sendKeys(IinBin);
//        $(By.className("ant-select-selection-search-input")).sendKeys(Keys.ENTER);
        pause(1000);
//        $(by("data-row-key", "1")).click();
    }






    @Step("Фронт. Проверка ответа в журнале сообщений по постановке на учет по НДС. Ожидаемый ответ: {0}")
    public void checkMessage(String expectedRejectCause, String IinBin) {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.ndsJournal().open();

        adm.ndsJournal().chooseMessage(IinBin);
        $$(By.className("mb-disable")).get(1).shouldBe(text("Регистрационные сведения")).click();
        $(byText(expectedRejectCause)).shouldBe(visible);
    }



}
