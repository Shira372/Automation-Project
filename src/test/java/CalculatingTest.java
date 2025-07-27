

import btl.BtlBasePage;
import btl.Calculating;
import enums.TopMenuEnum;
import junitExtenssion.ExtentReportExtension;
import junitExtenssion.WebDriverExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatingTest extends BaseTest{
    private Calculating calculatingPage;

    @BeforeEach

    public void initPage() {
        calculatingPage = new Calculating(driver);
    }

    @Test
    public void Calculating_Contributions() throws InterruptedException {
        calculatingPage.getTopMenuEnum(TopMenuEnum.D_B);
        calculatingPage.getSubMenu("דמי ביטוח לאומי");

        assertEquals("דמי ביטוח לאומי - דמי ביטוח | ביטוח לאומי", driver.getTitle(), "החיפוש לא החזיר את הדף המצופה.");

        calculatingPage.clickSomePageLink();

        assertEquals("חישוב דמי ביטוח עבור עצמאי, תלמיד, שוהה בחוץ לארץ ומי שלא עובד - דמי ביטוח | ביטוח לאומי", driver.getTitle(), "החיפוש לא החזיר את הדף המצופה");

        calculatingPage.checkEmployeType();
        calculatingPage.setBirthDate("1/11/2006");
        calculatingPage.checkGenderMale();

        calculatingPage.clickStartNext();

        assertEquals("צעד שני", calculatingPage.getStepTwoHeaderText(), "לא נמצאה התאמה");

        calculatingPage.disabilityPension("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_GetNechut_1");

        calculatingPage.clickSecondNext();

        assertEquals("סיום", calculatingPage.getFinishHeaderText(), "לא הגעת לשלב הסיום");

        System.out.println("Success: Was finish to enter details. wait to the res.");

        assertTrue(calculatingPage.getLeumiResult().contains("43"), "לאומי לא זהה");
        assertTrue(calculatingPage.getHealthResult().contains("120"), "health לא זהה");
        assertTrue(calculatingPage.getMonthlyResult().contains("163"), "monthly לא זהה");

        System.out.println("The calculation is correct!");
    }

    // ניתן להוסיף כאן שאר הבדיקות כמו שהיו אצלך במקור, בצורה דומה
    @Test
    public void testCalc() {
        calculatingPage.getTopMenuEnum(TopMenuEnum.K_V);
        calculatingPage.getSubMenu("אבטלה");

        calculatingPage.clickUnemploymentCalcLink(); // לחיצה על מחשבון אבטלה
        calculatingPage.clickUnemploymentOption();   // בחירת אפשרות אבטלה

        calculatingPage.setUnemploymentDate("1/05/2025"); // הכנסת תאריך פיטורים
        calculatingPage.disabilityPension("ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_rdb_age_1"); // בחירת גיל
        System.out.printf("1");

        calculatingPage.clickUnemploymentStartNext(); // מעבר לשלב הבא
        System.out.printf("2");

                for (int i = 2; i <= 7; i++) {
            String xpath = String.format(
                    "//*[@id='ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_IncomeGrid_ctl%02d_Txt_Sallary']",
                    i
            );
            calculatingPage.setInput(xpath, String.valueOf(998 + i)); // כלומר: 1000 עד 1005
        }
        calculatingPage.clickUnemploymentStepNext(); // מעבר לשלב הבא
        System.out.printf("3");

        // אימות כותרת תוצאות
        String subTitle = calculatingPage.getUnemploymentHeaderText();
        System.out.printf("4");

        System.out.println(subTitle);
        assertEquals("תוצאות החישוב", subTitle, "לא הגעת לתוצאות החישוב");

        // אימות רכיבי טקסט בדוח
        String dailyWage = calculatingPage.getLabelDailyWage();
        String perDay = calculatingPage.getLabelUnemploymentPerDay();
        String perMonth = calculatingPage.getLabelUnemploymentPerMonth();

        assertTrue(dailyWage.contains("שכר יומי ממוצע לצורך חישוב דמי אבטלה"), "לא הגעת לdailyWage");
        assertTrue(perDay.contains("דמי אבטלה ליום"), "dayUneoymentBenefits לא זהה");
        assertTrue(perMonth.contains("דמי אבטלה לחודש"), "monthUneoymentBenefits לא זוהה");

        System.out.println("The calculation is correct!");
    }

    @Test
    public void Nav() {
        calculatingPage.getTopMenuEnum(TopMenuEnum. K_V);
        calculatingPage.getSubMenu("אבטלה");

    }

    @ParameterizedTest
    @ValueSource(strings = {"מענק לימודים", "מזונות", "סיעוד", "מילואים", "אבטלה"})
    void testNavigateToBenefitsPages(String pageName) {
        calculatingPage.getTopMenuEnum(TopMenuEnum. K_V);
        calculatingPage.getSubMenu(pageName);
        assertTrue(driver.getTitle().contains(pageName));
    }


}
