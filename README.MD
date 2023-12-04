# Taverna App

O Taverna App é uma aplicação Java simples para gerenciar quartos de uma taverna. A aplicação utiliza o padrão de projeto MVC, Java JDBC para a conexão com o banco de dados e apresenta uma interface gráfica intuitiva.

## Configuração do Banco de Dados

### Pré-requisitos

- Servidor MySQL instalado e em execução.

### Passos para Configuração

1. **Criação do Banco de Dados:**
   - Abra o MySQL Workbench ou qualquer ferramenta de gerenciamento de banco de dados MySQL.
   - Execute o script `database.sql` para criar o banco de dados. Certifique-se de que o banco de dados tenha o nome `taverna`.

```sql
CREATE DATABASE taverna;
USE taverna;

CREATE TABLE room (
    id INT PRIMARY KEY AUTO_INCREMENT,
    room_type VARCHAR(255) NOT NULL
);
```

2. **Configuração de Conexão:**
   - Abra o arquivo `DBConnection.java` localizado no pacote `dao`.
   - Modifique as variáveis `USER` e `PASSWORD` de acordo com as credenciais do seu servidor MySQL.

```java
private static final String USER = "seuUsuario";
private static final String PASSWORD = "suaSenha";
```

## Configuração do Projeto no NetBeans

### Pré-requisitos

- NetBeans IDE instalado.

### Passos para Configuração

1. **Abertura do Projeto:**
   - Abra o NetBeans IDE.
   - Vá para "File" > "Open Project" e selecione o diretório do projeto.

2. **Configuração da Classe Principal:**
   - No projeto, clique com o botão direito e vá para "Properties".
   - Em "Run", configure a "Main Class" para `main.Main`.

## Execução do Projeto

1. **Compilação e Execução no NetBeans:**
   - Clique com o botão direito no projeto e escolha "Build" para compilar.
   - Execute o projeto.

2. **Execução a partir do JAR:**
   - Se preferir executar a partir do JAR, navegue até o diretório `dist` e execute o arquivo JAR.

## Funcionalidades

- Adicionar, visualizar, atualizar e excluir quartos de uma taverna.
- Interface gráfica intuitiva.

## Contribuição

Contribuições são bem-vindas! Se encontrar bugs, tiver sugestões ou quiser adicionar novos recursos, abra uma issue ou envie um pull request.

## Autores

- Dev-Johnathan

## Licença

Este projeto é licenciado sob a MIT License.
