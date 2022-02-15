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
    @DisplayName("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является умершим (объявленным умершим)")
    public void  TestRegNds() throws UnirestException {


        JSONObject Jarr = new JSONObject(Test_api_post.isnaregndsintegration());
        System.out.println(Jarr);
        Test_api_post.isnaregndsintegrationResponseCheсk(Jarr,"Сообщение с указанным идентификатором");

        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.ndsJournal().open();

        adm.ndsJournal().chooseMessage("430216434014");
        pause(5000);

    }

}
