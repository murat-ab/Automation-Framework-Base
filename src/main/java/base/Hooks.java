package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class Hooks extends BasePage{

    public Hooks() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() {
        getDriver().get(getUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
