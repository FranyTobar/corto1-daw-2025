# Usar una imagen base de Java
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el wrapper de Maven y el archivo pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copiar el código fuente
COPY src ./src

# Compilar la aplicación usando el wrapper de Maven y omitir las pruebas
RUN ./mvnw clean package -DskipTests

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["./mvnw", "spring-boot:run"]    