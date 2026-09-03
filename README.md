# API de Beneficiários

API REST desenvolvida em Java com Spring Boot para gerenciamento de beneficiários e seus documentos.

O projeto foi desenvolvido com separação de responsabilidades, utilizando uma arquitetura em camadas, persistência com JPA/Hibernate e autenticação e autorização utilizando Spring Security e JWT.

## Tecnologias utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Spring Security
* JWT
* BCrypt
* H2 Database
* Maven
* Lombok
* Springdoc OpenAPI / Swagger

## Funcionalidades

A aplicação possui as seguintes funcionalidades:

* Cadastro de beneficiário com seus documentos;
* Listagem de beneficiários;
* Consulta dos documentos de um beneficiário;
* Atualização de beneficiário;
* Remoção de beneficiário;
* Autenticação utilizando JWT;
* Autorização baseada em roles;
* Criptografia de senhas utilizando BCrypt;
* Persistência dos dados utilizando banco H2;
* Documentação da API utilizando Swagger/OpenAPI.

## Autenticação e autorização

A aplicação utiliza **Spring Security** para controle de acesso e **JWT (JSON Web Token)** para autenticação.

O fluxo de autenticação funciona da seguinte forma:

1. O usuário realiza o login informando suas credenciais.
2. As credenciais são autenticadas pelo Spring Security.
3. Após a autenticação, a aplicação gera um token JWT.
4. O token deve ser enviado nas requisições protegidas através do header `Authorization`.
5. O filtro JWT intercepta a requisição e valida o token.
6. Após a validação, as informações do usuário e sua role são adicionadas ao contexto de segurança.
7. O Spring Security verifica se o usuário possui a permissão necessária para acessar o recurso.

As senhas dos usuários são armazenadas utilizando **BCrypt**.

Exemplo do header utilizado nas requisições autenticadas:

```text
Authorization: Bearer SEU_TOKEN_JWT
```

## Banco de dados

A aplicação utiliza o **H2 Database** para persistência dos dados.

O banco está configurado no arquivo:

```text
src/main/resources/application.yml
```

O Hibernate está configurado para atualizar automaticamente o schema do banco durante a execução da aplicação.

O console do H2 pode ser acessado através de:

```text
http://localhost:8080/beneficiario/api/h2-console
```

## Swagger / OpenAPI

A API possui documentação utilizando **Swagger/OpenAPI**.

Com a aplicação em execução, a interface do Swagger pode ser acessada através de:

```text
http://localhost:8080/beneficiario/api/swagger-ui.html
```

A especificação OpenAPI também pode ser acessada através de:

```text
http://localhost:8080/beneficiario/api/v3/api-docs
```

O Swagger permite visualizar os endpoints disponíveis e testar as requisições da API.

## Pré-requisitos

Para executar o projeto, é necessário possuir instalado:

* JDK 17 ou superior;
* Maven;
* Git.

Verifique as versões instaladas:

```bash
java -version
mvn -version
```

## Executando o projeto

Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

Entre no diretório do projeto:

```bash
cd <NOME_DO_PROJETO>
```

Execute a aplicação utilizando o Maven:

```bash
mvn spring-boot:run
```

A aplicação será iniciada na porta `8080`.

Como o projeto utiliza o context path:

```text
/beneficiario/api
```

os endpoints estarão disponíveis a partir de:

```text
http://localhost:8080/beneficiario/api
```

## Build da aplicação

Para gerar o build do projeto, execute:

```bash
mvn clean package
```

Esse comando irá:

* limpar os arquivos gerados anteriormente;
* compilar o projeto;
* executar os testes;
* gerar o arquivo `.jar`.

O arquivo gerado estará no diretório:

```text
target/
```

Caso seja necessário gerar o build sem executar os testes:

```bash
mvn clean package -DskipTests
```

## Executando o JAR

Após gerar o build, a aplicação pode ser executada através do comando:

```bash
java -jar target/<nome-do-arquivo>.jar
```

Após a inicialização, a API estará disponível em:

```text
http://localhost:8080/beneficiario/api
```

## Endpoints

Os endpoints disponíveis na aplicação podem ser consultados através do Swagger:

```text
http://localhost:8080/beneficiario/api/swagger-ui.html
```

As rotas protegidas exigem um token JWT válido.

## Objetivo do projeto

Este projeto foi desenvolvido como avaliação técnica com o objetivo de demonstrar conhecimentos em desenvolvimento de APIs REST utilizando Java e Spring Boot, incluindo:

* desenvolvimento de APIs REST;
* arquitetura em camadas;
* persistência de dados com JPA/Hibernate;
* relacionamento entre entidades;
* DTOs;
* autenticação e autorização;
* Spring Security;
* JWT;
* BCrypt;
* documentação com Swagger/OpenAPI;
* gerenciamento de dependências e build utilizando Maven.
