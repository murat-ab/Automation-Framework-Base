package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager extends BasePage {

    public static ExtentReports extentReport;
    public static String extentReportPrefix;
    public static ExtentTest extentTest;

    public ExtentManager() throws IOException {
        super();
    }

    public static ExtentReports setupExtentReport() {
        extentReport = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") +
                "/target/extent-reports/" + extentReportsPrefix_Name("BaseFramework") + ".html");
        extentReport.attachReporter(spark);

        extentReport.setSystemInfo("Murat A","My Name");
        spark.config().setReportName("Basic Test");
        spark.config().setDocumentTitle("Test Results");
        spark.config().setTheme(Theme.STANDARD);

        return extentReport;
    }

    public static String extentReportsPrefix_Name(String testName) {
        String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        extentReportPrefix = testName + "_" + date;
        return extentReportPrefix;
    }

    public static void flushReport() {
        extentReport.flush();
    }

    public static ExtentTest createTest(String name, String description) {
        extentTest = extentReport.createTest(name, description);
        return extentTest;
    }

    public static void log(String message) {
        extentTest.info(message);
    }

    public static void pass(String message) {
        extentTest.pass(message);
    }

    public static void fail(String message) {
        extentTest.fail(message);
    }

    public static void attachImage() {
        extentTest.addScreenCaptureFromPath(getScreenShotDestinationPath());
    }
}
