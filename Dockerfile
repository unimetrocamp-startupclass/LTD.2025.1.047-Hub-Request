FROM maven:3.9-eclipse-temurin-21-alpine

WORKDIR /app

# Copia tudo
COPY . .

# Porta de exposição
EXPOSE 5001

# Usa o comando que permite hot reload com Spring Boot DevTools
CMD ["mvn", "spring-boot:run"]
