# Alten shop
 ## Description
Ce projet est une application Spring Boot de gestion des produits qui utilise une base de données PostgreSQL, configurée pour demarer avec Docker Compose.
 Un fichier JSON est également inclus pour charger des données de test dans Postman.

## Prérequis
- Java 17 : Pour exécuter l'application Spring Boot.
- Maven : Pour gérer les dépendances et le cycle de vie de projet.
- Docker et Docker Compose : Pour déployer la base de données PostgreSQL.

# Lancer l'Application
Pour démarrer la base de données PostgreSQL, rendez-vous dans le répertoire tools du projet et lancez la commande suivante : docker-compose up -d .

# Installer les dépendances et compiler l’application avec Maven 
1- Dans le répertoire du projet, lancez la commande suivante :
   mvn clean install
2- Lancer l'application Spring Boot :
   mvn spring-boot:run

# Tester l'API via Postman
Pour tester les endpoints de cette API avec Postman : Importer la collection "api-products.postman-test.json" de projet dans Postman 
