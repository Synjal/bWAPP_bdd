Feature: Faille injection SQL en GET

  Background:
    Given je suis bien connecté à bWAPP
    And je vais sur la page HTML Injection Reflected GET

  Scenario: Injection HTML dans les champs first name et last name
    When je saisis le prénom "<b>test_injection</b>" et le nom "Doe"
    Then le contenu HTML injecté doit être interprété


  Scenario: Tentative avec les deux champs vides
    When je saisis le prénom "" et le nom ""
    Then il y a un message d'erreur
