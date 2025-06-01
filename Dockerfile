# Usa imagem base com Java 21
FROM eclipse-temurin:21-jdk

# Define diretório de trabalho no container
WORKDIR /app

# Copia o JAR da aplicação para dentro do container
COPY build/libs/consulta-creditos-backend-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta configurada na aplicação
EXPOSE 8152

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
