# Integração XY-INC
O projeto foi implementado utilizando as seguintes tecnologias :

  - Java 8
  - JAX-RS
  - JUnit
  - Gradle (Gerenciaomento de dependências)
  - WildFly 9.0.1 (Servidor HTTP)
  
### Installation

Você precisará do Gradle ( 2.10 versão utilizada http://gradle.org/gradle-download/ ) para efetuar o build e testes do projeto.

Para compilar o projeto basta executar o comando :
```sh
$ gradle build
```

Para compilar os testes do projeto basta executar o comando :

```sh
$ gradle test
```

### Deploy

O deploy do projeto no servidor wildFly pode ser efetuado manualmente ou publicando via IDE.

**OBS. O WildFly ( 9.0.1.Final ) foi utilizado para execução do projeto. : http://wildfly.org/downloads/**

### Requests

Os serviços expostos no projeto são :

 - http://localhost:8080/xy-inc/rest/pois (GET) : Listagem de POIs
 - http://localhost:8080/xy-inc/rest/pois/nome/x/y (POST) : Cadastro de POIs
 - http://localhost:8080/xy-inc/rest/pois/x/y/distance (GET) : Busca por proximidade
 
**OBS. Para a verifição dos mesmo fora utilizado o plugin do Chrome REST CLient na execução das chamadas**
