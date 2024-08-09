package com.webproject.selenium.core;

import com.webproject.selenium.constants.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HookClass {

    protected static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HookClass.class);


    private static String getBrowserName(){
        //Set by default
        String browserDefault = "headless";
        //mvn clean install -Dbrowser=safari
        String browserSentFromCmd = System.getProperty("browser");
        return browserSentFromCmd == null ? browserDefault : browserSentFromCmd;

    }


    @BeforeAll
    public void setupBrowser() {
        try {
            String browser = getBrowserName();
            driver = DriverFactory.getDriver("chrome");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Erro Initialization browser");

        }
    }


    @BeforeEach
    public void setupTest() {
        driver.get(Environment.URL);
    }


    @AfterEach
    public void teardown() {
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public void teardownClass() {
        driver.quit();
    }
}
