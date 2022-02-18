package sapasoft.reg;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.junit4.DisplayName;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import sapasoft.reg.pages.Adm;
import sapasoft.reg.testconfigs.BaseSetings;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("НЗ о регистрационном учете по НДС")

public class RegNdsTest extends BaseSetings {

    @Test

    public void  CellTest() throws UnirestException, IOException {
int Cell=0;
        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" + java.util.UUID.randomUUID() + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"430216434014\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"IP Власова ru\",\r\n                \"kk\": \"IP Власова kk\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
//        Test_api_post.ndsSaveNzResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Adm adm =new Adm();

        adm.ndsJournal().checkCertificate("Выдано свидетельство","430216434014");



        for (int i = 0; i < $(By.className("ant-modal-body")).$(By.className("ant-table-thead")).$$(By.className("ant-table-cell")).size(); i++) {
            if (($(By.className("ant-modal-body")).$(By.className("ant-table-thead")).$$(By.className("ant-table-cell")).get(i).getText()).equals("Событие")) {
                System.out.println("порядковый номер: "+i);
                Cell=i;
            }
        }
        System.out.println ($(By.className("ant-modal-body")).$("[class*=ant-table-row-level-0]").$$(By.className("ant-table-cell")).get(Cell).getText());



        screenshot("123");
        screenshot1("Скрин последней страницы");

        pause(1000);
    }

    @Test
    @DisplayName("Успешная постановка на учет НДС. Позитивный тест кейс. ")
    public void  TestRegNdsCase() throws UnirestException, IOException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" + java.util.UUID.randomUUID() + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"430216434014\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"IP Власова ru\",\r\n                \"kk\": \"IP Власова kk\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
//        Test_api_post.ndsSaveNzResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Adm adm =new Adm();

        adm.ndsJournal().checkCertificate("Выдано свидетельство","430216434014");

        screenshot("123");
        screenshot1("Скрин последней страницы");

        pause(1000);
    }

    @Test
    @DisplayName("Налогоплательщик является действующим плательщиком НДС")
    public void  TestRegNdsCase1() throws UnirestException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" + java.util.UUID.randomUUID() + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"430216434014\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"IP Власова ru\",\r\n                \"kk\": \"IP Власова kk\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
        Test_api_post.ndsSaveNzResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Adm adm =new Adm();
        adm.ndsJournal().checkMessage("Налогоплательщик является действующим плательщиком НДС","430216434014");
        pause(1000);
    }

    @Test
    @DisplayName("Не найден налогоплательщик")
    public void  TestRegNdsCase2() throws UnirestException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" +
                java.util.UUID.randomUUID()
                + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"880218458813\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"ИП Жубатова\",\r\n                \"kk\": \"Жубатова ЖК\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
        String expectedRejectCause="Не найден налогоплательщик";

        Test_api_post.ndsSaveNzResponseCheck(Response,expectedRejectCause);

        Adm adm =new Adm();
        adm.ndsJournal().checkMessage(expectedRejectCause, "880218458813");
        pause(1000);
    }

    @Test
    @DisplayName("Налогоплательщик не входит в категорию налогоплательщиков, подлежащих постановке на регистрационный учет по НДС")
    public void  TestRegNdsCase3() throws UnirestException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" +
                java.util.UUID.randomUUID()
                + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"140950029062\",\r\n            \"taxpayerType\": \"UL\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"ИП Жубатова\",\r\n                \"kk\": \"Жубатова ЖК\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
        String expectedRejectCause="Налогоплательщик не входит в категорию налогоплательщиков, подлежащих постановке на регистрационный учет по НДС";

        Test_api_post.ndsSaveNzResponseCheck(Response,expectedRejectCause);

        Adm adm =new Adm();
        adm.ndsJournal().checkMessage(expectedRejectCause, "140950029062");
        pause(1000);
    }

    @Test
    @DisplayName("Сообщение не может быть обработано, так как налогоплательщик с кодом 930122450268 отсутствует в системе.")
    public void  TestRegNdsCase4() throws UnirestException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" +
                java.util.UUID.randomUUID()
                + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"930122450268\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"ИП Жубатова\",\r\n                \"kk\": \"Жубатова ЖК\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
        String expectedRejectCause="Сообщение не может быть обработано, так как налогоплательщик с кодом 930122450268 отсутствует в системе.";

        Test_api_post.ndsSaveNzResponseCheck(Response,expectedRejectCause);

        Adm adm =new Adm();
        adm.ndsJournal().checkMessage(expectedRejectCause, "930122450268");
        pause(1000);
    }

    @Test
    @DisplayName("Пример ошибки")
    public void  TestRegNdsCase5() throws UnirestException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" +
                java.util.UUID.randomUUID()
                + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"930122450268\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"ИП Жубатова\",\r\n                \"kk\": \"Жубатова ЖК\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
        String expectedRejectCause="Сообщение не может быть обработано, так как налогоплательщик с кодом 930122450268 отсутствует в системе.";

        Test_api_post.ndsSaveNzResponseCheck(Response,expectedRejectCause);

        Adm adm =new Adm();
        adm.ndsJournal().checkMessage(expectedRejectCause, "9301224502268");
        pause(1000);
    }
}
