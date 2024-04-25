package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BasePage {

    public static WebDriver driver;
    private String url;
    private Properties prop;
    public static String screenShotDestinationPath;

    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
        prop.load(data);
    }

    public WebDriver getDriver() {
        if (prop.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();

        } else if (prop.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();

        } else {
            driver = new EdgeDriver();
        }
        return driver;
    }

    public String getUrl() {
        url = prop.getProperty("url");
        return url;
    }

    public static String takeSnapShot(String name) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destFile = System.getProperty("user.dir") + "\\target\\screenshots\\" + timestamp() + ".png";
        screenShotDestinationPath = destFile;

        try {
            FileUtils.copyFile(srcFile, new File(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static String getScreenShotDestinationPath() {
        return screenShotDestinationPath;
    }
}
