Feature: Création d’un utilisateur

  Background:
    Given je suis connecté à bWAPP
    And je vais sur la page de creation d'un nouvel utilisateur

  Scenario: Création réussie d’un nouvel utilisateur
    When je crée un utilisateur avec le login "testuser" et le mot de passe "test123" avec le mail "testuser@hotmail.fr" et le secret "test"
    Then un message de réussite s'affiche

  Scenario: Échec de création d’un utilisateur existant
    When je crée un utilisateur avec le login "testuser" et le mot de passe "test123" avec le mail "testuser@hotmail.fr" et le secret "test"
    Then un message erreur utilisateur déja existant doit s'afficher

  Scenario: Échec de création avec les champs vide
    When je crée un utilisateur vide
    Then un message erreur pour champs vides doit s'afficher

  Scenario: Je reset les données de l'application
    When je clique sur Reset
    Then je devrais être sur la page de reset
