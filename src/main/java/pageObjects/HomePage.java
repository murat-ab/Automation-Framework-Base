package pageObjects;

import base.BasePage;
import base.ExtentManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static base.Hooks.*;

public class HomePage extends BasePage {

    public static By my_account_link = new By.ByXPath("//nav[@id='site-navigation']//a[text()='My account']");

    public HomePage() throws IOException {
        super();
    }

    public static void validate_my_account_page_title() {
        driver.findElement(my_account_link).click();
        ExtentManager.pass("Successfully clicked 'My Account' link");
        try {
            Assert.assertTrue(driver.getTitle().contains("My account – QA Demo"));
            ExtentManager.pass("validate_my_account_page_title() passed");
        } catch (AssertionError e) {
            Assert.fail("Page title did not include expected text");
        }
    }

    public static void fail_validate_my_account_page_title() {
        driver.findElement(my_account_link).click();
        ExtentManager.pass("Successfully clicked 'My Account' link");
        try {
            Assert.assertTrue(driver.getTitle().contains("My Account – QA Demo"));
            ExtentManager.pass("validate_my_account_page_title() passed");
        } catch (AssertionError e) {
            Assert.fail("Page title did not include expected text");
        }
    }
}
