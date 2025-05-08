# 💸 Desafio Itaú - API REST de Transações

Este projeto é uma solução para o desafio técnico proposto pelo Itaú, com o objetivo de construir uma API REST em Java utilizando **Spring Boot**, que registre transações financeiras e calcule estatísticas com base nas transações dos **últimos 60 segundos**.

---

## 🔧 Tecnologias utilizadas

- Java 17
- Spring Boot
- Maven
- API REST (HTTP + JSON)
- Armazenamento em memória (sem banco de dados)
- JUnit (opcional para testes)

---

## 📂 Estrutura do projeto

src/
└── main/
└── java/
└── DesafioItau/
└── springboot/
├── controller/ → Endpoints da API
├── dto/ → Objetos de transporte de dados
├── model/ → Representação das entidades
├── service/ → Lógica de negócio e regras
└── SpringbootApplication.java

yaml
Copy
Edit

---

## 🔁 Endpoints

### `POST /transacao`
Registra uma nova transação.

#### Corpo da requisição (JSON):
```json
{
  "valor": "100.00",
  "dataHora": "2025-05-08T15:00:00Z"
}
```
Respostas:
201 Created: Transação aceita.

204 No Content: Transação antiga (fora da janela de 60s).

400 Bad Request: JSON inválido.

422 Unprocessable Entity: Valor negativo ou data futura.

GET /estatistica
Retorna estatísticas das transações nos últimos 60 segundos.

Resposta:
json
Copy
Edit
{
  "soma": 200.00,
  "media": 100.00,
  "max": 150.00,
  "min": 50.00,
  "count": 2
}
DELETE /transacao
Remove todas as transações armazenadas.

Resposta:
200 OK

