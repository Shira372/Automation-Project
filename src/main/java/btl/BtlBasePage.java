package btl;

import enums.TopMenuEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtil;

public abstract class BtlBasePage extends Base_btl{

    public BtlBasePage(WebDriver driver) {
        super(driver);
    }

    public void getTopMenuEnum(TopMenuEnum mainNavigate){
        driver.findElement(By.id(mainNavigate.getTopMenu())).click();
    }

public void getSubMenu(String subMenuText) {
    By subMenuLocator = By.linkText(subMenuText);
    WaitUtil.waitForElementToBeClickable(driver, subMenuLocator, 10).click();
}

    public void getSearch(String value){

        driver.findElement(By.id(TopMenuEnum.SEARCH.getSearch())).sendKeys(value);
        driver.findElement(By.id(TopMenuEnum.ICON_SEARCH.getSearchIcon())).click();
    }

    public BranchesPage getBranch(){
        driver.findElement(By.id(TopMenuEnum.BRANCH.getBranches())).click();
        return new BranchesPage(driver);
    }



}
