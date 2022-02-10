package sapasoft.adm.pages;

import sapasoft.adm.testconfigs.BaseSetings;

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

    public StaticalReportPage staticalReport (){
        StaticalReportPage staticalReportPage = new StaticalReportPage();
        return staticalReportPage;
    }
}
