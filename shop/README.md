# Alten shop
 ## Description
Ce projet est une application Spring Boot de gestion des produits qui utilise une base de données PostgreSQL, configurée pour demarer avec Docker Compose.
 Un fichier JSON est également inclus pour charger des données de test dans Postman.

## Prérequis
- Java 17 : Pour exécuter l'application Spring Boot.
- Maven : Pour gérer les dépendances et le cycle de vie de projet.
- Docker et Docker Compose : Pour déployer la base de données PostgreSQL.

# Lancer l'Application
Démarrer la base de données PostgreSQL :
 dans le repertoir tools du projet lancer:  docker-compose up -d .

# Installer les dépendances et compiler l’application avec Maven 
1- Dans le répertoire du projet, exécutez :
   mvn clean install
2- Lancer l'application Spring Boot :
   mvn spring-boot:run
