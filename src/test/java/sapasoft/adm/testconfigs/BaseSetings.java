package sapasoft.adm.testconfigs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;


public class BaseSetings {
    protected String login= "admin";
    protected String password= "I$NA43mp";

    public static final Boolean CLEAR_REPORTS_DIR = false;

    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }


    static {

        Configuration.browser = "chrome"; //firefox, edge,opera, ie
        Configuration.baseUrl = "https://arm.sapasoft.kz";
        Configuration.timeout= 8000;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = false;


        if (CLEAR_REPORTS_DIR) {
            File allureScreenShots = new File("build/reports/tests");
            for (File item : Objects.requireNonNull(allureScreenShots.listFiles()))
                item.delete();
        }
    }


    /*Генерация случайной строки русских букв*/
    protected static Random sRandom = new Random();
    protected static char[] sAlphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя".toCharArray();

    protected static int sLength = sAlphabet.length;

    protected static char getRandomChar() {
        return sAlphabet[sRandom.nextInt(sLength)];
    }

    protected static String str() {
        String str = "";
        for (int i=0; i<5; i++) {
            str= str + getRandomChar();
        }
        return str;
    }

    protected static String date(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    protected static String date1(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

}