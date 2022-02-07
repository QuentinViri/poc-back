# Bienvenue sur le backend de notre projet POC CRA
@Author Valentin Descomps, Quentin Viricel, Aymeric Faure
------------


> **Avant de lancer le serveur back, il faut créer un schéma mysql (dans notre projet, il s'appelle "pocdb") et vérifier la configuration dans application.properties.**
------------
- Notre application utilise les dépendances suivantes :
  - spring security
  - spring web
  - spring data jpa
  - lombok
  - my sql
  - JWT
------------
- la partie sécurité en JWT est gérée dans les dossiers "Security" et "payload" avec :
  - une partie qui gère le JWT (l'authentification et la génération du Bearer Token)
  - une partie "services" qui permet de charger l'utilisateur avec son username & password
  - un fichier WebSecurityConfig qui fournit des configurations HttpSecurity pour configurer les cors, csrf, la gestion des sessions, les règles pour les ressources protégées
  - un dossier payload qui gère les requêtes de connexion et d'enregistrement des users
------------
- le backend se base sur :
  - des modèles qui définissent les différents objets/tables de notre application
  - des repository qui permettent de lier la bdd au backend
  - des services qui définissent les différentes méthodes de traitement de nos objets
  - des controllers qui permettent de créer des endpoints afin d'exposer l'api
