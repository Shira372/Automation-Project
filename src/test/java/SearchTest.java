import btl.BtlBasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import junitExtenssion.ExtentReportExtension;
import junitExtenssion.WebDriverExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class SearchTest extends BaseTest {

    private BtlBasePage btlPageObject;

    @BeforeEach
    public void initPage() {
        btlPageObject = new BtlBasePage(driver) {}; // שימוש ב־Page Object קיים
    }
    @Test
    public void testWithReport(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        ExtentSparkReporter reporter = new ExtentSparkReporter("./target/extentReport/ExtentReport"+timestamp+".html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        // 2. יצירת טסט עם תיאור
        ExtentTest test = extent.createTest("Example", "דוגמה לשימוש ttt Extent Report");

        test.assignAuthor("ו3");
        test.assignCategory("ReAgression");
        test.assignDevice("Chrome 124");

        test.info("my test was started");

        test.pass("my test is passed");
        test.fail("my test is fail");
        // Find the element using the locator and click it
        // clickTopMenu(DriverManager.getDriver(), TopMenuEnum.M_Z);
        extent.flush();
    }
    @Test
    public void testSearch() {
        Report.ExtentTestManager.getTest().info("הרצת חיפוש...");

        btlPageObject.getSearch("חישוב סכום דמי לידה ליום");
        String pageTitle = driver.getTitle();
        Report.ExtentTestManager.getTest().info("Title: " + pageTitle);

        assertEquals("חיפוש | ביטוח לאומי", pageTitle, "החיפוש לא החזיר את הדף המצופה.");
    }

}
