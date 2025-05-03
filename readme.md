# bWAPP BDD Tests

Projet de test en BDD pour le module BDD du Master M2i à MNS en 2025
Il permet d'exécuter des **tests automatisés** sur l'application web **bWAPP** via **Selenium + Cucumber + Java**.

---

## Prérequis

- Lancer Docker

---

## Lancer le conteneur Docker bWAPP

```bash
mvn exec:exec@run-docker-container
```

---

## Première utilisation

1. Rendez-vous sur la page d'[installation](http://localhost/install.php)
2. Cliquez sur "here" pour initialiser la base de données
3. Vous pouvez maintenant accéder à la [page d'accueil](http://localhost/login.php)

---

## Lancer les test

Les tests se lancent depuis le fichier test/java/RunCucumberTest
