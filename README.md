# TesteJava01 - Desafio de Desenvolvimento em Java com Spring Boot

## Introdução
Este é um desafio de desenvolvimento de uma API utilizando Spring Boot, com o objetivo de criar um sistema para gerenciar cadastros de servidores e lotações. Neste documento, serão descritas as funcionalidades esperadas e os requisitos para cada tipo de cadastro.

## Funcionalidades
A API deve oferecer as seguintes funcionalidades:

1. Cadastro de Servidor
2. Busca de servidor por matrícula
3. Cadastro de lotação
4. Consulta de lotação por nome

### Cadastro de Servidor
O cadastro de servidor deve incluir os seguintes campos:

- Nome: tipo string, campo obrigatório, tamanho máximo de 400 caracteres
- Matrícula: tipo string, campo obrigatório, tamanho máximo de 30 caracteres
- Data de Cadastro: tipo data
- Lotação: tipo Lotação, campo obrigatório

### Cadastro de Lotação
O cadastro de lotação deve incluir os seguintes campos:

- Descrição: tipo string, campo obrigatório, tamanho máximo de 200 caracteres

## Tecnologias Utilizadas
- Java
- Spring Boot
- Banco de dados (ex: MySQL, PostgreSQL, H2)

## Estrutura do Projeto
A estrutura do projeto pode ser organizada da seguinte forma:

