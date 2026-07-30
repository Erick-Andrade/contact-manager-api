# Contact Manager API

API REST simples para gerenciamento de contatos, desenvolvida como projeto de estudo em Java + Spring Boot, aplicando os fundamentos de uma aplicação backend em camadas (Controller, Service, Repository).

## Tecnologias utilizadas

- Java 21
- Spring Boot 4.1
- Spring Data JPA
- H2 Database (banco em memória)
- Bean Validation
- JUnit 5 + Mockito
- Maven

## Funcionalidades

- Cadastro de contatos (nome, email, telefone)
- Listagem de todos os contatos
- Busca de contato por id
- Atualização de contato
- Remoção de contato
- Validação de dados de entrada
- Tratamento de erros customizado (404 para contato não encontrado)

## Como rodar o projeto

### Pré-requisitos
- Java 21 instalado
- Não é necessário ter Maven instalado, o projeto usa o Maven Wrapper

### Passos

```bash
# Clone o repositório
git clone https://github.com/Erick-Andrade/contact-manager-api.git

# Entre na pasta
cd contact-manager-api

# Rode a aplicação
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

### Acessando o banco H2 (opcional)

Com a aplicação rodando, acesse `http://localhost:8080/h2-console` e conecte com:
- **JDBC URL:** `jdbc:h2:mem:contactdb`
- **User Name:** `sa`
- **Password:** (em branco)

## Endpoints disponíveis

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/contacts` | Cria um novo contato |
| GET | `/contacts` | Lista todos os contatos |
| GET | `/contacts/{id}` | Busca um contato por id |
| PUT | `/contacts/{id}` | Atualiza um contato existente |
| DELETE | `/contacts/{id}` | Remove um contato |

### Exemplo de requisição (criar contato)

```bash
curl -X POST http://localhost:8080/contacts \
  -H "Content-Type: application/json" \
  -d '{"name":"João Silva","email":"joao@email.com","phone":"11999999999"}'
```

### Exemplo de resposta

```json
{
  "id": 1,
  "name": "João Silva",
  "email": "joao@email.com",
  "phone": "11999999999"
}
```

## Rodando os testes

```bash
./mvnw test
```

## Aprendizados deste projeto

Este foi o primeiro de uma série de projetos com o objetivo de consolidar fundamentos de backend em Java. Aqui, o foco foi:

- Estrutura em camadas (Controller → Service → Repository)
- Persistência com Spring Data JPA
- Validação de entrada com Bean Validation
- Tratamento centralizado de exceções (`@RestControllerAdvice`)
- Testes unitários com JUnit e Mockito, usando mocks para isolar a camada de negócio