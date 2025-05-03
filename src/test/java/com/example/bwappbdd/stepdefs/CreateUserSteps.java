package com.example.bwappbdd.stepdefs;

import com.example.bwappbdd.pages.CreateUserPage;
import com.example.bwappbdd.pages.PortalPage;
import com.example.bwappbdd.utils.AuthUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class CreateUserSteps {

    private WebDriver driver;
    private PortalPage portalPage;
    private CreateUserPage createUserPage;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        portalPage = new PortalPage(driver);
        createUserPage = new CreateUserPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("je suis connecté à bWAPP")
    public void je_suis_connecte_a_bwapp() {
        AuthUtils.loginToBWAPP(driver);
    }

    @Then("je vais sur la page de creation d'un nouvel utilisateur")
    public void je_vais_sur_la_page_new_user() {
        portalPage.goToCreateUserPage();
    }

    @When("je crée un utilisateur avec le login {string} et le mot de passe {string} avec le mail {string} et le secret {string}")
    public void je_cree_un_utilisateur(String login, String password, String email, String secret) {
        createUserPage.createUser(login, password, email, secret);
    }

    @When("je crée un utilisateur vide")
    public void je_cree_un_utilisateur_vide() {
        createUserPage.createUser("", "", "", "");
    }

    @Then("un message de réussite s'affiche")
    public void utilisateur_cree() {
        assertTrue(createUserPage.isSuccessMessageDisplayed());
    }

    @Then("un message erreur utilisateur déja existant doit s'afficher")
    public void erreur_utilisateur_existe_deja() {
        assertTrue(createUserPage.isAlreadyExistMessageDisplayed());
    }

    @Then("un message erreur pour champs vides doit s'afficher")
    public void erreur_utilisateur_champs_vides() {
        assertTrue(createUserPage.isAllBlankMessageDisplayed());
    }

    @When("je clique sur Reset")
    public void je_clique_sur_reset() {
        portalPage.resetApp();
    }

    @Then("je devrais être sur la page de reset")
    public void je_suis_sur_la_page_de_reset() {
        assertTrue(driver.getCurrentUrl().contains("reset.php"));
    }
}
