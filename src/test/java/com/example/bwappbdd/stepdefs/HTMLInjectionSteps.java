package com.example.bwappbdd.stepdefs;

import com.example.bwappbdd.pages.HTMLInjectionPage;
import com.example.bwappbdd.pages.PortalPage;
import com.example.bwappbdd.utils.AuthUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class HTMLInjectionSteps {

    private WebDriver driver;
    private PortalPage portalPage;
    private HTMLInjectionPage htmlInjectionPage;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        portalPage = new PortalPage(driver);
        htmlInjectionPage = new HTMLInjectionPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("je suis bien connecté à bWAPP")
    public void je_suis_bien_connecte_a_bwapp() {
        AuthUtils.loginToBWAPP(driver);
    }

    @Given("je vais sur la page HTML Injection Reflected GET")
    public void je_vais_sur_la_page_html_injection_reflected_get() {
        portalPage.goToHtmlInjectionReflectedGet();
    }

    @When("je saisis le prénom {string} et le nom {string}")
    public void je_saisis_le_prenom_et_le_nom(String prenom, String nom) {
        htmlInjectionPage.fillFirstNameAndLastName(prenom, nom);
    }

    @Then("le contenu HTML injecté doit être interprété")
    public void contenu_html_est_interprete() {
        assertTrue(htmlInjectionPage.isHtmlInjectedDisplayed());
    }

    @Then("il y a un message d'erreur")
    public void erreur_message() {
        assertTrue(htmlInjectionPage.isErrorMessageDisplayed());
    }
}
