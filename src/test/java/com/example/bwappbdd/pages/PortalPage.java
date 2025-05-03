package com.example.bwappbdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PortalPage {

    private final WebDriver driver;

    private final By logoutLink = By.xpath("//*[@id=\"menu\"]/table/tbody/tr/td[8]/a");
    private final By changePasswordLink = By.xpath("//*[@id=\"menu\"]/table/tbody/tr/td[2]/a");
    private final By createUserLink = By.xpath("//*[@id=\"menu\"]/table/tbody/tr/td[3]/a");
    private final By resetLink = By.xpath("//*[@id=\"menu\"]/table/tbody/tr/td[5]/a");
    private final By securityLevel = By.xpath("//*[@id=\"security_level\"]/form/font/b");
    private final By securityLevelSelect = By.name("security_level");
    private final By securitySubmit = By.name("form_security_level");

    public PortalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToChangePasswordPage() {
        driver.findElement(changePasswordLink).click();
    }

    public void goToCreateUserPage() {
        driver.findElement(createUserLink).click();
    }

    public void goToHtmlInjectionReflectedGet() {
        WebElement select = driver.findElement(By.name("bug"));
        Select dropdown = new Select(select);
        dropdown.selectByValue("2");

        driver.findElement(By.name("form")).click();
    }

    public void resetApp() {
        driver.findElement(resetLink).click();
        driver.switchTo().alert().accept();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getCurrentUrl().contains("reset.php"));
    }

    public void logout() {
        driver.findElement(logoutLink).click();
        driver.switchTo().alert().accept();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getCurrentUrl().contains("login.php"));
    }

    public void changeSecurityLevel(String level) {
        WebElement select = driver.findElement(securityLevelSelect);
        select.sendKeys(level);
        driver.findElement(securitySubmit).click();
    }

    public boolean securityLevelIs(String level) {
        return driver.findElement(securityLevel).getText().trim().equalsIgnoreCase(level);
    }
}
