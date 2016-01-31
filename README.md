# Integra��o XY-INC
O projeto foi implementado utilizando as seguintes tecnologias :

  - Java 8
  - JAX-RS
  - JUnit
  - Gradle (Gerenciaomento de depend�ncias)
  - WildFly 9.0.1 (Servidor HTTP)
  
### Installation

Voc� precisar� do Gradle ( 2.10 vers�o utilizada ) para efetuar o build e testes do projeto.

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
**OBS. O WildFly contido no projeto j� est� com a �ltima ver�o do deploy do projeto**

### Requests

Os servi�os expostos no projeto s�o :

 - http://localhost:8080/xy-inc/rest/pois (GET) : Listagem de POIs
 - http://localhost:8080/xy-inc/rest/pois/nome/x/y (POST) : Cadastro de POIs
 - http://localhost:8080/xy-inc/rest/pois/x/y/distance (GET) : Busca por proximidade
 
**OBS. Para a verifi��o dos mesmo fora utilizado o plugin do Chrome REST CLient na execu��o das chamadas**
