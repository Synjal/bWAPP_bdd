package com.example.bwappbdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameInput = By.id("login");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.name("form");
    private final By loginErrorMessage = By.xpath("//*[@id='main']/font");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.get("http://localhost/login.php");
    }

    public void login(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoggedIn() {
        return driver.getCurrentUrl().equals("http://localhost/portal.php");
    }

    public boolean isLoginError() {
        try {
            String errorText = driver.findElement(loginErrorMessage).getText().toLowerCase();
            return errorText.contains("invalid");
        } catch (Exception _) {
            return false;
        }
    }
}
