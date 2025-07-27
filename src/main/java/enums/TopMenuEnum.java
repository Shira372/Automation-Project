package enums;

public enum TopMenuEnum {
    M_Z ("ctl00_Topmneu_BenefitsHyperLink"),
    K_V ("ctl00_Topmneu_HyperLink3"),
    D_B ("ctl00_Topmneu_InsuranceHyperLink"),
    Y_K ("ctl00_Topmneu_ContactsHyperLink"),
    SEARCH ("TopQuestions"),
    ICON_SEARCH("ctl00_SiteHeader_reserve_btnSearch"),
    BRANCH("ctl00_Topmneu_BranchesHyperLink");

    private final String topMenu;

    TopMenuEnum(String topMenu) {
        this.topMenu = topMenu;
    }

    public String getTopMenu() {
        return this.topMenu;
    }

    public  String getSearch(){
        return SEARCH.topMenu;
    }

    public  String getSearchIcon(){
        return ICON_SEARCH.topMenu;
    }

    public String getBranches(){
        return BRANCH.topMenu;
    }
}
