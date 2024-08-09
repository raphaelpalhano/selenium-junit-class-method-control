package com.webproject.selenium.tests;

import com.webproject.selenium.core.HookClass;
import com.webproject.selenium.core.HookMethod;
import com.webproject.selenium.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LoginPageTestCaseClass extends HookClass {

    @Test
    public void loginWithValidUser() {
        HomePage homePage = new HomePage(driver);
        homePage.login("valid");
        //Assertions.assertTrue(homePage.titleIsPresent());
    }


    @Test
    public void loginWithInvalidUser() {
        HomePage homePage = new HomePage(driver);
        homePage.login("invalid");

    }
}
