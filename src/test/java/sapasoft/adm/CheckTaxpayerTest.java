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
    public void  TestRegNds() throws UnirestException {

        JSONObject Response = new JSONObject(Test_api_post.CheckTaxpayer());
//        System.out.println(Jarr);
        Test_api_post.checkTaxpayerResponseCheck(Response,"У налогоплательщика отсутствует регистрационный учет по месту нахождения в указанном органе государственных доходов");
//
//        Adm adm =new Adm();
//        adm.logIn(login, password);
//        adm.ndsJournal().open();
//
//        adm.ndsJournal().chooseMessage("430216434014");
//        pause(5000);

    }
}
