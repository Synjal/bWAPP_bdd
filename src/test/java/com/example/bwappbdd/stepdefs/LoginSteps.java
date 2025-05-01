package com.example.bwappbdd.stepdefs;

import com.example.bwappbdd.pages.LoginPage;
import com.example.bwappbdd.pages.PortalPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private PortalPage portalPage;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("je suis sur la page de login")
    public void je_suis_sur_la_page_de_login() {
        loginPage.goToLoginPage();
    }

    @When("je me connecte avec l'identifiant {string} et le mot de passe {string}")
    public void je_me_connecte(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("je devrais être connecté")
    public void je_devrais_etre_connecte() {
        assertTrue(loginPage.isLoggedIn());
    }

    @Then("je devrais voir une erreur de connexion")
    public void je_devrais_voir_une_erreur() {
        assertTrue(loginPage.isLoginError());
    }

    @Given("je suis connecté à bWAPP avec les identifiants valides")
    public void je_suis_connecte_a_bwapp() {
        loginPage.goToLoginPage();
        loginPage.login("bee", "bug");
        assertTrue(loginPage.isLoggedIn());
    }

    @When("je me déconnecte")
    public void je_me_deconnecte() {
        portalPage.logout();
    }

    @Then("je devrais être redirigé vers la page de login")
    public void je_devrais_etre_sur_la_page_login() {
        assertTrue(driver.getCurrentUrl().contains("login.php"));
    }

    @When("je change mon mot de passe de {string} à {string}")
    public void je_change_mdp(String oldPass, String newPass) {
        loginPage.goToChangePasswordPage();
        portalPage.changePassword(oldPass, newPass);
    }

    @When("je change le niveau de sécurité à {string}")
    public void je_change_niveau(String level) {
        portalPage.goToSecurityPage();
        portalPage.changeSecurityLevel(level);
    }
}
