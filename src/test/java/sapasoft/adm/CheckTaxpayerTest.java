package sapasoft.adm;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.junit4.DisplayName;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.testconfigs.BaseSetings;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Проверка возможности постановки на учет по НДС")
public class CheckTaxpayerTest extends BaseSetings {


    @Test
    @DisplayName("У налогоплательщика отсутствует регистрационный учет по месту нахождения в указанном органе государственных доходов")
    public void TestCheckTaxpayerCase1() throws UnirestException {

        String bodyJSON="{ \"iinBin\": \"484440016661\", \"ogdCode\": \"6205\", \"taxpayerType\": \"UL\", \"operationType\": \"REGISTRATION\" }";
        String expectedResponse="У налогоплательщика отсутствует регистрационный учет по месту нахождения в указанном органе государственных доходов";
        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedResponse);

    }

    @Test
    @DisplayName("Некорректно указана категория налогоплательщика")
    public void TestCheckTaxpayerCase2() throws UnirestException {

        String bodyJSON="{\n" +
                "    \"iinBin\": \"991040006025\",\n" +
                "    \"ogdCode\": \"6205\",\n" +
                "    \"taxpayerType\": \"UL\",\n" +
                "    \"operationType\": \"REGISTRATION\"\n" +
                "}";
        String expectedResponse="Некорректно указана категория налогоплательщика";
        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedResponse);

    }
}
