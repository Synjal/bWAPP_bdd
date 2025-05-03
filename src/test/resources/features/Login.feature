Feature: Authentification bWAPP

  Rule: Utilisateur anonyme

    Background:
      Given je suis sur la page de login

    Scenario: Connexion réussie
      When je me connecte avec l'identifiant "bee" et le mot de passe "bug"
      Then je devrais être connecté

    Scenario: Connexion échouée
      When je me connecte avec l'identifiant "wrong" et le mot de passe "1234"
      Then je devrais voir une erreur de connexion

  Rule: Utilisateur connecté

    Background:
      Given je suis connecté à bWAPP avec les identifiants valides

    Scenario: Déconnexion après connexion
      When je me déconnecte
      Then je devrais être redirigé vers la page de login

    Scenario: Changement de mot de passe
      When je change mon mot de passe de "bug" à "bug"
      Then je devrais voir un message de réussite

    Scenario: Modifier le niveau de sécurité
      When je change le niveau de sécurité à "high"
      Then le niveau de sécurité est "high"
