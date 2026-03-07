# ForumHub 📚💻

Projeto desenvolvido como parte do desafio da **Alura** para criar uma API REST em **Java com Spring Boot**.  
O objetivo é implementar um fórum de discussão com autenticação segura, CRUD de tópicos e boas práticas de desenvolvimento.

---

## 🚀 Tecnologias utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Security** (JWT para autenticação)
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Maven**

---

## ⚙️ Funcionalidades
- **Autenticação de usuários** com JWT.
- **CRUD de Tópicos**:
    - Criar novo tópico (`POST /topicos`)
    - Listar tópicos (`GET /topicos`)
    - Detalhar tópico (`GET /topicos/{id}`)
    - Atualizar tópico (`PUT /topicos/{id}`)
    - Excluir tópico (`DELETE /topicos/{id}`)
- Proteção de rotas com autenticação.
- Persistência dos dados em banco relacional (PostgreSQL).

---

## 📂 Estrutura do projeto

```bash
src/
 ├── main/
 │   ├── java/br/com/alura/forumhub/
 │   │   ├── controller/    # Controllers da API
 │   │   ├── entity/        # Entidades JPA
 │   │   ├── dto/           # Data Transfer Objects
 │   │   ├── repository/    # Interfaces de acesso ao banco
 │   │   └── security/      # Configuração de autenticação JWT
 │   └── resources/
 │       └── application.properties  # Configurações do projeto
 └── test/                  # Testes automatizados
```


---
## 🔑 Autenticação
A API utiliza **JWT** para autenticação.
- Para obter o token: `POST /login` com email e senha.
- O token deve ser enviado no header das requisições:


---

## 🛠️ Como executar
1. Clone o repositório:
 ```bash
 git clone https://github.com/brnvieira92/desafio-forumhub.git
```
---
## Configure o banco PostgreSQL no arquivo application.properties:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/forumhub
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
1 - Execute o projeto: mvn spring-boot:run
2 - Acesse a API em: http://localhost:8080