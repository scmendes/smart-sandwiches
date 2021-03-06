# SMART SANDWICHES - SILVIO MENDES

### Overview da arquitetura
- Java 8 e Spring boot no backEnd
- Maven
- Database H2 em memória
- Docker 

### Frameworks
- Spring boot
- Spring data
- Spring boot data rest
- Maven

### Carga inicial de dados
A aplicação é inicializada com uma pequena carga de dados, criados durante a inicialização do sistema.
Estes dados servem como exemplo, ao mesmo tempo que testam e validam a integracao entre as camadas da aplicacao.

### Pré-requisitos
Este guia nao contempla os detalhes técnicos da instalacao e configuracao dessas ferramentas de pré-requisito. (Nao escopo)
- JDK 1.8 ou posterior (http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- Maven 3.0+ (https://maven.apache.org/download.cgi)
- Eclipse como IDE, no caso de atuar com atividades de desenvolvimento da aplicacao (https://www.eclipse.org/downloads/?)
- Navegador web Google Chrome na Versão 59.0.3071.115 ou superior (https://chrome.softonic.com.br/)
- Docker (opcional) https://www.docker.com/

### Passo a passo de instalacao via Maven
- 1) Source code
Faça o download ou checkout do source code em uma pasta no sistema operacional.
Por exemplo, C:\smart-sandwiches\
Por convencao essa pasta passara a ser chamada a partir de agora de <ROOT-APP-FOLDER>.
- 2) Compilacao
Para compilar o codigo fonte e gerar os artefatos necessarios para executar a aplicacao,
mova via linha de comando até a pasta <ROOT-APP-FOLDER>. Execute o seguinte comando: 
```sh
mvn clean install
```
- 3) Deploy e execucao da aplicacao
Para fazer o deploy e carregar a aplicacao,
mova via linha de comando até a pasta <ROOT-APP-FOLDER>. Execute o seguinte comando: 
```sh
mvn spring-boot:run
```
- 4) Serviços rest:
A seguir estao os endereços de alguns serviços expostos pela aplicacao: 


Lista de ingredientes cadastrados: `http://localhost:8080/api/ingredients/`


Calculo do valor do sanduiche: `http://localhost:8080/sandwiches/calculate/`
```sh
JSON INPUT:
[{
"ingredientId" : 1,
"qtt" : 3},
{
"ingredientId" : 2,
"qtt" : 1
},
{
"ingredientId" : 5,
"qtt" : 1
}]


JSON OUTPUT:
{
"items": {
"Alface": 1,
"Queijo": 1,
"Hambúrguer de carne": 3
},
"value": 7.11
}

```


### Passo a passo de instalacao via Docker (Opcional)
- 1) Build da image docker com maven
Para criar a iamgem do docker utilizando o maven,
mova via linha de comando até a pasta <ROOT-APP-FOLDER>. Execute o seguinte comando: 
```sh
mvn package docker:build
```
- 2) Para executar a aplicacao via container, utilizando o docker
```
$ docker run -p 8080:8080 -t application/smart-sandwiches
```
- 3) utilizacao da aplicacao
Para ingressar na aplicacao, abra o seu navegador e digite na barra de endereços: 
`http://localhost:8080`


### Testes
Existem alguns testes unitarios criados para validar as principais operacoes da camada de persistencia.
Para executar os testes unitarios,
mova via linha de comando até a pasta <ROOT-APP-FOLDER>. Execute o seguinte comando: 
```sh
mvn test
```
O resultado esperado apos a execucao do processo é o seguinte:
```
Tests run: XXX, Failures: 0, Errors: 0, Skipped: 0
```

### Execução com java (Opcional)
Outra alternativa para o deploy e execucao da aplicacao é através do Java.
Para isso deve-se mover até a pasta <ROOT-APP-FOLDER>/target e executar o comando abaixo:
```sh
$ java -jar smart-sandwiches-1.0.jar
```

### Observaçoes
- Database em memoria: A aplicação está construída com o banco de dados H2 em memória. Assim , reiniciando a aplicação os dados serão resetados.

### Requisitos nao contemplados na versao
- FrontEnd

### Oportunidades de melhoria e evolucao
- Documentacao de APIs
- Maior cobertura de testes



