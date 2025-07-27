//package btl;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import utils.WaitUtil;
//
//public class Calculating extends BtlBasePage{
//    public Calculating(WebDriver driver) {
//        super(driver);
//    }
//
//     WebElement ByXpathNavigation(String xpath) {
//        WebElement element = WaitUtil.waitForElementToBeClickable(driver, By.xpath(xpath), 10);
//        return element;
//    }
//     void clickByXpathNavigation(String xpath) {
//        WebElement element =ByXpathNavigation(xpath);
//        System.out.println("pass");
//        element.click();
//    }
//
//
// void clickByIdWithScroll(String id) {
//    By by = By.id(id);
//     System.out.println("1");
//    WebElement element = driver.findElement(by);
//
//     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);     System.out.println("3");
//
//     WaitUtil.waitForElementToBeClickable(driver, by, 40).click();     System.out.println("4");
//
// }
//
//     void sendKeyByXpathNavigation(String xpath,String key) {
//        WebElement element =ByXpathNavigation(xpath);
//        System.out.println("pass");
//        element.sendKeys(key);
//    }
//
//
//    public void checkBoxClick(String xpath)
//    {
//        clickByXpathNavigation(xpath);
//    }
//    public void disabilityPension(String xpath)
//    {
//        clickByIdWithScroll(xpath);
//    }
//  public  void setDate(String xpath,String date)
//  {
//      sendKeyByXpathNavigation(xpath,date);
//  }
//public void stepClick(String xpath)
//{
//    clickByXpathNavigation(xpath);
//}
//public WebElement getHeader(String xpath)
//{
//    return ByXpathNavigation(xpath);
//}
//public WebElement getData(String xpath)
//{
//    return ByXpathNavigation(xpath);
//}
//public void setInput(String xpath,String val)
//{
//    sendKeyByXpathNavigation(xpath,val);
//
//}
//}
package btl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class Calculating extends BtlBasePage {

    public Calculating(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // אלמנטים

    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/div[2]/span/div[2]/p[3]/a")
    private WebElement linkSomePage;

    @FindBy(id = "ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_employeType_2_lbl")
    private WebElement checkboxEmployeType;

    @FindBy(xpath = "//*[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_DynDatePicker_BirthDate_Date\"]")
    private WebElement inputBirthDate;

    @FindBy(id = "ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_Gender_0")
    private WebElement checkboxGenderMale;

    @FindBy(xpath = "//*[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StartNavigationTemplateContainerID_StartNextButton\"]")
    private WebElement buttonStartNext;
////*[@id="ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StepNavigationTemplateContainerID_StepNextButton"]
   @FindBy(xpath = "//*[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StepNavigationTemplateContainerID_StepNextButton\"]")
     private WebElement buttonSecondNext;
    @FindBy(xpath = "//*[contains(text(), 'צעד שני')]")
    private WebElement headerStepTwo;

    @FindBy(xpath = "//*[contains(text(), 'סיום')]")
    private WebElement headerFinish;

    @FindBy(xpath = "//*[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_div_Result\"]/ul/li[1]/strong")
    private WebElement resultLeumi;

    @FindBy(xpath = "//*[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_div_Result\"]/ul/li[2]/strong")
    private WebElement resultHealth;

    @FindBy(xpath = "//*[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_div_Result\"]/ul/li[3]/strong")
    private WebElement resultMonthly;
    // אבטלה

    @FindBy(xpath = "//*[@id='mainContent']/div[1]/div[2]/span/div[2]/div[3]/a/strong")
    private WebElement unemploymentCalculatorLink;

    @FindBy(xpath = "//*[@id='ctl00_PlaceHolderMain_SiteNodesControl_ChildrensDiv']/ul/li[2]/a")
    private WebElement unemploymentOption;

    @FindBy(id = "ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_DynDatePicker_PiturimDate_Date")
    private WebElement unemploymentDateInput;

    @FindBy(id = "ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_StartNavigationTemplateContainerID_StartNextButton")
    private WebElement unemploymentStartNext;

    @FindBy(id = "ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_StepNavigationTemplateContainerID_StepNextButton")
    private WebElement unemploymentStepNext;

    @FindBy(xpath = "//*[@id='ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_StepDiv3']/h3")
    private WebElement headerUnemploymentResults;

    @FindBy(xpath = "//*[@id='ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_StepDiv3']/div[3]/ul/li[1]/label")
    private WebElement labelDailyWage;

    @FindBy(xpath = "//*[@id='ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_StepDiv3']/div[3]/ul/li[2]/label")
    private WebElement labelUnemploymentPerDay;

    @FindBy(xpath = "//*[@id='ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_StepDiv3']/div[3]/ul/li[3]/label")
    private WebElement labelUnemploymentPerMonth;




    // פעולות

    public void clickSomePageLink() {
        WaitUtil.waitForElementToBeClickable(driver, linkSomePage, 10).click();
    }

    public void checkEmployeType() {
        WaitUtil.waitForElementToBeClickable(driver, checkboxEmployeType, 10).click();
    }

    public void setBirthDate(String date) {
        inputBirthDate.clear();
        inputBirthDate.sendKeys(date);
    }

    public void checkGenderMale() {
        checkboxGenderMale.click();
    }

    public void clickStartNext() {
        WaitUtil.waitForElementToBeClickable(driver, buttonStartNext, 30);
        buttonStartNext.click();
    }
    public void clickSecondNext() {
        WaitUtil.waitForElementToBeClickable(driver, buttonSecondNext, 30);
        buttonSecondNext.click();
    }
    public String getStepTwoHeaderText() {
   WaitUtil.waitForElementToBeClickable(driver, headerStepTwo, 10);

        return headerStepTwo.getText().split("\n")[0];
    }

    public String getFinishHeaderText() {

              WaitUtil.waitForElementToBeClickable(driver, headerFinish, 10);

        return headerFinish.getText().split("\n")[0];
    }

    public void disabilityPension(String id) {
        WebElement element = driver.findElement(org.openqa.selenium.By.id(id));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        WaitUtil.waitForElementToBeClickable(driver, element, 40).click();
    }

    public String getLeumiResult() {
        WaitUtil.waitForElementToBeClickable(driver, resultLeumi, 10);

        return resultLeumi.getText();
    }

    public String getHealthResult() {
        WaitUtil.waitForElementToBeClickable(driver, resultHealth, 10);

        return resultHealth.getText();
    }

    public String getMonthlyResult() {
        WaitUtil.waitForElementToBeClickable(driver, resultMonthly, 10);

        return resultMonthly.getText();
    }

    // אבטלה
    public void clickUnemploymentCalcLink() {
        WaitUtil.waitForElementToBeClickable(driver, unemploymentCalculatorLink, 10).click();
    }

    public void clickUnemploymentOption() {
        WaitUtil.waitForElementToBeClickable(driver, unemploymentOption, 10).click();
    }

    public void setUnemploymentDate(String date) {
        unemploymentDateInput.clear();
        unemploymentDateInput.sendKeys(date);
    }

    public void clickUnemploymentStartNext() {
        WaitUtil.waitForElementToBeClickable(driver, unemploymentStartNext, 10).click();
    }

    public void clickUnemploymentStepNext() {
        WaitUtil.waitForElementToBeClickable(driver, unemploymentStepNext, 10).click();
    }

    public String getUnemploymentHeaderText() {
        WaitUtil.waitForElementToBeClickable(driver, headerUnemploymentResults, 10);

        return headerUnemploymentResults.getText().split("\n")[0];
    }

    public String getLabelDailyWage() {
        return labelDailyWage.getText();
    }

    public String getLabelUnemploymentPerDay() {
        return labelUnemploymentPerDay.getText();
    }

    public String getLabelUnemploymentPerMonth() {
        return labelUnemploymentPerMonth.getText();
    }

    // דינאמי – שדות שכר
    public void setIncomeInput(int rowIndex, String value) {
        String formattedIndex = String.format("%02d", rowIndex);
        WebElement input = driver.findElement(org.openqa.selenium.By.xpath(
                String.format("//*[@id='ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_IncomeGrid_ctl%s_Txt_Sallary']", formattedIndex)
        ));
        input.clear();
        input.sendKeys(value);
    }


public void setInput(String xpath,String val)
{
 WaitUtil.waitForElementToBeClickable(driver, By.xpath(xpath), 10).sendKeys(val);


}

}
