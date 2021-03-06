package sapasoft.reg.nds;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.junit4.DisplayName;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.reg.testconfigs.BaseSetings;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Проверка возможности постановки на учет по НДС")
public class CheckTaxpayerTest extends BaseSetings {

    @Test
    @DisplayName("Позитивный тест кейс")
    public void TestCheckTaxpayerCase() throws UnirestException {

        String bodyJSON="{\"iinBin\":\"771040008703\",\n" +
                "\"ogdCode\":\"6205\",\n" +
                "\"taxpayerType\":\"UL\",\n" +
                "\"operationType\":\"REGISTRATION\"}";
        String expectedRejectCause="null";
        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);

    }

    @Test
    @DisplayName("У налогоплательщика отсутствует регистрационный учет по месту нахождения в указанном органе государственных доходов")
    public void TestCheckTaxpayerCase1() throws UnirestException {

        String bodyJSON="{ \"iinBin\": \"484440016661\", \"ogdCode\": \"6205\", \"taxpayerType\": \"UL\", \"operationType\": \"REGISTRATION\" }";
        String expectedRejectCause="У налогоплательщика отсутствует регистрационный учет по месту нахождения в указанном органе государственных доходов";
        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);

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
        String expectedRejectCause="Некорректно указана категория налогоплательщика";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }

    @Test
    @DisplayName("Налогоплательщик не найден")
    public void TestCheckTaxpayerCase3() throws UnirestException {

        String bodyJSON="{\n" +
                "    \"iinBin\": \"030824568823\",\n" +
                "    \"ogdCode\": \"3020\",\n" +
                "    \"taxpayerType\": \"IP\",\n" +
                "    \"operationType\": \"REGISTRATION\"\n" +
                "}";
        String expectedRejectCause="Налогоплательщик не найден";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }

    @Test
    @DisplayName("Налогоплательщику присвоена высокая степень риска")
    public void TestCheckTaxpayerCase4() throws UnirestException {

        String bodyJSON="{ \"iinBin\": \"484440016661\", \"ogdCode\": \"6203\", \"taxpayerType\": \"UL\", \"operationType\": \"REGISTRATION\" }";
        String expectedRejectCause="Налогоплательщику присвоена высокая степень риска";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }

    @Test
    @DisplayName("Налогоплательщик входит в категорию налогоплательщиков, подлежащих обязательной постановке на регистрационный учет по НДС")
    public void TestCheckTaxpayerCase5() throws UnirestException {

        String bodyJSON="{\"iinBin\":\"110640018230\",\n" +
                "\"ogdCode\":\"6203\",\n" +
                "\"taxpayerType\":\"UL\",\n" +
                "\"operationType\":\"REGISTRATION\"}";
        String expectedRejectCause="Налогоплательщик входит в категорию налогоплательщиков, подлежащих обязательной постановке на регистрационный учет по НДС";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }

    @Test
    @DisplayName("Тип операции не соответствует формату")
    public void TestCheckTaxpayerCase6() throws UnirestException {

        String bodyJSON="{\n" +
                "    \"iinBin\": \"038152444068\",\n" +
                "    \"ogdCode\": \"6205\",\n" +
                "    \"taxpayerType\": \"IP\",\n" +
                "    \"operationType\": \"TEST\"\n" +
                "}";
        String expectedRejectCause="Тип операции не соответствует формату";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }

    @Test
    @DisplayName("Категория налогоплательщика не соответствует формату")
    public void TestCheckTaxpayerCase7() throws UnirestException {

        String bodyJSON="{\"iinBin\":\"771040008703\",\n" +
                "\"ogdCode\":\"6205\",\n" +
                "\"taxpayerType\":\"TEst\",\n" +
                "\"operationType\":\"REGISTRATION\"}";
        String expectedRejectCause="Категория налогоплательщика не соответствует формату";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }

    @Test
    @DisplayName("Сообщение не может быть обработано, так как обязательное поле iinBin не заполнено")
    public void TestCheckTaxpayerCase8() throws UnirestException {

        String bodyJSON="{\"iinBin\":\"\",\n" +
                "\"ogdCode\":\"6205\",\n" +
                "\"taxpayerType\":\"UL\",\n" +
                "\"operationType\":\"REGISTRATION\"}";
        String expectedRejectCause="Сообщение не может быть обработано, так как поле iinBin не соответствует формату";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }

    @Test
    @DisplayName("Сообщение не может быть обработано, так как обязательное поле ogdCode не заполнено")
    public void TestCheckTaxpayerCase9() throws UnirestException {

        String bodyJSON="{ \"iinBin\": \"500101300101\", \"ogdCode\": \"\", \"taxpayerType\": \"IP\", \"operationType\": \"REGISTRATION\" }";
        String expectedRejectCause="Сообщение не может быть обработано, так как поле ogdCode не соответствует формату";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }

    @Test
    @DisplayName("Сообщение не может быть обработано, так как обязательное поле taxpayerType не заполнено")
    public void TestCheckTaxpayerCase10() throws UnirestException {

        String bodyJSON="{ \"iinBin\": \"500101300101\", \"ogdCode\": \"6203\", \"taxpayerType\": \"\", \"operationType\": \"REGISTRATION\" }";
        String expectedRejectCause="Сообщение не может быть обработано, так как обязательное поле taxpayerType не заполнено";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }


    @Test
    @DisplayName("Тип операции не соответствует формату")
    public void TestCheckTaxpayerCase11() throws UnirestException {

        String bodyJSON="{ \"iinBin\": \"500101300101\", \"ogdCode\": \"6203\", \"taxpayerType\": \"IP\", \"operationType\": \"\" }";
        String expectedRejectCause="Тип операции не соответствует формату";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }

    @Test
    @DisplayName("Налогоплательщик не является действующим плательщиком НДС")
    public void TestCheckTaxpayerCase12() throws UnirestException {

        String bodyJSON="{ \"iinBin\": \"500101300101\", \"ogdCode\": \"6203\", \"taxpayerType\": \"IP\", \"operationType\": \"REGISTRATION\" }";
        String expectedRejectCause="Налогоплательщик не является действующим плательщиком НДС";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }

    @Test
    @DisplayName("Налогоплательщик является действующим плательщиком НДС")
    public void TestCheckTaxpayerCase13() throws UnirestException {

        String bodyJSON="{\"iinBin\":\"810202450159\",\"ogdCode\":\"6205\",\"taxpayerType\":\"IP\",\"operationType\":\"REGISTRATION\"}";
        String expectedRejectCause="Налогоплательщик является действующим плательщиком НДС";

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer(bodyJSON));
        Test_api_post.checkTaxpayerResponseCheck(Response,expectedRejectCause);
    }
}
