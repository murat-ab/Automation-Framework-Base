package listeners;

import base.BasePage;
import base.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BasePage implements ITestListener {
    public Listeners() throws IOException {
        super();
    }

    public void onStart(ITestContext context) {
        ExtentManager.setupExtentReport();
        ExtentManager.createTest(context.getName(), context.getName());
    }

    public void onTestFailure(ITestResult result) {
        ExtentManager.extentTest.fail(result.getThrowable());
        try {
            System.out.println("Test failed: " + result.getName());
            takeSnapShot(result.getMethod().getMethodName());
            ExtentManager.attachImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFinish(ITestContext context) {
        ExtentManager.flushReport();
    }
}
