package sapasoft.adm;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.junit4.DisplayName;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("НЗ о регистрационном учете по НДС")

public class IsnaRegNdsIntegrationTest extends BaseSetings {

    @Test
    @DisplayName("Налогоплательщик является действующим плательщиком НДС")
    public void  TestRegNdsCase() throws UnirestException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" + java.util.UUID.randomUUID() + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"430216434014\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"IP Власова ru\",\r\n                \"kk\": \"IP Власова kk\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
        Test_api_post.ndsSaveNzResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Adm adm =new Adm();
        adm.ndsJournal().checkMessage("Налогоплательщик является действующим плательщиком НДС");
        pause(1000);
    }

    @Test
    @DisplayName("Не найден налогоплательщик")
    public void  TestRegNdsCase1() throws UnirestException {

        String bodyJSON="{\r\n    \"headers\": {\r\n        \"messageUid\": \"" +
                java.util.UUID.randomUUID()
                + "\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"880218458813\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"ИП Жубатова\",\r\n                \"kk\": \"Жубатова ЖК\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}";
        JSONObject Response = new JSONObject(Test_api_post.ndsSaveNz(bodyJSON));
        String expectedRejectCause="Не найден налогоплательщик";

        Test_api_post.ndsSaveNzResponseCheck(Response,expectedRejectCause);

        Adm adm =new Adm();
        adm.ndsJournal().checkMessage(expectedRejectCause);
        pause(1000);
    }


}
