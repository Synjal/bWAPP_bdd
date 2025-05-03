package com.example.bwappbdd.utils;

import com.example.bwappbdd.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class AuthUtils {
    public static void loginToBWAPP(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login("bee", "bug");
        assertTrue(loginPage.isLoggedIn());
    }
}
