package com.example.bwappbdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordChangePage {

    private final WebDriver driver;

    private final By currentPassword = By.id("password_curr");
    private final By newPassword = By.id("password_new");
    private final By confirmPassword = By.id("password_conf");
    private final By changePasswordSubmit = By.name("action");
    private final By changePasswordSuccesMessage = By.xpath("//*[@id=\"main\"]/font");

    public PasswordChangePage(WebDriver driver) {
        this.driver = driver;
    }

    public void changePassword(String oldPass, String newPass) {
        driver.findElement(currentPassword).sendKeys(oldPass);
        driver.findElement(newPassword).sendKeys(newPass);
        driver.findElement(confirmPassword).sendKeys(newPass);
        driver.findElement(changePasswordSubmit).click();
    }

    public boolean isPasswordChangeSuccess() {
        return driver.findElement(changePasswordSuccesMessage).getText().trim().equalsIgnoreCase("The password has been changed!");
    }
}
