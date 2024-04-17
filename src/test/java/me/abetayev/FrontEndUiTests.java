package me.abetayev;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class FrontEndUiTests extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(FrontEndUiTests.class);

    public FrontEndUiTests() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        driver = getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }

    @Test
    public void basicFrontEndTest() {
        LOGGER.info("Running basic frontend test");

        Assert.assertTrue(driver.getTitle().contains("QA Demo"),
                "Page title did not include expected text");
    }


}
