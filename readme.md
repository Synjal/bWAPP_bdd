# bWAPP BDD Tests

Ce projet permet d'exécuter des **tests automatisés** sur l'application web **bWAPP** via **Selenium + Cucumber + Java**, dans un environnement **Dockerisé**.

---

## Prérequis

- Java 23
- Maven 3.8+
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) **(avec WSL2 activé si sur Windows)**

---

## Lancer le conteneur Docker bWAPP

Le projet contient un profil Maven permettant de lancer automatiquement le conteneur Docker bWAPP.

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

Pour lancer les test :

```bash
mvn test
