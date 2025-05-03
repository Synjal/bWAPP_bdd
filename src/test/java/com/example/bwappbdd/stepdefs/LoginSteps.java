package com.example.bwappbdd.stepdefs;

import com.example.bwappbdd.pages.LoginPage;
import com.example.bwappbdd.pages.PasswordChangePage;
import com.example.bwappbdd.pages.PortalPage;
import com.example.bwappbdd.utils.AuthUtils;
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
    private PasswordChangePage passwordChangePage;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        portalPage = new PortalPage(driver);
        passwordChangePage = new PasswordChangePage(driver);
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

    @Then("je devrais voir un message de réussite")
    public void je_devrais_voir_un_message_de_reussite() {
        assertTrue(passwordChangePage.isPasswordChangeSuccess());
    }

    @Given("je suis connecté à bWAPP avec les identifiants valides")
    public void je_suis_connecte_a_bwapp_avec_les_identifiants_valides() {
        AuthUtils.loginToBWAPP(driver);
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
        portalPage.goToChangePasswordPage();
        passwordChangePage.changePassword(oldPass, newPass);
    }

    @When("je change le niveau de sécurité à {string}")
    public void je_change_niveau(String level) {
        portalPage.changeSecurityLevel(level);
    }

    @Then("le niveau de sécurité est {string}")
    public void le_niveau_de_securite_est(String level) {
        assertTrue(portalPage.securityLevelIs(level));
    }
}
