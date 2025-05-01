Feature: Authentification et Accès

  Background:
    Given je suis sur la page de login

  Scenario: Connexion réussie
    When je remplis "login" avec "bee"
    And je remplis "password" avec "bug"
    And je clique sur le bouton "Login"
    Then je suis sur la page d'accueil

  Scenario: Connexion échouée
    When je remplis "login" avec "abc"
    And je remplis "password" avec "abc"
    And je clique sur le bouton "Login"
    Then le message d'erreur "invalid credentials" s'affiche
    And je suis sur la page de login

