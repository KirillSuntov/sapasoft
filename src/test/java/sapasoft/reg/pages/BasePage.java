package sapasoft.reg.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import sapasoft.reg.testconfigs.BaseSetings;

import static com.codeborne.selenide.Selenide.$;

public class BasePage extends BaseSetings {

    @Step("Проверерка заголовка")
    public void checkTitle(String title) {
        $(By.className("antd-pro-components-typography-title-index-title")).text().equals(title);
    }




}
