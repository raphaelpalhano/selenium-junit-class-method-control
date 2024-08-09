package com.webproject.selenium.constants;

import java.io.File;

public class Environment {
    public static final String URL = "https://parabank.parasoft.com/parabank/index.htm";
    public static final String STATIC_DATA = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "test" + File.separator + "resources" + File.separator + "static" + File.separator;
}
