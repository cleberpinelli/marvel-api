# marvel-api

Requisitos:

```maven, git, java```

Como baixar:

```git clone https://github.com/cleberpinelli/marvel-api.git```

Para compilar, empacotar e testar:

```mvn install```

Para executar a aplicação:
```
docker-compose up
mvn spring-boot:run
```
Para executar testes de unidade:

```mvn test```

Para verificar a qualidade do código via sonar:

```mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=pinelli```