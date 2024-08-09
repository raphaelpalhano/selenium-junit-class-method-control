package com.webproject.selenium.pages;

import com.fasterxml.jackson.databind.JsonNode;
import com.webproject.selenium.utils.ManagerJson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class HomePage {

    private WebDriver driver;

    private final By username;
    private final By password;

    private final By submitButton;

    private final By titlePage;

    public HomePage(WebDriver driver) {
        this.username = By.cssSelector("input[name=\"username\"]");
        this.password = By.cssSelector("input[name=\"password\"]");
        this.submitButton = By.cssSelector("input[type=\"submit\"]");
        this.titlePage = By.cssSelector("div[id=\"showOverview\"] > h1");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String crendentialsConditional) {
        try {
            HashMap<String, String> user = new HashMap<String, String>(this.getUser(crendentialsConditional));
            driver.findElement(this.username).sendKeys(user.get("username"));
            driver.findElement(this.password).sendKeys(user.get("username"));
            driver.findElement(this.submitButton).click();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean titleIsPresent() {
        return driver.findElement(titlePage).isDisplayed();
    }


    private HashMap getUser(String crendentialsConditional) {
        HashMap<String,String> user = new HashMap();
        JsonNode userRead = ManagerJson.readJson("users.json");
        String username = userRead.get(crendentialsConditional).get("username").asText();
        String password = userRead.get(crendentialsConditional).get("password").asText();
        user.put("username", username);
        user.put("password", password);

        return user;
    }
}
