package com.example.bwappbdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateUserPage {

    private final WebDriver driver;

    private final By usernameField = By.id("login");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By passwordConfirmField = By.id("password_conf");
    private final By secretField = By.id("secret");
    private final By submitButton = By.name("action");
    private final By message = By.xpath("//*[@id=\"main\"]/font");

    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createUser(String username, String password, String email, String secret) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordConfirmField).sendKeys(password);
        driver.findElement(secretField).sendKeys(secret);
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(message).getText().trim().equalsIgnoreCase("User successfully created!");
    }

    public boolean isAlreadyExistMessageDisplayed() {
        return driver.findElement(message).getText().trim().equalsIgnoreCase("The login or e-mail already exists!");
    }

    public boolean isAllBlankMessageDisplayed() {
        return driver.findElement(message).getText().trim().equalsIgnoreCase("Please enter all the fields!");
    }
}
