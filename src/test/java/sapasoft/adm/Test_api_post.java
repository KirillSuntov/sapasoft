package sapasoft.adm;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Step;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import java.io.IOException;

public class Test_api_post
{

//    @Test
    @Step("Отправка post запроса /mgu/nds/save-nz")
    public static String isnaregndsintegration() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("http://arm.sapasoft.kz/services/isnaregndsintegration/open-api/mgu/nds/save-nz")
                .header("Content-Type", "application/json")
                .header("Cookie", "XSRF-TOKEN=c8eb295d-e5f2-447a-8354-bc606d699055")
                .body("{\r\n    \"headers\": {\r\n        \"messageUid\": \"7b79f755-4717-4e0e-b864-acc9b1c86186\",\r\n        \"messageCreatedDate\": \"2022-01-01 09:34:55\",\r\n        \"operationType\": \"REGISTRATION\"\r\n    },\r\n    \"businessData\": {\r\n        \"taxStatement\": {\r\n            \"registrationType\": 1,\r\n            \"type\": \"1\",\r\n            \"taxOrgCode\": \"6205\",\r\n            \"ndsNzReceiveDate\": \"2022-12-22\",\r\n            \"ndsNzIncomingDate\": \"2022-12-22\",\r\n            \"statementRegReason\": \"REQUIRED\"\r\n        },\r\n        \"taxpayerData\": {\r\n            \"taxpayerCode\": \"430216434014\",\r\n            \"taxpayerType\": \"IP\",\r\n            \"taxpayerName\": {\r\n                \"ru\": \"IP Власова ru\",\r\n                \"kk\": \"IP Власова kk\"\r\n            }\r\n        },\r\n        \"stateAuthorityMark\": {\r\n            \"registrationDate\": \"2020-10-19 19:34:55\",\r\n            \"taxOrgCode\": 6205,\r\n            \"applicationDate\": \"2020-10-19 19:34:55\",\r\n            \"fullName\": \"Иванов П.А.\",\r\n            \"applicantFullName\": \"Кузнецов В.А.\",\r\n            \"applicationNumber\": 10\r\n        }\r\n    }\r\n}")
                .asString();

//        System.out.println(response.getStatus());
//       System.out.println(response.getBody());
       return response.getBody();
    }

    @Step("Проверка ответа, ожидаемый ответ:[1]")
    public static Boolean isnaregndsintegrationResponseCheсk(JSONObject Response, String expectedResponse) throws UnirestException {
        Boolean Check=false;

        JSONObject result = new JSONObject(String.valueOf(Response.get("result")));
        System.out.println("result:::" +result);

        JSONArray errors = new JSONArray(String.valueOf(result.get("errors")));

        System.out.println("errors:::" +errors);
        String errorCode = String.valueOf(errors.getJSONObject(0).get("errorCode"));
        if (errorCode.equals("id.already.processed")) {Check=true;}
        System.out.println(Check +"::::" +errorCode);

        return Check;
    }


}