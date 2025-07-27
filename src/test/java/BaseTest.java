
import drivers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import junitExtenssion.ExtentReportExtension;
import junitExtenssion.WebDriverExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@ExtendWith({ExtentReportExtension.class, WebDriverExtension.class})

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = DriverManager.getDriver();
        driver.get("https://www.btl.gov.il/");
    }

    @AfterAll
    public static void closeDriver() {
        DriverManager.quitDriver(); // ❗ רק בסוף כל הריצה!
    }

}
