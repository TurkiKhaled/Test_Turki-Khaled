 # **API Spring Boot - Gestion des Utilisateurs**

## **Description du projet**
Cette API Spring Boot permet de gérer des utilisateurs avec des règles spécifiques, notamment la validation de la résidence en France et de la majorité (18 ans et plus). L'API expose deux endpoints principaux : 
- **Création d'un utilisateur**.
- **Récupération des détails d'un utilisateur**.

Elle utilise une base de données H2 embarquée pour simplifier l'installation et le test, et inclut des fonctionnalités de **AOP** pour enregistrer les entrées, sorties et temps de traitement des appels API.

---

## **Prérequis**
Avant de commencer, assurez-vous que vous avez les éléments suivants installés sur votre machine :

- **Java 17** ou une version plus récente.
- **Maven 3.6** ou une version plus récente.
- **Postman** (facultatif) pour tester les endpoints.
- **Git** pour cloner le projet.

---

## **Installation**

### **Cloner le projet**
Commencez par cloner ce projet depuis GitHub :
```bash
git clone <https://github.com/TurkiKhaled/Test_Turki-Khaled.git>
cd <test>
```

## **Structure de l'API**
L'API expose plusieurs endpoints pour interagir avec les utilisateurs. Voici les détails des endpoints principaux.

# **API Spring Boot - Gestion des Utilisateurs**

## **1. Créer un utilisateur**

- **URL** : `/api/users/register`
- **Méthode HTTP** : `POST`
- **Description** : Ce point d'entrée permet de créer un utilisateur en validant les données d'entrée. Seuls les utilisateurs résidents en France et âgés de plus de 18 ans peuvent créer un compte.

### **Paramètres attendus** :
- `username` (String) : Nom d'utilisateur (obligatoire, unique).
- `birthdate` (Date) : Date de naissance (obligatoire, format `yyyy-MM-dd`, l'utilisateur doit avoir plus de 18 ans).
- `phoneNumber` (String) : Numéro de téléphone (facultatif, doit être au format international français `+33`).
- `gender` (String) : Sexe de l'utilisateur (facultatif, peut être `male`, `female`, ou `other`).
- `country` (String) : Pays de résidence (obligatoire, doit être `France`).

### **Exemple de requête** :
```json
{
  "username": "Khaled Turki",
  "birthdate": "2000-05-15",
  "phoneNumber": "+33612345678",
  "gender": "male",
  "country": "France"
}
```

## 2. Afficher les détails d'un utilisateur

### URL
`/api/users/{id}`

### Méthode HTTP
`GET`

### Description
Cette API permet de récupérer les informations d'un utilisateur à partir de son ID.

### Paramètre attendu
- `id` (integer) : L'ID de l'utilisateur dont on souhaite récupérer les informations.

### Exemple de requête
```http
GET /api/users/1
```
### **Exemple de requête** :
```json
{
  "username": "Khaled Turki",
  "birthdate": "2000-05-15",
  "phoneNumber": "+33612345678",
  "gender": "male",
  "country": "France"
}
```

## **Tests**


### Tests unitaires (TU)
Des tests unitaires ont été mis en place pour vérifier que les composants individuels de l'API fonctionnent comme prévu. Ces tests incluent :

- **Vérification de la validation des entrées utilisateur** : Assure que les données envoyées dans les requêtes sont valides (format correct, présence des champs requis, etc.).
- **Test des méthodes de gestion des erreurs** : Vérifie que l'API retourne des erreurs appropriées dans des cas d'entrées invalides ou de comportements inattendus.

### Tests d'intégration (TI)
Les tests d'intégration assurent que l'API interagit correctement avec la base de données et d'autres services. Ces tests incluent :

- **Vérification que les données de l'utilisateur sont correctement récupérées à partir de la base de données** : Teste l'intégrité des interactions entre l'API et la base de données.
- **Vérification des réponses HTTP selon différents scénarios** : Assure que l'API retourne les bonnes réponses HTTP (par exemple, `200 OK` si l'utilisateur est trouvé, `404 Not Found` si l'utilisateur n'existe pas, etc.).
