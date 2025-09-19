# 🏦 Système de Gestion de Comptes Bancaires

## 📌 Description du projet

Ce projet est une **application console développée en Java 8** permettant de gérer des comptes bancaires et leurs opérations.  
Il simule les fonctionnalités principales d’une banque : ouverture de comptes, versements, retraits, virements, consultation des soldes et historique des opérations.

Le projet respecte une architecture en couches afin de séparer la logique métier, la présentation et les utilitaires.

---

## ⚙️ Fonctionnalités principales

- Créer un compte (courant ou épargne)
- Effectuer un versement
- Effectuer un retrait
- Effectuer un virement entre comptes
- Consulter le solde du compte
- Consulter la liste des opérations effectuées sur un compte

---

## 🏗️ Structure du projet

- **Couche présentation (`presentation`)** : interface utilisateur (menu interactif dans la console)
- **Couche métier (`metier`)** : classes métier (compte, opérations, retraits, versements, etc.)
- **Couche utilitaire (`utilitaire`)** : validations (format du code compte, montants, etc.)

---

## 📚 Contenu des classes

### Classe abstraite `Compte`
- Attributs : `code`, `solde`, `listeOperations`
- Méthodes abstraites :
  - `retirer(Double montant, String destination)`
  - `calculerInteret()`
  - `afficherDetails()`

### Classe `CompteCourant` (hérite de `Compte`)
- Attribut supplémentaire : `decouvert`
- Pas d’intérêts (`calculerInteret() = 0`)
- Règle de retrait : solde ≥ `-découvert`

### Classe `CompteEpargne` (hérite de `Compte`)
- Attribut supplémentaire : `tauxInteret`
- `calculerInteret()` : calcule les intérêts selon le taux
- Règle de retrait : solde ≥ montant demandé

### Classe abstraite `Operation`
- Attributs : `numero (UUID)`, `date`, `montant`

### Classe `Versement` (hérite de `Operation`)
- Attribut supplémentaire : `source` 

### Classe `Retrait` (hérite de `Operation`)
- Attribut supplémentaire : `destination` 

---

## 🛠️ Technologies utilisées

- **Langage** : Java 8 (JDK 1.8)
- **IDE** : Eclipse
- **Gestion de version** : Git + GitHub
- **API Java utilisées** :
  - `java.util` (ArrayList, HashMap, UUID)
  - `java.time` (LocalDateTime pour les dates)
  - `java.util.regex` (Pattern pour la validation du code de compte)

---

