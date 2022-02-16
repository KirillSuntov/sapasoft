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
@DisplayName("Автоматическое формирование решения ОГД")

public class IsnaRegNdsIntegrationTest extends BaseSetings {

    @Test
    @DisplayName("Налогоплательщик является действующим плательщиком НДС")
    public void  TestRegNds() throws UnirestException {

        JSONObject Response = new JSONObject(Test_api_post.saveNz());
//        System.out.println(Jarr);
        Test_api_post.isnaregndsintegrationResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.ndsJournal().open();

        adm.ndsJournal().chooseMessage("430216434014");
        adm.ndsJournal().checkMessage("Налогоплательщик является действующим плательщиком НДС");
        pause(5000);

    }

}
