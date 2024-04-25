package me.abetayev.frontEndTests;

import base.ExtentManager;
import base.Hooks;
import org.testng.annotations.*;
import pageObjects.HomePage;

import java.io.IOException;

@Listeners(listeners.Listeners.class)

public class FrontEndUiTests extends Hooks {

    public FrontEndUiTests() throws IOException {
        super();
    }

    @Test
    public void basicFrontEndTest() {
        ExtentManager.log("Starting BasicFrontEndTest...");
        HomePage.validate_my_account_page_title();
    }

    @Test
    public void failFrontEndTest() {
        ExtentManager.log("Starting FailFrontEndTest...");
        HomePage.fail_validate_my_account_page_title();
    }
}
