# API de Fórum Alura

Este projeto é uma API REST desenvolvida para um fórum, permitindo autenticação de usuários, criação e gerenciamento de tópicos. A API foi construída com princípios SOLID, utilizando as seguintes tecnologias:

- **Spring Boot** para a estrutura da aplicação.
- **Spring Security** e **JWT** para segurança e autenticação de usuários.
- **Spring Data JPA** para acesso e manipulação de dados.
- **PostgreSQL** como banco de dados relacional.
- **Validation** para validação de dados de entrada.
- **DevTools** para facilitar o desenvolvimento.
- **Lombok** para reduzir a quantidade de código boilerplate.

As rotas foram implementadas para gerenciar usuários e tópicos de forma eficiente.

## Funcionalidades

- **Autenticação de usuários** (POST)
- **Listar usuários** (GET)
- **Cadastro de usuários** (POST)
- **Criar tópicos** (POST)
- **Listar tópicos** (GET)
- **Listar tópicos por ID** (GET)
- **Atualizar tópicos** (PUT)
- **Deletar tópicos** (DELETE)

## Rotas da API

Aqui estão as rotas disponíveis na API:

### 1. **POST /login**  
**Descrição:** Autentica o usuário e retorna um token JWT.  
**JSON de requisição:**  
```json
{
  "login": "admin@email.com",
  "senha": "123456"
}

```
### 2. POST /usuarios
**Descrição:** Registra um novo usuário.  
**JSON de requisição:**  
```json
{
  "nome": "kani3",
  "email": "kani3@email.com",
  "senha": "1234567"
}
```
### 3. GET /usuarios
Descrição: Lista todos os usuários registrados.
Resposta JSON:

```json

{
  "id": 1,
  "nome": "kani",
  "email": "kani@email.com"
}
```

### 4. POST /topicos
Descrição: Cria um novo tópico no fórum.
JSON de requisição:

```json

{
  "titulo": "titulo3",
  "mensagem": "mensagem3",
  "datacriacao": "2025-05-19T19:00",
  "curso": "HTML",
  "autorId": 2
}
```

### 5. GET /topicos
Descrição: Lista todos os tópicos registrados, com paginação.
Resposta JSON:

```json

{
  "content": [
    {
      "id": 1,
      "titulo": "titulo",
      "mensagem": "mensagem",
      "data": "2025-05-15T19:00:00"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "empty": false,
      "unsorted": false,
      "sorted": true
    },
    "offset": 0,
    "unpaged": false,
    "paged": true
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 1,
  "size": 10,
  "number": 0,
  "first": true,
  "numberOfElements": 1,
  "empty": false
}
```

### 6. GET /topicos/{id}
Descrição: Lista um tópico específico pelo ID.
Resposta JSON (Exemplo para ID = 4):

```json

{
  "id": 4,
  "titulo": "teste2",
  "mensagem": "teste2",
  "dataCriacao": "2025-05-19T19:00:00",
  "curso": "HTML",
  "autor": {
    "id": 2,
    "nome": "kani2",
    "email": "kani2@email.com",
    "senha": "1234567"
  }
}
```
### 7. PUT /topicos
Descrição: Atualiza um tópico existente.
JSON de requisição:

```json

{
  "id": 4,
  "titulo": "teste2",
  "mensagem": "teste2"
}
```
### 8. DELETE /topicos/{id}
Descrição: Deleta um tópico pelo ID.
Resposta JSON:
Status HTTP 200 (OK) se a exclusão for bem-sucedida.


## Como os usuários podem utilizá-lo

1. Clone este repositório em sua máquina local.
2. Certifique-se de que você tenha o Java e o Spring Boot instalados.
3. Configure o banco de dados PostgreSQL no arquivo `application.properties` com as credenciais adequadas.
4. Compile e execute o arquivo `ApiForumApplication.java` no seu terminal.
5. A aplicação usará Spring Security para autenticação com JWT.
6. A interação é feita via API com as rotas configuradas para cada funcionalidade descrita.

Para suporte e mais informações sobre como usar o projeto, consulte a documentação neste repositório ou abra uma issue no GitHub para relatar problemas ou sugerir melhorias.

## Autores

- **Emanuel dos Santos Kanetchny** - Desenvolvedor principal

![Badge Desenvolvido](http://img.shields.io/static/v1?label=STATUS&message=%20DESENVOLVIDO&color=GREEN&style=for-the-badge)
