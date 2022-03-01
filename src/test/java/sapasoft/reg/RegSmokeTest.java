package sapasoft.reg;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.reg.pages.Adm;
import sapasoft.reg.pages.Reg;
import sapasoft.reg.testconfigs.BaseSetings;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Smoke тест: проверка разделов регистрации")
public class RegSmokeTest extends BaseSetings {


    @DisplayName("Проверка раздела Журнал обработки сообщений")
    @Test
    public void ProcessingLogSmoke() throws IOException {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.processingLogPage().open();
        reg.basePage().checkTitle("Журнал обработки сообщений");
        reg.processingLogPage().advancedSearch();
        reg.processingLogPage().advancedSearch_Choose_NP("ЮЛ (ГБД ЮЛ)");
        reg.processingLogPage().advancedSearch_Choose_Status("Ошибочное");
        reg.processingLogPage().advancedSearch_Choose_MsgType("Входящее");
        reg.processingLogPage().advancedSearch_Choose_MsgSource("ГБД ЮЛ");
        reg.processingLogPage().advancedSearch_Choose_OperationType("Регистрация");
        //reg.processingLogPage().advancedSearch_Choose_CodeTypeMsg("Сообщение  о постановке на регистрационный учёт в качестве ЮЛ (филиала, представительства)");
        reg.processingLogPage().advancedSearch_Apply();
        reg.processingLogPage().Check_Equality_Of_Status_To_Search();
        reg.processingLogPage().Check_Equality_Of_MsgType_To_Search();
        reg.processingLogPage().Check_Equality_Of_MsgSource_To_Search();
        reg.processingLogPage().Check_Equality_Of_OperationType_To_Search_ByLoop();

    }

    @DisplayName("Проверка раздела Реестр налогоплательщиков")
    @Test
    public void NpJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.npJournalPage().open();
        reg.basePage().checkTitle("Реестр налогоплательщиков");
        reg.basePage().checkTbody("Реестр налогоплательщиков");
    }

    @DisplayName("Проверка раздела Журнал документов режимов налогообложения")
    @Test
    public void TaxRegimeJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.taxRegimeJournalPage().open();
        reg.basePage().checkTitle("Журнал документов режимов налогообложения");
        reg.basePage().checkTbody("Журнал документов режимов налогообложения");
    }

    @DisplayName("Проверка раздела Журнал НДС")
    @Test
    public void NdsJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.ndsJournal().open();
        reg.basePage().checkTitle("Журнал НДС");
        reg.basePage().checkTbody("Журнал НДС");
    }

    @DisplayName("Проверка раздела Журнал ОВД")
    @Test
    public void OvdJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.ovdJournalPage().open();
        reg.basePage().checkTitle("Журнал ОВД");
        reg.basePage().checkTbody("Журнал ОВД");
    }

    @DisplayName("Проверка раздела Журнал выдачи сертификатов резидентства")
    @Test
    public void SertificatesJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.sertificatesJournalPage().open();
        reg.basePage().checkTitle("Журнал выдачи сертификатов резидентства");
        reg.basePage().checkTbody("Журнал выдачи сертификатов резидентства");
    }

    @DisplayName("Проверка раздела Конфигуратор дополнительных сведений")
    @Test
    public void AdditionalInfoConfigSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.additionalInfoConfigPage().open();
        reg.basePage().checkTitle("Конфигуратор дополнительных сведений");
        reg.basePage().checkTbody("Конфигуратор дополнительных сведений");
    }

    @DisplayName("Проверка раздела Государственный реестр ККМ")
    @Test
    public void KkmRegistrySmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.kkmRegistryPage().open();
        reg.basePage().checkTitle("Государственный реестр ККМ");
        reg.basePage().checkTbody("Государственный реестр ККМ");
    }

    @DisplayName("Проверка раздела Журнал ККМ")
    @Test
    public void KKMJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.kKMJournalPage().open();
        reg.basePage().checkTitle("Журнал ККМ");
        reg.basePage().checkTbody("Журнал ККМ");
    }

    @DisplayName("Проверка раздела Журнал банковских счетов")
    @Test
    public void BVUJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.bVUJournalPage().open();
        reg.basePage().checkTitle("Журнал банковских счетов");
        reg.basePage().checkTbody("Журнал банковских счетов");
    }

    @DisplayName("Проверка раздела Журнал корректировки данных налогоплательщиков")
    @Test
    public void AdjustmentJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.adjustmentJournalPage().open();
        reg.basePage().checkTitle("Журнал корректировки данных налогоплательщиков");
        reg.basePage().checkTbody("Журнал корректировки данных налогоплательщиков");
    }

}
