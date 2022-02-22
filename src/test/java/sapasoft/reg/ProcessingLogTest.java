package sapasoft.reg;

import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.reg.pages.Adm;
import sapasoft.reg.testconfigs.BaseSetings;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Журнал обработки сообщений\"")
public class ProcessingLogTest extends BaseSetings {


    private String userName= "Сергей7";
    private String blockingDate=  date();
    private String existLogin = "6001_testpost7";
    private String reasonOfBlocking = "Отпуск";
    private String searchModule = "Администрирование и мониторинг";
    private String usersDepartment = "Комитет государственных доходов Министерства финансов Республики Казахстан";
    private String usersSubdivision = "Управление риск-менеджмента";
    private String position = "Главный эксперт";


    @DisplayName("Поиск пользователя")
    @Test
    public void t1Search() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.processingLogPage().open();
        adm.processingLogPage().advancedSearch();
    }
//
//    @DisplayName("Расширеный поиск пользователя по статусу")
//    @Test
//    public void t2ExtendedSearchStatus() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().extendedSearchUser();
//        adm.usersManagment().fillSearchStatus("Активна");
//        adm.usersManagment().applySearch();
//        adm.usersManagment().checkSearchStatus("Активна");
//        adm.logOut();
//    }

//    @DisplayName("Расширеный поиск пользователя по логину")
//    @Test
//    public void t3ExtendedSearchLogin() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().extendedSearchUser();
//        adm.usersManagment().fillLogin(existLogin);
//        adm.usersManagment().applySearch();
//        adm.usersManagment().checkLogin(existLogin);
//        adm.logOut();
//    }
//
//    @DisplayName("Расширеный поиск пользователя по полю Подсистему/модуль")
//    @Test
//    public void t4ExtendedSearchModule() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().extendedSearchUser();
//        adm.usersManagment().chooseSearchModule(searchModule);
//        adm.usersManagment().applySearch();
//        adm.usersManagment().openUser();
//        adm.usersManagment().checksearchModule(searchModule);
//        adm.usersManagment().closeUserPage();
//        adm.logOut();
//    }
//
//    @DisplayName("Расширеный поиск пользователя по полю Орган государственных доодов")
//    @Test
//    public void t5ExtendedSearchDepartment() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().extendedSearchUser();
//        adm.usersManagment().chooseSearchDepartment(usersDepartment);
//        adm.usersManagment().applySearch();
//        adm.usersManagment().checkSearchDepartment(usersDepartment);
//        adm.logOut();
//        //Configuration.holdBrowserOpen = true;
//    }
//
//    @DisplayName("Расширеный поиск пользователя по полю Орган государственных доходов")
//    @Test
//    public void t5ExtendedSearchSubdivision() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().extendedSearchUser();
//        adm.usersManagment().chooseSearchDepartment(usersDepartment);
//        adm.usersManagment().chooseSearchSubdivision(usersSubdivision);
//        adm.usersManagment().applySearch();
//        adm.usersManagment().checkSearchSubdivision(usersSubdivision);
//        adm.logOut();
//        //Configuration.holdBrowserOpen = true;
//    }
//
//    @DisplayName("Расширеный поиск пользователя по должности")
//    @Test
//    public void t6ExtendedSearchPosition() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().extendedSearchUser();
//        adm.usersManagment().chooseSearchDepartment(usersDepartment);
//        adm.usersManagment().chooseSearchSubdivision(usersSubdivision);
//        adm.usersManagment().chooseSearchPosition(position);
//        adm.usersManagment().applySearch();
//        adm.usersManagment().checkSearchPosition(position);
//        adm.logOut();
//        //Configuration.holdBrowserOpen = true;
//    }
//
//
//    @DisplayName("Блокировка пользователя")
//    @Test
//    public void t7BlockUnblockUser(){
//        Adm adm= new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().searchUser(userName);
//        adm.usersManagment().checkSearchStatus("Активна");
//        adm.usersManagment().openUser();
//        adm.usersManagment().blockUser();
//        adm.usersManagment().reasonOfBlockingUser(reasonOfBlocking);
//        adm.usersManagment().chooseDateFrom(blockingDate);
//        adm.usersManagment().blockUserConfirm();
//        adm.usersManagment().checkThatUserBlocked();
//        adm.usersManagment().closeUserPage();
//        adm.usersManagment().checkSearchStatus("Заблокирована");
//        adm.usersManagment().openUser();
//        adm.usersManagment().unblockUser();
//        adm.usersManagment().unblockUserConfirm();
//        adm.usersManagment().checkThatUserUnblocked();
//        adm.usersManagment().closeUserPage();
//        adm.usersManagment().checkSearchStatus("Активна");
//        adm.logOut();
//    }



}
