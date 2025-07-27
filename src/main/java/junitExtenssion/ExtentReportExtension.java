package junitExtenssion;

import Report.ExtentTestManager;
import Report.ReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import drivers.DriverManager;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import utils.ScreenshotUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportExtension implements BeforeEachCallback,   AfterTestExecutionCallback,AfterAllCallback {

    private static ExtentTest extentTest;
    private String testName;
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {

        testName = context.getDisplayName().replaceAll("[^a-zA-Z0-9]", "_");
        extentTest = ReportManager.getExtent().createTest("./target/ExtentReport/"+testName+".html");
        ExtentTestManager.setTest(extentTest);
    }


    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        if(context.getExecutionException().isPresent()){
            String cause = context.getExecutionException().get().getMessage();
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String screenshotPath = "./target/ExtentReport/screenshot/" + context.getTestMethod().get().getName() + timestamp + ".png";
            boolean isTakeScreenshot = ScreenshotUtils.takeScreenshot(DriverManager.getDriver(), screenshotPath);
            String relativePath = "./screenshot/" + context.getTestMethod().get().getName() + timestamp + ".png";
            if (isTakeScreenshot)
                extentTest.fail(cause,
                        MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
            else {
                extentTest.fail("tet fail but can't take screenshot");
                extentTest.fail(cause);
            }
        }
    }


    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        ReportManager.getExtent().flush();
    }
    }