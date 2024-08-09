package com.webproject.selenium.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);
    private static WebDriver driver = null;
    FirefoxOptions options = null;

    public static WebDriver getDriver(String browser) throws Exception {

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                logger.info("Chrome Browser invoked");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                logger.info("Firefox Browser invoked");
                break;
            case "headless":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=1200x600");
                driver = new ChromeDriver(options);
                logger.info("Headless Chrome Browser invoked");
                break;
            default:
                logger.fatal("No such browser is implemented.Browser name sent: " + browser);
                throw new Exception("No such browser is implemented.Browser name sent: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Driver maximized and implicit time out set to 10 seconds");
        return driver;

    }
}
