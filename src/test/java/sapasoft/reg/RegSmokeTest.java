package sapasoft.reg;

import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.reg.pages.Adm;
import sapasoft.reg.pages.Reg;
import sapasoft.reg.testconfigs.BaseSetings;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Smoke тест: проверка разделов регистрации")
public class RegSmokeTest extends BaseSetings {


    @DisplayName("Проверка раздела Журнал обработки сообщений")
    @Test
    public void ProcessingLogSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.processingLogPage().open();
    }

    @DisplayName("Проверка раздела Реестр налогоплательщиков")
    @Test
    public void NpJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.npJournalPage().open();
    }

    @DisplayName("Проверка раздела Журнал документов режимов налогообложения")
    @Test
    public void TaxRegimeJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.taxRegimeJournalPage().open();
    }

    @DisplayName("Проверка раздела Журнал НДС")
    @Test
    public void NdsJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.ndsJournal().open();
    }

    @DisplayName("Проверка раздела Журнал ОВД")
    @Test
    public void OvdJournalSmoke() {
        Reg reg = new Reg();
        reg.logIn(login, password);
        reg.ovdJournalPage().open();
    }
}
