# API de Consulta de Créditos - Solução Técnica

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green.svg)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-20-orange.svg)](https://angular.io/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)](https://www.postgresql.org/)
[![Kafka](https://img.shields.io/badge/Apache%20Kafka-000000.svg)](https://kafka.apache.org/)
[![Flyway](https://img.shields.io/badge/Flyway-yellow.svg)](https://flywaydb.org/)
[![JUnit5](https://img.shields.io/badge/JUnit-brightgreen.svg)](https://junit.org/junit5/)
[![Mockito](https://img.shields.io/badge/Mockito-lightgrey.svg)](https://site.mockito.org/)


## 📋 Descrição
Solução completa para consulta de créditos com:
- **Backend**: Java +  Spring Boot 
- **Frontend**: Angular
- **Banco de Dados**: PostgreSQL + Flyway (migrations)
- **Mensageria**: Kafka
- **Testes unitários** : JUnit, Mockito

## 🚀 Como Executar

### Pré-requisitos
- Docker 20+
- Docker Compose 2.1+

```bash
# 1. Clone o repositório
git clone  https://github.com/dpsena210/infusetest.git
cd infusetest

# 2. Construa e inicie os containers
docker-compose up --build

# 3. Acesse:

echo "Frontend: http://localhost:80"
echo "API:      http://localhost:8152"
echo "Kafka UI: http://localhost:8080"



```

## Endpoints da API

Abaixo estão os principais endpoints disponíveis na API, com o método HTTP, descrição e exemplos práticos de uso via `curl`.

| Método | Endpoint                         | Descrição                               | Exemplo                                                                     |
|--------|---------------------------------|---------------------------------------|-----------------------------------------------------------------------------|
| GET    | `/api/creditos`                 | Lista todos os créditos                | ```bash<br>curl -u dan:123 http://localhost:8152/api/creditos<br>```        |
| GET    | `/api/creditos/{numeroNfse}`   | Consulta créditos pelo número da NFSe | ```bash<br>curl -u dan:123 http://localhost:8152/api/creditos/NF001<br>```  |
| GET    | `/api/credito/{numeroCredito}` | Consulta crédito pelo número do crédito | ```bash<br>curl -u dan:123 http://localhost:8152/api/credito/CR10001<br>``` |

---

```
consulta-creditos/
├── src/main/
│   ├── java/
│   │   ├── config/         
│   │   ├── controllers/    
│   │   ├── dtos/           
│   │   ├── mappers/        
│   │   ├── services/       
│   │   ├── repositories/   
│   │   └── events/         
│   └── resources/
│       ├── db.migrations/  
│       └── application.properties  
└── consulta-creditos-frontend/
    └── src/app/
        ├── components/     
        ├── services/       
        ├── models/         
        └── pages/          

```

## 🧪 Testes unitários

### Rode os testes com o Gradle Wrapper:

#### Linux/macOS:
```bash
./gradlew test
```
#### Windows

```bash
gradlew test

```
