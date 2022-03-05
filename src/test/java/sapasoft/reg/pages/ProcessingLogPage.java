package sapasoft.reg.pages;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import sapasoft.reg.nds.Test_api_post;
import sapasoft.reg.testconfigs.BaseSetings;

import java.awt.*;
import java.io.IOException;

import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class ProcessingLogPage extends BaseSetings {

    public static String Msg_Status;
    public static String Msg_Type;
    public static String Msg_Source;
    public static String Operation_Type;
    public static String Msg_Id;

    @Step("Открыть раздел Журнал обработки сообщений")
    public void open() {

        $("[href*=processing-log]").click();
//        $(byText("Журнал НДС")).click();

    }

    @Step("Ввести ИИН или БИН : {0}")
    public void insertBinIin(String bin) {



    }

    @Step("Открыть расширенный поиск")
    public void advancedSearch() {
        $("[class*=advancedSearch]").click();
        pause(1000);
//        $(by("data-row-key", "1")).click();
    }

    @Step("Расширенный поиск выбор НП")
    public void advancedSearch_Choose_NP(String np) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("//*[@id=\"searchByParameters\"]/div[2]/div/div/div/div/form/div[1]/div[1]/div/div[2]")).click();
        //$(byId("personType")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(0).$(byText(np)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Статус сообщения: {0}")
    public void advancedSearch_Choose_Status(String status) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        //$(byXpath("//*[@id=\"searchByParameters\"]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div[2]/div/div/div/div/div")).click();
        $(byId("messageStatus")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(1).$(byText(status)).click();
        this.Msg_Status = status;
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Вид сообщения")
    public void advancedSearch_Choose_MsgType(String type) {
        this.Msg_Type = type;
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        $(byXpath("//*[@id=\"searchByParameters\"]/div[2]/div/div/div/div/form/div[2]/div[1]/div/div[2]/div/div/div/div")).click();
        //$(byId("messageMode")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(2).$(byText(type)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Источник сообщения")
    public void advancedSearch_Choose_MsgSource(String source) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        //$(byXpath("/html/body/div[1]/div/section/section/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[2]/div/div[2]/div/div/div/div")).click();
        this.Msg_Source = source;
        $(byId("exchangeSystems")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(3).$(byText(source)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Тип операции")
    public void advancedSearch_Choose_OperationType(String type) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
        //$(byXpath("/html/body/div[1]/div/section/section/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[3]/div/div[2]/div/div/div/div")).click();
        this.Operation_Type = type;
        $(byId("operationType")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(4).$(byText(type)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск выбор Код типа сообщения")
    public void advancedSearch_Choose_CodeTypeMsg(String type) {
        //$(byClassName("ant-select antd-pro-components-select-select-select ant-select-single ant-select-show-arrow")).click();
       //$(byXpath("/html/body/div[1]/div/section/section/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[4]/div/div[2]/div/div/div/div")).click();
        $(byId("messageType")).click();
        $$(byClassName("rc-virtual-list-holder-inner")).get(5).$(byText(type)).click();
        //pause(3000);
    }

    @Step("Расширенный поиск Применить")
    public void advancedSearch_Apply() {
        $(byText("Применить")).click();
        pause(3000);
    }

    @Step("Проверка статуса сообщения с поисковым статусом")
    public void Check_Equality_Of_Status_To_Search() throws IOException {
       /*System.out.println("CHECK START: ");
        System.out.println("II: " + $(byClassName("ant-table-tbody")).$$(byClassName("ant-table-row")).get(1));
        System.out.println("III: " + $(byClassName("ant-table-tbody")).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")));
        System.out.println("IIII: " + $$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")));
        System.out.println("IIIII: " + $$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6));
        for(int i = 0; i < $$(byClassName("ant-table-tbody")).size(); i++){
            System.out.println("MSG_Status: " + this.Msg_Status);
            System.out.println("STATUS: " + $$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6).getText());
            $$(byClassName("ant-table-tbody")).get(i).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).equals(Msg_Status);
            System.out.println("I = " + i + " : " + $$(byClassName("ant-table-tbody")).get(i).$(byClassName("ant-table-row ant-table-row-level-0")));

        }*/
        if(!$$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6).getText().equals(this.Msg_Status)){
            screenshot("Status");
            screenshot1("Скрин");
            Assert.fail("Значение статуса не соответствует выброному в расширенном поиске");
        }
    }

    @Step("Проверка вида сообщения с поисковым видом")
    public void Check_Equality_Of_MsgType_To_Search() throws IOException {
        if(this.Msg_Type == "Исходящее"){
            if(!$$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6).getText().equals("Отправлено")){
                screenshot("Msg_Type1");
                screenshot1("Скрин");
                Assert.fail("Значение Вид сообщения не соответствует выброному в расширенном поиске");
            }
        }
        else{
            if($$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(6).getText().equals("Отправлено")){
                screenshot("Msg_Type2");
                screenshot1("Скрин");
                Assert.fail("Значение Вид сообщения не соответствует выброному в расширенном поиске");

            }
        }
    }

    @Step("Проверка источника сообщения с поисковым источником")
    public void Check_Equality_Of_MsgSource_To_Search() throws IOException {
        if(!$$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(8).getText().equals(this.Msg_Source)){
            screenshot("Msg_Source");
            screenshot1("Скрин");
            Assert.fail("Значение Источника сообщения не соответствует выброному в расширенном поиске");

        }
    }

    @Step("Проверка Типа операции сообщения с поисковым типом")
    public void Check_Equality_Of_OperationType_To_Search() throws IOException {
        //System.out.println($$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(3).getText());
        //System.out.println(this.Operation_Type);
        if(!$$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(3).getText().equals(this.Operation_Type)){
            screenshot("Operation_Type");
            screenshot1("Скрин");
            Assert.fail("Значение Тип операции не соответствует выброному в расширенном поиске");

        }
    }

    @Step("Проверка Типа операции сообщения с поисковым типом")
    public void Check_Equality_Of_OperationType_To_Search_ByLoop() throws IOException {

        for(int i = 0; i < $$(byClassName("ant-table-thead")).get(0).$$(byClassName("ant-table-cell")).size(); i++){

            if($$(byClassName("ant-table-thead")).get(0).$$(byClassName("ant-table-cell")).get(i).getText().equals("Тип операции")){

                if(!$$(byClassName("ant-table-tbody")).get(0).$(byClassName("ant-table-row")).$$(byClassName("ant-table-cell")).get(i).getText().equals(this.Operation_Type)){
                    screenshot("Operation_Type");
                    screenshot1("Скрин");
                    Assert.fail("Значение Тип операции не соответствует выброному в расширенном поиске");
                }

                else{
                    break;
                }
            }
        }

    }

    @Step("Выбор Мокапа")
    public void Choose_Mockup(int index) throws IOException {
        //$(byClassName("ant-table-tbody")).$$(byClassName("ant-table-row-level-0")).get(index).click();
        $(byClassName("ant-table-tbody")).$(byAttribute("data-row-key", String.valueOf(index))).click();
        pause(6000);
    }

    @Step("Проверка Значения строки {1}")
    public void Check_Value(String chapter, String field, String checkwith) throws IOException {
        //System.out.println($$(byClassName("antd-pro-components-collapse-index-ovdCollapse")));
        $(byText(chapter)).click();
        //System.out.println($(byText(field)).closest("div").closest("div").shouldHave(text("Регистрация")));
        $(byText(field)).closest("div").closest("div").shouldHave(text(checkwith));
        pause(6000);
    }

   /* @Test
    @DisplayName("Регистрация ЮЛ")
    public void  TestRegUL() throws UnirestException, IOException {

        String bodyJSON="<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q1=\"http://regjul.inis.gbdul.tamur.kz\" >\r\n    <soap:Header/>\r\n    <soap:Body>\r\n        <q1:Request >\r\n            <Header>\r\n                <message_type>BJ_REG_JUL</message_type>\r\n                <message_type_name>INIS_RegJul</message_type_name>\r\n                <id_message>bf16d838-7179-4db7-9c23-bcea9b1ef474</id_message>\r\n                <id_producer>475e701f-734c-460d-bd5f-ff2a1e21fb10</id_producer>\r\n                <date_time_message>2011-06-28T10:30:55.936</date_time_message>\r\n                <sender>RS_VS</sender>\r\n                <destination>NK_VS</destination>\r\n                <users_login>sys_admin</users_login>\r\n                <message_format_version>2.0</message_format_version>\r\n                <urgency>0</urgency>\r\n                <note>0</note>\r\n                <UUID>60436032.137522479</UUID>\r\n                <MessageVersion>1</MessageVersion>\r\n            </Header>\r\n            <businessData>\r\n                <RKRegAgencyInfo>\r\n                    <RegistrationPointCode>1930-01</RegistrationPointCode>\r\n                    <FullAgencyNameRu>Управление юстиции города Караганды Департамента юстиции Карагандинской области</FullAgencyNameRu>\r\n                    <FullAgencyNameKz>Қарағанды облысы Әділет департаментінің Қарағанды қаласының Әділет басқармасы</FullAgencyNameKz>\r\n                </RKRegAgencyInfo>\r\n                <RegistrationData>\r\n                    <RegistrationType>1</RegistrationType>\r\n                    <BIN>{{new_iin}}</BIN>\r\n                    <Applicant>Титов Г.А.</Applicant>\r\n                    <ZayavDate>2011-06-23+06:00</ZayavDate>\r\n                    <isZayvPEP>true</isZayvPEP>\r\n                    <isNDS>false</isNDS>\r\n                    <RegistrationCode>1</RegistrationCode>\r\n                    <CreationMethod>0</CreationMethod> <!-- Данное поле по постановке должно быть 1 либо 2 но вместо это здесь 0 или 1 -->\r\n                    <OrganizationForm>1</OrganizationForm>\r\n                    <OPF>20</OPF>\r\n                    <FullOfficialName>\r\n                        <ru>Товарищество с ограниченной ответственностью \"Тест123\"</ru>\r\n                        <kk>\"Тес123\" жауапкершілігі шектеулі серіктестігі</kk>\r\n                    </FullOfficialName>\r\n\t\t\t\t\t<ShortOfficialName>\r\n                        <ru>ТОО \"Тест123\"</ru>\r\n                        <kk>\"Тест123\" ЖКС</kk>\r\n                    </ShortOfficialName>\r\n                    <MJIssueDate>2011-06-24+06:00</MJIssueDate>\r\n                    <MJPrikazNumber>3-8/581-01</MJPrikazNumber>\r\n                    <PropertyType>2</PropertyType>\r\n                    <isModelCharter>true</isModelCharter>\r\n                    <isCommercial>false</isCommercial>\r\n                    <isPrivateBusinessman>true</isPrivateBusinessman>\r\n\t\t\t\t\t<StatusOO>1</StatusOO>\r\n\t\t\t\t\t<GPType>1</GPType>\r\n\t\t\t\t\t<FondType>2</FondType>\r\n                    <PrivateBusinessmanType>3</PrivateBusinessmanType>\r\n                    <HasForeignShare>false</HasForeignShare>\r\n                    <isInternational>false</isInternational>\r\n                    <isBranchOrganization>false</isBranchOrganization>\r\n                    <LocationAddress>\r\n                        <RKA>0201800073468623</RKA>\r\n                        <Postal>Z05T3B8</Postal>\r\n                        <KATOCode>711210000</KATOCode>\r\n                        <StreetType>11</StreetType>\r\n                        <StreetCodeAR>0004000000087817</StreetCodeAR>\r\n                        <StreetCode>012144</StreetCode>\r\n                        <Street>38</Street>\r\n                        <StreetTypeAdd>322</StreetTypeAdd>\r\n                        <StreetCodeAdd>174266</StreetCodeAdd>\r\n                        <StreetAdd>38</StreetAdd>\r\n                        <Building>34</Building>\r\n\t\t\t\t\t\t<Block>1</Block>\r\n\t\t\t\t\t\t<Korpus>2</Korpus>\r\n\t\t\t\t\t\t<Appartment>34</Appartment>\r\n\t\t\t\t\t\t<OffisNumber>41</OffisNumber>\r\n\t\t\t\t\t\t<KabinetNumber>322</KabinetNumber>\r\n                        <Phone>+7(748)171-34-09</Phone>\r\n\t\t\t\t\t\t<Fax>123456789123</Fax>\r\n                        <Email>something@gmail.com</Email>\r\n                    </LocationAddress>\r\n                    <Director>\r\n                        <IIN>707383543054</IIN>\r\n                        <Citizenship>1</Citizenship>\r\n                        <CountryCode>398</CountryCode>\r\n                        <Lastname>Титов</Lastname>\r\n                        <Firstname>Гаянэ</Firstname>\r\n                        <Midname>Авдеевич</Midname>\r\n\t\t\t\t\t\t<Phone>87776665544</Phone>\r\n                        <Fax>321987654321</Fax>\r\n                        <Email>somesome@gmail.com</Email>\r\n                    </Director>\r\n                    <EconomicActivities>\r\n                        <EconomicActivity>\r\n                            <Code>46909</Code>\r\n                            <isMain>true</isMain>\r\n                            <Percent>100.0</Percent>\r\n                        </EconomicActivity>\r\n                    </EconomicActivities>\r\n                    <ExpectedLaborAmmount>1</ExpectedLaborAmmount>\r\n                    <CapitalShareList>\r\n                        <CapitalValue>150.0</CapitalValue>\r\n                        <State>\r\n                            <Tenge>0.00000</Tenge>\r\n                            <Percent>0.0</Percent>\r\n                        </State>\r\n                        <Private>\r\n                            <Tenge>150.0</Tenge>\r\n                            <Percent>100.0</Percent>\r\n                        </Private>\r\n                    </CapitalShareList>\r\n                    <FoundersCount>4</FoundersCount>\r\n                    <RegistryHolder>4</RegistryHolder>\r\n                    <FoundersList>\r\n                        <PrivateFounders>\r\n                            <PrivateFounder>\r\n                                <IsResident>true</IsResident>\r\n                                <CountryCode>398</CountryCode>\r\n                                <IIN>707383543054</IIN>\r\n                                <Lastname>СОРОКИН</Lastname>\r\n                                <Firstname>ИВАН</Firstname>\r\n                                <Midname>МАРТЫНОВИЧ</Midname>\r\n                                <SharePercent>100.00000</SharePercent>\r\n                                <InvestmentValue>150.0</InvestmentValue>\r\n                            </PrivateFounder>\r\n                            <PrivateFounder>\r\n                                <IsResident>false</IsResident>\r\n                                <CountryCode>036</CountryCode>\r\n                                <IIN>707383543054</IIN>\r\n                                <Lastname>Петров</Lastname>\r\n                                <Firstname>ИВАН</Firstname>\r\n                                <Midname>Иванович</Midname>\r\n                                <NorezPerson>\r\n                                    <ForeignRNN>850107451534</ForeignRNN>\r\n                                    <IdentityDocument>\r\n                                        <CategoryCode>015</CategoryCode>\r\n                                        <Number>N123456</Number>\r\n                                        <IssueDate>2006-11-13+06:00</IssueDate>\r\n                                        <IssueAgency>003</IssueAgency>\r\n                                    </IdentityDocument>\r\n                                </NorezPerson>\r\n                                <SharePercent>100.00000</SharePercent>\r\n                                <InvestmentValue>150.0</InvestmentValue>\r\n                            </PrivateFounder>\r\n                        </PrivateFounders>\r\n\t\t\t\t\t\t<JuridicalFounders>\r\n                            <JuridicalFounder>\r\n                                <IsResident>true</IsResident>\r\n                                <CountryCode>398</CountryCode>\r\n                                <BIN>202100990015</BIN>\r\n                                <!--This field wasnt here before-->\r\n                                <SharePercent>80.00000</SharePercent>\r\n                                <InvestmentValue>400.00000</InvestmentValue>\r\n                            </JuridicalFounder>\r\n                            <JuridicalFounder>\r\n                                <IsResident>false</IsResident>\r\n                                <CountryCode>036</CountryCode>\r\n                                <BIN>210140012306</BIN>\r\n                                <NorezCompany>\r\n                                    <Name>EvilInc</Name>\r\n                                    <RegNumber>123456</RegNumber>\r\n                                    <ForeignRNN>850107451534</ForeignRNN>\r\n                                    <MJRegDate>2006-11-13+06:00</MJRegDate>\r\n                                    <ActivityType>46909</ActivityType>\r\n                                </NorezCompany>\r\n                                <SharePercent>100.0</SharePercent>\r\n                                <InvestmentValue>200000</InvestmentValue>\r\n                            </JuridicalFounder>\r\n                        </JuridicalFounders>\r\n                    </FoundersList>\r\n                    <RegSbor>\r\n                        <Tenge>18382.0</Tenge>\r\n                        <MRP>6.62</MRP>\r\n                        <PlatName>*</PlatName>\r\n                        <PlatIIN>890829300368</PlatIIN>\r\n                        <PlatProperty> Квитанция - 19.08.2020 HSBKKZKX АО \"Народный банк Казахстана\" KZ306010131000443181</PlatProperty>\r\n                    </RegSbor>\r\n                    <RegDocuments>\r\n                        <RegDocument>\r\n                            <Number>1</Number>\r\n                            <IssueDate>2011-06-23</IssueDate>\r\n                            <Name>Копии документов, удостоверяющих личность руководителя, и копия свидетельства налогоплательщика</Name>\r\n                        </RegDocument>\r\n                        <RegDocument>\r\n                            <Number>2</Number>\r\n                            <IssueDate>2011-06-23</IssueDate>\r\n                            <Name>Копии документов, удостоверяющих личность учредителей-физических лиц, и копия свидетельства налогоплательщика</Name>\r\n                        </RegDocument>\r\n                        <RegDocument>\r\n                            <Number>3</Number>\r\n                            <IssueDate>2011-06-23</IssueDate>\r\n                            <Name>Устав</Name>\r\n                        </RegDocument>\r\n                    </RegDocuments>\r\n                </RegistrationData>\r\n            </businessData>\r\n        </q1:Request>\r\n    </soap:Body>\r\n</soap:Envelope>";
        String Response = new String(RegUl());
//        Test_api_post.ndsSaveNzResponseCheck(Response,"Налогоплательщик является действующим плательщиком НДС");

        Reg reg =new Reg();
        //reg.ndsJournal().checkCertificate("Первый руководитель или единственный учредитель (участник) ЮЛ, или ИП является бездействующим ИП или ЮЛ","190540017940");
        System.out.println("ANSWER: " + Response);
        //screenshot("123");
        //screenshot1("Скрин последней страницы");
        pause(1000);
    }*/

    public static String bodyJason = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q1=\"http://regjul.inis.gbdul.tamur.kz\" >\r\n    <soap:Header/>\r\n    <soap:Body>\r\n        <q1:Request >\r\n            <Header>\r\n                " +
            " <message_type>BJ_REG_JUL</message_type>\r\n" +
            " <message_type_name>INIS_RegJul</message_type_name>\r\n" +
            " <id_message>"+java.util.UUID.randomUUID()+"</id_message>\r\n" +
            " <id_producer>475e701f-734c-460d-bd5f-ff2a1e21fb10</id_producer>\r\n" +
            " <date_time_message>2011-06-28T10:30:55.936</date_time_message>\r\n" +
            "<sender>RS_VS</sender>\r\n" +
            "<destination>NK_VS</destination>\r\n" +
            "<users_login>sys_admin</users_login>\r\n" +
            "<message_format_version>2.0</message_format_version>\r\n" +
            "<urgency>0</urgency>\r\n" +
            "<note>0</note>\r\n" +
            "<UUID>60436032.137522479</UUID>\r\n" +
            "<MessageVersion>1</MessageVersion>\r\n" +
            "</Header>\r\n" +
            "<businessData>\r\n" +
            "<RKRegAgencyInfo>\r\n" +
            "<RegistrationPointCode>1930-01</RegistrationPointCode>\r\n" +
            "<FullAgencyNameRu>Управление юстиции города Караганды Департамента юстиции Карагандинской области</FullAgencyNameRu>\r\n" +
            "<FullAgencyNameKz>Қарағанды облысы Әділет департаментінің Қарағанды қаласының Әділет басқармасы</FullAgencyNameKz>\r\n" +
            "</RKRegAgencyInfo>\r\n" +
            "<RegistrationData>\r\n" +
            "<RegistrationType>1</RegistrationType>\r\n" +
                        "<BIN>123456777499</BIN>\r\n" +
            "<Applicant>Титов Г.А.</Applicant>\r\n" +
            "<ZayavDate>2011-06-23+06:00</ZayavDate>\r\n" +
            "<isZayvPEP>true</isZayvPEP>\r\n" +
            "<isNDS>false</isNDS>\r\n" +
            "<RegistrationCode>1</RegistrationCode>\r\n" +
            "<CreationMethod>0</CreationMethod>\r\n" +
            "<OrganizationForm>1</OrganizationForm>\r\n" +
            "<OPF>20</OPF>\r\n"+
            "<FullOfficialName>\r\n" +
            "<ru>Товарищество с ограниченной ответственностью \"Тест123\"</ru>\r\n" +
            "<kk>\"Тес123\" жауапкершілігі шектеулі серіктестігі</kk>\r\n" +
            "</FullOfficialName>\r\n\t\t\t\t\t" +
            "<ShortOfficialName>\r\n" +
            "<ru>ТОО \"Тест123\"</ru>\r\n" +
            "<kk>\"Тест123\" ЖКС</kk>\r\n" +
            "</ShortOfficialName>\r\n" +
            "<MJIssueDate>2011-06-24+06:00</MJIssueDate>\r\n" +
            "<MJPrikazNumber>3-8/581-01</MJPrikazNumber>\r\n" +
            "<PropertyType>2</PropertyType>\r\n" +
            "<isModelCharter>true</isModelCharter>\r\n" +
            "<isCommercial>false</isCommercial>\r\n" +
            "<isPrivateBusinessman>true</isPrivateBusinessman>\r\n\t\t\t\t\t" +
            "<StatusOO>1</StatusOO>\r\n\t\t\t\t\t" +
            "<GPType>1</GPType>\r\n\t\t\t\t\t" +
            "<FondType>2</FondType>\r\n" +
            "<PrivateBusinessmanType>3</PrivateBusinessmanType>\r\n" +
            "<HasForeignShare>false</HasForeignShare>\r\n" +
            "<isInternational>false</isInternational>\r\n" +
            "<isBranchOrganization>false</isBranchOrganization>\r\n" +
            "<LocationAddress>\r\n" +
            "<RKA>0201800073468623</RKA>\r\n" +
            "<Postal>Z05T3B8</Postal>\r\n" +
            "<KATOCode>711210000</KATOCode>\r\n" +
            "<StreetType>11</StreetType>\r\n" +
            "<StreetCodeAR>0004000000087817</StreetCodeAR>\r\n" +
            "<StreetCode>012144</StreetCode>\r\n" +
            "<Street>38</Street>\r\n" +
            "<StreetTypeAdd>322</StreetTypeAdd>\r\n" +
            "<StreetCodeAdd>174266</StreetCodeAdd>\r\n" +
            "<StreetAdd>38</StreetAdd>\r\n" +
            "<Building>34</Building>\r\n\t\t\t\t\t\t" +
            "<Block>1</Block>\r\n\t\t\t\t\t\t" +
            "<Korpus>2</Korpus>\r\n\t\t\t\t\t\t" +
            "<Appartment>34</Appartment>\r\n\t\t\t\t\t\t" +
            "<OffisNumber>41</OffisNumber>\r\n\t\t\t\t\t\t" +
            "<KabinetNumber>322</KabinetNumber>\r\n" +
            "<Phone>+7(748)171-34-09</Phone>\r\n\t\t\t\t\t\t" +
            "<Fax>123456789123</Fax>\r\n" +
            "<Email>something@gmail.com</Email>\r\n" +
            "</LocationAddress>\r\n" +
            "<Director>\r\n" +
            "<IIN>707383543054</IIN>\r\n" +
            "<Citizenship>1</Citizenship>\r\n" +
            "<CountryCode>398</CountryCode>\r\n" +
            "<Lastname>Титов</Lastname>\r\n" +
            "<Firstname>Гаянэ</Firstname>\r\n" +
            "<Midname>Авдеевич</Midname>\r\n\t\t\t\t\t\t" +
            "<Phone>87776665544</Phone>\r\n" +
            "<Fax>321987654321</Fax>\r\n" +
            "<Email>somesome@gmail.com</Email>\r\n" +
            "</Director>\r\n" +
            "<EconomicActivities>\r\n" +
            "<EconomicActivity>\r\n" +
            "<Code>46909</Code>\r\n" +
            "<isMain>true</isMain>\r\n" +
            "<Percent>100.0</Percent>\r\n" +
            "</EconomicActivity>\r\n" +
            "</EconomicActivities>\r\n" +
            "<ExpectedLaborAmmount>1</ExpectedLaborAmmount>\r\n" +
            "<CapitalShareList>\r\n" +
            "<CapitalValue>150.0</CapitalValue>\r\n" +
            "<State>\r\n" +
            "<Tenge>0.00000</Tenge>\r\n" +
            "<Percent>0.0</Percent>\r\n" +
            "</State>\r\n" +
            "<Private>\r\n" +
            "<Tenge>150.0</Tenge>\r\n" +
            "<Percent>100.0</Percent>\r\n" +
            "</Private>\r\n" +
            "</CapitalShareList>\r\n" +
            "<FoundersCount>4</FoundersCount>\r\n" +
            "<RegistryHolder>4</RegistryHolder>\r\n" +
            "<FoundersList>\r\n" +
            "<PrivateFounders>\r\n" +
            "<PrivateFounder>\r\n" +
            "<IsResident>true</IsResident>\r\n" +
            "<CountryCode>398</CountryCode>\r\n" +
            "<IIN>707383543054</IIN>\r\n" +
            "<Lastname>СОРОКИН</Lastname>\r\n" +
            "<Firstname>ИВАН</Firstname>\r\n" +
            "<Midname>МАРТЫНОВИЧ</Midname>\r\n" +
            "<SharePercent>100.00000</SharePercent>\r\n" +
            "<InvestmentValue>150.0</InvestmentValue>\r\n" +
            "</PrivateFounder>\r\n" +
            "<PrivateFounder>\r\n" +
            "<IsResident>false</IsResident>\r\n" +
            "<CountryCode>036</CountryCode>\r\n" +
            "<IIN>707383543054</IIN>\r\n" +
            "<Lastname>Петров</Lastname>\r\n" +
            "<Firstname>ИВАН</Firstname>\r\n" +
            "<Midname>Иванович</Midname>\r\n" +
            "<NorezPerson>\r\n" +
            "<ForeignRNN>850107451534</ForeignRNN>\r\n" +
            "<IdentityDocument>\r\n" +
            "<CategoryCode>015</CategoryCode>\r\n" +
            "<Number>N123456</Number>\r\n" +
            "<IssueDate>2006-11-13+06:00</IssueDate>\r\n" +
            "<IssueAgency>003</IssueAgency>\r\n" +
            "</IdentityDocument>\r\n" +
            "</NorezPerson>\r\n" +
            "<SharePercent>100.00000</SharePercent>\r\n" +
            "<InvestmentValue>150.0</InvestmentValue>\r\n" +
            "</PrivateFounder>\r\n" +
            "</PrivateFounders>\r\n\t\t\t\t\t\t" +
            "<JuridicalFounders>\r\n" +
            "<JuridicalFounder>\r\n" +
            "<IsResident>true</IsResident>\r\n" +
            "<CountryCode>398</CountryCode>\r\n" +
            "<BIN>202100990015</BIN>\r\n" +
            "<SharePercent>80.00000</SharePercent>\r\n" +
            "<InvestmentValue>400.00000</InvestmentValue>\r\n" +
            "</JuridicalFounder>\r\n" +
            "<JuridicalFounder>\r\n" +
            "<IsResident>false</IsResident>\r\n" +
            "<CountryCode>036</CountryCode>\r\n" +
            "<BIN>210140012306</BIN>\r\n" +
            "<NorezCompany>\r\n" +
            "<Name>EvilInc</Name>\r\n" +
            "<RegNumber>123456</RegNumber>\r\n" +
            "<ForeignRNN>850107451534</ForeignRNN>\r\n" +
            "<MJRegDate>2006-11-13+06:00</MJRegDate>\r\n" +
            "<ActivityType>46909</ActivityType>\r\n" +
            "</NorezCompany>\r\n" +
            "<SharePercent>100.0</SharePercent>\r\n" +
            "<InvestmentValue>200000</InvestmentValue>\r\n" +
            "</JuridicalFounder>\r\n" +
            "</JuridicalFounders>\r\n" +
            "</FoundersList>\r\n" +
            "<RegSbor>\r\n" +
            "<Tenge>18382.0</Tenge>\r\n" +
            "<MRP>6.62</MRP>\r\n" +
            "<PlatName>*</PlatName>\r\n" +
            "<PlatIIN>890829300368</PlatIIN>\r\n" +
            "<PlatProperty> Квитанция - 19.08.2020 HSBKKZKX АО \"Народный банк Казахстана\" KZ306010131000443181</PlatProperty>\r\n" +
            "</RegSbor>\r\n" +
            "<RegDocuments>\r\n" +
            "<RegDocument>\r\n" +
            "<Number>1</Number>\r\n" +
            "<IssueDate>2011-06-23</IssueDate>\r\n" +
            "<Name>Копии документов, удостоверяющих личность руководителя, и копия свидетельства налогоплательщика</Name>\r\n" +
            "</RegDocument>\r\n" +
            "<RegDocument>\r\n" +
            "<Number>2</Number>\r\n" +
            "<IssueDate>2011-06-23</IssueDate>\r\n" +
            "<Name>Копии документов, удостоверяющих личность учредителей-физических лиц, и копия свидетельства налогоплательщика</Name>\r\n" +
            "</RegDocument>\r\n" +
            "</RegDocuments>\r\n" +
            "</RegistrationData>\r\n            </businessData>\r\n        </q1:Request>\r\n    </soap:Body>\r\n</soap:Envelope>";



    @Step("Отправка post запроса /soapws/jurPersonRegistration.wsdl")
    public void RegUl() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("http://10.200.3.132:13206/soapws/jurPersonRegistration.wsdl")
                .header("Content-Type", "text/xml")
                .header("Accept", "*/*")
                .header("Accept-Encoding", " gzip, deflate, br")
                .header("Accept-Language", " ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Connection", " keep-alive")
                .body(bodyJason)
                .asString();

        String res = new String(response.getBody());
        Reg reg =new Reg();
        this.Msg_Id = res.substring((res.indexOf("<id_message>")+12),res.lastIndexOf("</id_message>"));
    }

    @Step("Ввести идентификатор сообщения")
    public void InsertMsgId() throws UnirestException {
        $(byId("messageUid")).setValue(this.Msg_Id);
    }

}
