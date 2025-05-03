package com.example.bwappbdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HTMLInjectionPage {

    private final WebDriver driver;

    private final By firstNameInput = By.id("firstname");
    private final By lastNameInput = By.id("lastname");
    private final By submit = By.name("form");

    public HTMLInjectionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstNameAndLastName(String firstname, String lastname) {
        driver.findElement(firstNameInput).sendKeys(firstname);
        driver.findElement(lastNameInput).sendKeys(lastname);
        driver.findElement(submit).submit();
    }

    public boolean isHtmlInjectedDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(d -> d.findElement(By.tagName("b")).getText().equals("test_injection"));
    }

    public boolean isErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(d -> d.getPageSource().contains("Please enter both fields..."));
    }
}
