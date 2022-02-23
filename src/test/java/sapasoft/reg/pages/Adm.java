package sapasoft.reg.pages;

import sapasoft.reg.testconfigs.BaseSetings;

public class Adm extends BaseSetings {
    public void logIn(String login, String password){
        new Auth().logIn(login, password);
    }

    public void logOut(){
        new Auth().logOut();
    }
    public void registration(){
        new Auth().registration();
    }

    public Registration registrationUser(){
        Registration registration = new Registration();
        return registration;
    }

    public RightsManagment rightsManagment(){
        RightsManagment rightsManagment = new RightsManagment();
        return rightsManagment;
    }

    public RolesManagment rolesManagment(){
        RolesManagment rolesManagment = new RolesManagment();
        return rolesManagment;
    }


    public RolesGroupsManagmentPage rolesGroupsManagment() {
        RolesGroupsManagmentPage rolesGroupsMangmentPage =new RolesGroupsManagmentPage();
        return rolesGroupsMangmentPage;
    }

    public UsersManagmentPage usersManagment(){
        UsersManagmentPage usersManagmentPage = new UsersManagmentPage();
        return usersManagmentPage;
    }

    public ApplicationManagementPage applicationManagement(){
        ApplicationManagementPage applicationManagementPage = new ApplicationManagementPage();
        return applicationManagementPage;
    }

    public AdditionalApplicationPage additionalApplication(){
        AdditionalApplicationPage additionalApplicationPage = new AdditionalApplicationPage();
        return additionalApplicationPage;
    }

    public StatisticReportUserPage statisticUserReport (){
        StatisticReportUserPage statisticReportUserPage = new StatisticReportUserPage();
        return statisticReportUserPage;
    }

    public StatisticReportRolesPage statisticRolesReport (){
        StatisticReportRolesPage statisticReportRolesPage = new StatisticReportRolesPage();
        return statisticReportRolesPage;
    }

    public StatisticReportRulesPage statisticRulesReport (){
        StatisticReportRulesPage statisticReportRulesPage = new StatisticReportRulesPage();
        return statisticReportRulesPage;
    }

    public StatisticReportStatisticPage statisticReportStatistic (){
        StatisticReportStatisticPage statisticReportStatisticPage = new StatisticReportStatisticPage();
        return statisticReportStatisticPage;
    }




}
