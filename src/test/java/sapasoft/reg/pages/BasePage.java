package sapasoft.reg.pages;

//import com.sun.source.tree.IfTree;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import sapasoft.reg.testconfigs.BaseSetings;
//import com.codeborne.selenide.Selenide.by;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class BasePage extends BaseSetings {

    @Step("Проверка заголовка")
    public void checkTitle(String title) {
        $(By.className("antd-pro-components-typography-title-index-title")).text().equals(title);
    }

    @Step("Проверка содержимого раздела {0}")
    public void checkTbody(String title) {
//     System.out.println($(byAttribute("data-row-key","1")));
     $(byAttribute("data-row-key","1")).shouldBe(Condition.visible);
     $(byAttribute("data-row-key","2")).shouldBe(Condition.visible);
//            Assert.fail("Содежимое журнала не отображается");

    }

}
