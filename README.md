# Selenium web test project

## Instance class

~~~java
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

~~~

## Instance method

~~~java

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class HookMethod {

    protected static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HookMethod.class);


    private static String getBrowserName(){
        //Set by default
        String browserDefault = "headless";
        //mvn clean install -Dbrowser=safari
        String browserSentFromCmd = System.getProperty("browser");
        return browserSentFromCmd == null ? browserDefault : browserSentFromCmd;

    }


    @BeforeEach
    public  void setupBrowser() {
        try {
            String browser = getBrowserName();
            driver = DriverFactory.getDriver("chrome");
            driver.get(Environment.URL);


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Erro Initialization browser");

        }
    }



    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
~~~
