# Étape 1 : Construction du projet
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copier les fichiers Maven
COPY pom.xml .
RUN mvn dependency:go-offline

# Copier le code source
COPY src ./src

# Compiler le projet et générer le JAR
RUN mvn clean package -DskipTests

# Étape 2 : Exécution de l'application
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copier le fichier JAR depuis l’étape de build
COPY --from=build /app/target/*.jar app.jar

# Exposer le port de ton application (par défaut 8080)
EXPOSE 8080

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
