package sapasoft.reg;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Step;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class Test_api_post {

    //    @Test
    @Step("Отправка post запроса /mgu/nds/save-nz")
    public static String ndsSaveNz(String bodyJSON) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("http://arm.sapasoft.kz/services/isnaregndsintegration/open-api/mgu/nds/save-nz")
                .header("Content-Type", "application/json")
                .header("Cookie", "XSRF-TOKEN=c8eb295d-e5f2-447a-8354-bc606d699055")
                .body(bodyJSON)
                .asString();

//        System.out.println(response.getStatus());
//       System.out.println(response.getBody());
        return response.getBody();
    }

    @Step("Отправка post запроса /mgu/nds/check-taxpayer")
    public static String CheckTaxpayer(String bodyJSON) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("http://arm.sapasoft.kz/services/isnaregndsintegration/open-api/mgu/nds/check-taxpayer")
                .header("content-type", "application/json")
                .header("cache-control", "no-cache")
                .header("postman-token", "0a1e90b4-f9b1-bf71-2685-1fbe1ac2064a")
                .body(bodyJSON)
                .asString();

        System.out.println(response.getStatus());
        if (response.getStatus() == 200 || response.getStatus() == 400) {
            return response.getBody();
        } else Assert.fail("Статус ответа: "+response.getStatus()+"\n"+"respons body: "+response.getBody());
//       System.out.println(response.getBody());
        return response.getBody();
    }


    @Step("Ожидаемый ответ: {1}")
    public static Boolean ndsSaveNzResponseCheck(JSONObject Response, String expectedRejectCause) throws UnirestException {
        Boolean Check = false;
        JSONObject result = new JSONObject(String.valueOf(Response.get("result")));
        System.out.println("result:::" +result);
        JSONArray errors = new JSONArray(String.valueOf(result.get("errors")));
        System.out.println("errors:::" +errors);
        String msgRu = String.valueOf(errors.getJSONObject(0).get("msgRu"));
        if (msgRu.equals(expectedRejectCause)) {
            Check = true;
        } else {Assert.fail("Ответ не соответствует ожидаемому");}
//        System.out.println(Check +"::::" +errorCode);

        return Check;
    }

    @Step("Ожидаемый ответ: {1}")
    public static Boolean checkTaxpayerResponseCheck(JSONObject Response, String expectedRejectCause) throws UnirestException {
        Boolean Check = false;
//        JSONObject result = new JSONObject(String.valueOf(Response.get("result")));
//        System.out.println("result:::" +result);
        JSONArray messages = new JSONArray(String.valueOf(Response.get("messages")));
        System.out.println("messages:::" + messages);
        String rejectCause = String.valueOf(messages.getJSONObject(0).get("rejectCause"));
        System.out.println("rejectCause:::" + rejectCause);
        System.out.println("expectedRejectCause:::" + expectedRejectCause);
        if (rejectCause.equals(expectedRejectCause)) {
            Check = true;
        } else {
            Assert.fail("Ответ не соответствует ожидаемому");
        }
        System.out.println(Check + "::::" + rejectCause);

        return Check;
    }


}