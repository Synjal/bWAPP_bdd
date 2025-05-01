package com.example.bwappbdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalPage {

    String page_url = "http://localhost/portal.php";
    private final WebDriver driver;

    private final By logoutLink = By.xpath("//*[@id=\"menu\"]/table/tbody/tr/td[8]/a");
    private final By changePasswordLink = By.xpath("/*[@id=\"menu\"]/table/tbody/tr/td[2]/a");
    private final By securityLevelSelect = By.name("security_level");
    private final By securitySubmit = By.name("form_security_level");

    public PortalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPortalPage() {
        driver.get(page_url);
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }

    public void changePassword(String oldPass, String newPass) {
        driver.findElement(By.name("password_old")).sendKeys(oldPass);
        driver.findElement(By.name("password_new")).sendKeys(newPass);
        driver.findElement(By.name("password_conf")).sendKeys(newPass);
        driver.findElement(By.name("form")).click();
    }

    public void changeSecurityLevel(String level) {
        WebElement select = driver.findElement(securityLevelSelect);
        select.sendKeys(level);
        driver.findElement(securitySubmit).click();
    }
}
