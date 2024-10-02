# Usa OpenJDK como imagen base
FROM openjdk:17

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo .jar desde el directorio de construcción al contenedor
COPY build/libs/unimarket-1.0-SNAPSHOT.jar app.jar

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
