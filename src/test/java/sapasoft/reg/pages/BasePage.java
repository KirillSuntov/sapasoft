package sapasoft.reg.pages;

import com.sun.source.tree.IfTree;
import io.qameta.allure.Step;
import org.junit.Test;
import org.openqa.selenium.By;
import sapasoft.reg.testconfigs.BaseSetings;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage extends BaseSetings {

    @Step("Проверка заголовка")
    public void checkTitle(String title) {
        $(By.className("antd-pro-components-typography-title-index-title")).text().equals(title);
    }



}
