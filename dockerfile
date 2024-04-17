FROM ubuntu

RUN apt-get update && apt-get install -y openjdk-17-jdk maven

WORKDIR ./app

# Copie des fichiers sources Java et du fichier pom.xml dans le conteneur
COPY ./src ./src
COPY ./pom.xml .



# Compilation et exécution du projet Maven
RUN mvn install

CMD ["java", "-jar", "target/Projet-1.0-SNAPSHOT.jar"]