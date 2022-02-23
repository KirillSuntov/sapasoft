package sapasoft.reg.pages;

import sapasoft.reg.testconfigs.BaseSetings;

public class Reg extends BaseSetings {
    public void logIn(String login, String password){
        new Auth().logIn(login, password);
    }

    public void logOut(){
        new Auth().logOut();
    }
    public void registration(){
        new Auth().registration();
    }


    public NdsJournalPage ndsJournal (){
        NdsJournalPage ndsJournalPage = new NdsJournalPage();
        return ndsJournalPage;
    }

    public ProcessingLogPage processingLogPage (){
        ProcessingLogPage processingLogPage = new ProcessingLogPage();
        return processingLogPage;
    }

    public AdjustmentJournalPage adjustmentJournalPage (){
        AdjustmentJournalPage adjustmentJournalPage = new AdjustmentJournalPage();
        return adjustmentJournalPage;
    }

    public BVUJournalPage bVUJournalPage (){
        BVUJournalPage bVUJournalPage = new BVUJournalPage();
        return bVUJournalPage;
    }
    public KKMJournalPage kKMJournalPage (){
        KKMJournalPage kKMJournalPage = new KKMJournalPage();
        return kKMJournalPage;
    }
    public KkmRegistryPage kkmRegistryPage (){
        KkmRegistryPage kkmRegistryPage = new KkmRegistryPage();
        return kkmRegistryPage;
    }
    public AdditionalInfoConfigPage additionalInfoConfigPage (){
        AdditionalInfoConfigPage additionalInfoConfigPage = new AdditionalInfoConfigPage();
        return additionalInfoConfigPage;
    }
    public SertificatesJournalPage sertificatesJournalPage (){
        SertificatesJournalPage sertificatesJournalPage = new SertificatesJournalPage();
        return sertificatesJournalPage;
    }

    public OvdJournalPage ovdJournalPage (){
        OvdJournalPage ovdJournalPage = new OvdJournalPage();
        return ovdJournalPage;
    }
    public TaxRegimeJournalPage taxRegimeJournalPage (){
        TaxRegimeJournalPage taxRegimeJournalPage = new TaxRegimeJournalPage();
        return taxRegimeJournalPage;
    }
    public NpJournalPage npJournalPage (){
        NpJournalPage npJournalPage = new NpJournalPage();
        return npJournalPage;
    }

    public BasePage basePage (){
        BasePage basePage = new BasePage();
        return basePage;
    }

}
