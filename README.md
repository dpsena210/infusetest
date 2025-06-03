# API de Consulta de Créditos - Solução Técnica

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green.svg)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-20-orange.svg)](https://angular.io/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)](https://www.postgresql.org/)
[![Kafka](https://img.shields.io/badge/Apache%20Kafka-3.1-000000.svg)](https://kafka.apache.org/)
[![Flyway](https://img.shields.io/badge/Flyway-9-yellow.svg)](https://flywaydb.org/)
[![JUnit5](https://img.shields.io/badge/JUnit-5-brightgreen.svg)](https://junit.org/junit5/)

## 📋 Descrição
Solução completa para consulta de créditos com:
- **Backend**: Java +  Spring Boot 
- **Frontend**: Angular
- **Banco de Dados**: PostgreSQL + Flyway (migrations)
- **Mensageria**: Kafka
- **Testes unitários** : JUnit

## 🚀 Como Executar

### Pré-requisitos
- Docker 20+
- Docker Compose 2.1+

```bash
# 1. Clone o repositório
git clone https://github.com/seu-repo/credit-api.git
cd credit-api

# 2. Construa e inicie os containers
docker-compose up --build

# 3. Acesse:
echo "Frontend: http://localhost:80"
CURL "API: http://localhost:8152" (opicional)
echo "Kafka UI: http://localhost:8080 (opicional)"


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
Estrutura:
consulta-creditos/
    ├── src/main/
    │   ├── java/
    │   │   ├── config/      
    │   │   ├── events/   
    │   │   ├── controlers/
    │   │   ├── dtos/
    │   │   ├── mappers/
    │   │  ...  
    │   └── resources/
    │       ├── db.migrations/
    │       └── application.properties
    └── consulta-creditos-frontend
        │    
        ├─── src/app/
        │
       ...
```
          
