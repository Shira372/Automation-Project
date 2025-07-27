package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
//    private static ExtentReports extent;
//
//    // משמש כשאתה רוצה להזרים אותו מבחוץ (מה-Extension)
//    public static void setExtent(ExtentReports ext) {
//        extent = ext;
//    }
//
//    public static ExtentReports getExtent() {
//        if (extent == null) {
//            initReport();
//        }
//        return extent;
//    }
//
//    private static void initReport() {
//        System.out.println("jjj");
//        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport/ExtentReport.html");
//        extent = new ExtentReports();
//        extent.attachReporter(spark);
//    }
//
//    public static void flushReport() {
//        if (extent != null) {
//            extent.flush();
//        }
//    }
private static ExtentReports extent;
    public static ExtentReports getExtent() {
        if (extent == null) {
            initReport();
        }
        return extent;
    }

    private static void initReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
