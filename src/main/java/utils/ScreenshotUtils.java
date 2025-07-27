package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

//
//
//
//public class ScreenshotUtils {
//    public static boolean takeScreenshot(WebDriver driver, String destinationPath) {
//        if (driver != null) {
//            try {
//                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                if (srcFile.length() == 0) {
//                    System.err.println("Screenshot is empty!");
//                    return false;
//                }
//                Files.copy(srcFile.toPath(), new File(destinationPath).toPath());
//                return true;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        System.err.println("Driver is null or failed");
//        return false;
//    }
//
//}

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.time.Duration;

public class ScreenshotUtils {
    public static boolean takeScreenshot(WebDriver driver, String destinationPath) {
        try {
            // להמתין לטעינה מלאה
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete")
            );

            // להגדיר רזולוציה מדויקת (מסך מחשב אמיתי)
            driver.manage().window().setSize(new Dimension(1920, 1080));

            // צילום באמצעות AShot כולל גלילה
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100)) // צילום כל העמוד
                    .takeScreenshot(driver);

            File destinationFile = new File(destinationPath);
            destinationFile.getParentFile().mkdirs(); // יצירת תיקיות אם חסרות
            ImageIO.write((RenderedImage) screenshot.getImage(), "PNG", destinationFile);
            return true;
        } catch (Exception e) {
            System.err.println("Screenshot failed: " + e.getMessage());
            return false;
        }
    }
}




