package sapasoft.adm.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import sapasoft.adm.testconfigs.BaseSetings;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Auth extends BaseSetings {



    @Step("Авторизация в системе")
    public Auth logIn(String login, String password) {
        closeWebDriver();
        open("/");
        $(By.xpath("//input[@id=\"username\"]")).setValue(login);
        $(By.xpath("//input[@class ='btn-login-page']")).click();
        // $(By.xpath("//button[@id=\"proceed-button\"]")).click();
        $(By.xpath("//input[@name=\"password\"]")).setValue(password);
        $(By.xpath("//input[@id=\"kc-login\"]")).click();
        // $(By.xpath("//button[@id=\"proceed-button\"]")).click();
        //refresh();
        $(By.xpath("//h1[text()=\"Главная\"]")).shouldBe(Condition.visible);
        $(By.xpath("//div[text()=\"Администрирование и мониторинг\"]")).click();
        $(By.xpath("//div/h1")).shouldHave(Condition.text("Администрирование и мониторинг"));
        return this;
    }

    @Step("Выход из системы")
    public Auth logOut() {
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldNotBe(Condition.visible);
        $(By.xpath("//a/span[text()=\"Выйти из профиля\"]")).click();
        $(By.xpath("//a[text()=\"Да\"]")).click();
        $(By.xpath("//p[@id=\"kc-page-title\"]")).shouldHave(Condition.text("        Выберите способ авторизации"));
        return this;
    }


    @Step("Открыть раздел регистрация")
    public Auth registration() {
        closeWebDriver();
        open("/");
        $(By.xpath("//footer/div[@class=\"kc-portal-back\"]/a")).click();

        return this;
    }



}
