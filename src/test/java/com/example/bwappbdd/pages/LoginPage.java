package com.example.bwappbdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameInput = By.id("login");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.name("form");

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
        return driver.getPageSource().contains("Invalid credentials");
    }
} 
