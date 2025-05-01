package com.example.bwappbdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = http://localhost/portal.php
public class PortalPage {
    public PortalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}