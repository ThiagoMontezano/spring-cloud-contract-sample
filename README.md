# spring-contract-sample
Repositorio com exemplo de utilização do spring-cloud-contract

## Tecnologia, arquitetura e padrões

- Java 11;
- MongoDB;
- Maven para *build* e *dependências* do projeto

**Frameworks, utilitários e plugins**

- Testes feitos com JUnit5, Mockito e Hamcrest matchers para tornar os *asserts* mais elegantes;
- Spring Boot 2.1.6
- Spring Data Mongo 
- Spring Cloud Contract Verifier
- Spring Cloud Contract Stub Runner
- Utilitário lombok


### Vamos lá

- Baixar o repositório para maquina:

```sh
git clone https://github.com/ThiagoMontezano/spring-cloud-contract-sample.git
```

Antes de subir o projeto, inicie com o docker-compose a infraestrutura:

```sh
docker-compose -f /infra/local-compose.yml up -d
```
**PS: Você pode também optar por instalar manualmente o mongoDB.**

- Ir para o path do projeto provider:

```sh
...
$ cd spring-cloud-contract-sample/provider
$ mvn clean install
```

Os stubs serão gerados em seguida pode executar os testes da aplicação client que utilizarão os stubs para validação de contrato.

```sh
...
$ cd spring-cloud-contract-sample/consumer
$ mvn clean test
```


Divirta-se!


`
