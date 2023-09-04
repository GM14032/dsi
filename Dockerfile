FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -DskipTests

FROM openjdk:17.0.2-oracle

COPY --from=build /app/target/dsi.jar /app/app.jar

# Establecemos el directorio de trabajo
WORKDIR /app

# Exponemos el puerto
EXPOSE 8080

# Puedes configurar las variables de entorno aquí si es necesario
# ENV DB_USERNAME=valor_predeterminado

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
