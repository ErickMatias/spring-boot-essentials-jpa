# 📚 Spring Boot JPA - API de Gerenciamento

Este projeto é uma aplicação backend desenvolvida com Spring Boot, com foco na construção de uma API REST e na persistência de dados utilizando JPA. A aplicação segue uma arquitetura em camadas, promovendo organização, escalabilidade e boas práticas de desenvolvimento.

## 🚀 Funcionalidades

* Operações completas de CRUD (Create, Read, Update, Delete)
* Gerenciamento de alunos
* Registro e consulta de avaliações físicas
* Integração com banco de dados relacional
* Consultas personalizadas com JPA (JPQL e queries nativas)

## 🔗 Endpoints da API

### 📌 Alunos

* `GET /alunos`
  Lista todos os alunos

* `GET /alunos/{id}`
  Busca um aluno pelo ID

* `POST /alunos`
  Cadastra um novo aluno

* `PUT /alunos/{id}`
  Atualiza os dados de um aluno

* `DELETE /alunos/{id}`
  Remove um aluno

---

### 📌 Avaliações Físicas

* `GET /avaliacoes`
  Lista todas as avaliações físicas

* `GET /avaliacoes/{id}`
  Busca uma avaliação pelo ID

* `POST /avaliacoes`
  Cadastra uma nova avaliação

* `PUT /avaliacoes/{id}`
  Atualiza uma avaliação

* `DELETE /avaliacoes/{id}`
  Remove uma avaliação

---

### 📌 Relacionamentos

* `GET /alunos/com-avaliacoes`
  Retorna alunos com suas respectivas avaliações físicas

* `GET /avaliacoes/aluno/{idAluno}`
  Lista avaliações de um aluno específico

## 🛠️ Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## 🎯 Objetivo

O objetivo deste projeto é consolidar conhecimentos em desenvolvimento backend com Java, incluindo a criação de APIs REST, manipulação de dados com JPA e integração com banco de dados relacional.

## 📚 Aprendizados

Durante o desenvolvimento deste projeto, foram trabalhados conceitos como:

* Mapeamento objeto-relacional (ORM)
* Criação e consumo de APIs REST
* Organização em camadas (Controller, Service, Repository)
* Boas práticas de desenvolvimento com Spring Boot
* Versionamento de código com Git

## 📌 Status do projeto

🚧 Em desenvolvimento / estudo

---

Projeto desenvolvido para fins de aprendizado em Spring Boot e JPA.
