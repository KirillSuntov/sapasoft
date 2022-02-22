package sapasoft.reg.nds;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.junit4.DisplayName;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.reg.pages.Adm;
import sapasoft.reg.testconfigs.BaseSetings;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.screenshot;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Решение ОГД о принудительном снятии с НДС")

public class RegNdsForcedTest extends BaseSetings {

    @Test
    @DisplayName("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является умершим (объявленным умершим)")
    public void  TestRegNdsForcedCase() throws UnirestException, IOException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" + java.util.UUID.randomUUID() + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"430216434014\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"IP Власова ru\",\r\n                \"kk\": \"IP Власова kk\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
//        Test_api_post.ndsSaveNzResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Adm adm =new Adm();
        adm.ndsJournal().checkCertificate("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является умершим (объявленным умершим)","501213300061");

        screenshot("123");
        screenshot1("Скрин последней страницы");
        pause(1000);
    }

    @Test
    @DisplayName("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является ФЛ, имеющим непогашенную или неснятую судимость по статьям 192-1, 216, 217 и 222 УК РК от 16.07.97 года")
    public void  TestRegNdsForcedCase1() throws UnirestException, IOException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" + java.util.UUID.randomUUID() + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"445065308053\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"IP Власова ru\",\r\n                \"kk\": \"IP Власова kk\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
//        Test_api_post.ndsSaveNzResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Adm adm =new Adm();
        adm.ndsJournal().checkCertificate("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является ФЛ, имеющим непогашенную или неснятую судимость по статьям 192-1, 216, 217 и 222 УК РК от 16.07.97 года","445065308053");

        screenshot("123");
        screenshot1("Скрин последней страницы");
        pause(1000);
    }

    @Test
    @DisplayName("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является недееспособным или ограничено недееспособным или безвестно отсутствующим ФЛ")
    public void  TestRegNdsForcedCase2() throws UnirestException, IOException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" + java.util.UUID.randomUUID() + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"550814435487\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"IP Власова ru\",\r\n                \"kk\": \"IP Власова kk\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
//        Test_api_post.ndsSaveNzResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Adm adm =new Adm();
        adm.ndsJournal().checkCertificate("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является недееспособным или ограничено недееспособным или безвестно отсутствующим ФЛ","550814435487");

        screenshot("123");
        screenshot1("Скрин последней страницы");
        pause(1000);
    }

    @Test
    @DisplayName("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является ФЛ, находящимся в розыске")
    public void  TestRegNdsForcedCase3() throws UnirestException, IOException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" + java.util.UUID.randomUUID() + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"159240017082\",\r\n            \"taxpayerType\": \"UL\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"IP Власова ru\",\r\n                \"kk\": \"IP Власова kk\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
//        Test_api_post.ndsSaveNzResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Adm adm =new Adm();
        adm.ndsJournal().checkCertificate("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является ФЛ, находящимся в розыске","159240017082");

        screenshot("123");
        screenshot1("Скрин последней страницы");
        pause(1000);
    }

    @Test
    @DisplayName("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является бездействующим ИП или ЮЛ")
    public void  TestRegNdsForcedCase4() throws UnirestException, IOException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" + java.util.UUID.randomUUID() + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"190540017940\",\r\n            \"taxpayerType\": \"UL\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"IP Власова ru\",\r\n                \"kk\": \"IP Власова kk\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
//        Test_api_post.ndsSaveNzResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Adm adm =new Adm();
        adm.ndsJournal().checkCertificate("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является бездействующим ИП или ЮЛ","190540017940");

        screenshot("123");
        screenshot1("Скрин последней страницы");
        pause(1000);
    }

//    @Test
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

}
