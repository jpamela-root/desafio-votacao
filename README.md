# Projeto de Votação Mobile

Este projeto consiste em uma aplicação mobile para gerenciar e realizar votações. 
O sistema permite que usuários interajam por meio de formulários e seleções de pautas, enviando dados através de requisições API.
A arquitetura desse projeto segue um padrão RESTful API com camadas bem definidas, que está baseado na arquitetura MVC (Model-View-Controller).


## Tecnologias Utilizadas

- **Java 17**: Versão do Java utilizada.
- **Spring Boot**: Framework utilizado para desenvolver a aplicação.
- **Maven**: Gerenciador de dependências.
- **MOckito**: Framework para testes. 
- **Postman**: Usado para testar suas APIs, permitindo enviar requisições HTTP (GET, POST, etc.) e visualizar respostas.
- **Banco de Dados**: H2 Database
-  **YAML**: Arquivo YAML (openapi.yaml) para documentar as APIs. Usando junto com o Swagguer
-  **Json**: Formato de dados usado nas requisições e respostas da  API.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

## Exemplos de Endpoints
Endpoint de Pauta
Criar Pauta:
     -    Método: POST
     -    URL: http://seudominio.com/api/pauta
     -   Body:

        json

      {
         "nome": "Pauta Exemplo",
         "descricao": "Descrição da pauta"
      }

      
Registrar um voto (POST):   
POST http://localhost:8080/v1/votos
     
      {
         "associadoId": 1,
         "pautaId": 1,
        "voto": "Sim"
       }



Listar Pautas

    Método: GET
    URL: http://localhost:8080/api/pauta

Detalhes da Pauta

    Método: GET
    URL: http://localhost:8080/api/pauta/{id}


        
Deletar Pauta
        Método: DELETE
        URL: http://localhost:8080/api/pauta/{id}



Endpoint de Formulário

    Enviar Resposta do Formulário
        Método: POST
        URL: http://seudominio.com/api/formulario/acao1
        Body:

        json

        {
         "campo1": "valor1",
         "campo2": 123,
        "idCampoTexto": "Texto",
       "idCampoNumerico": 999,
      "idCampoData": "01/01/2000"
       }
   
Endpoint de SEleção 

     POST http://seudominio.com/api/selecao
     Content-Type: application/json

    {
    "idOpcaoSelecionada": "opcao1"    }



Para Testar CPF Válido (com resultado aleatório):

    Método: GET
    URL: http://localhost:8080/api/cpf/12345678901

    Se o CPF for válido e o sistema aleatoriamente decidir que a pessoa pode votar:

     json

     {
      "status": "ABLE_TO_VOTE"
     }

Se o CPF for válido, mas a pessoa não pode votar:

    json

    {
        "status": "UNABLE_TO_VOTE"
    }

Para Testar CPF Inválido:

    Método: GET
    URL: http://localhost:8080/api/cpf/invalidcpf

Resultado:

    HTTP Status: 404
    Resposta:

    json

    {
    "message": "CPF inválido"
    }

   ## Explicação breve do porquê das escolhas tomadas durante o desenvolvimento da solução
   A solução foi desenvolvida com Java e Spring Boot, visando a criação de uma API robusta e escalável. A documentação segue o padrão OpenAPI com YAML, facilitando a integração e o consumo da API

   ##Logs da aplicação

     {
          /home/jpam/.jdks/jbr-17.0.12/bin/java -XX:TieredStopAtLevel=1 -Dspring.output.ansi.enabled=always -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dmanagement.endpoints.jmx.exposure.include=* -javaagent:/home/jpam/.var/app/com.jetbrains.IntelliJ-IDEA-Community/data/JetBrains/idea-IU-242.23339.11/lib/idea_rt.jar=39363:/home/jpam/.var/app/com.jetbrains.IntelliJ-IDEA-Community/data/JetBrains/idea-IU-242.23339.11/bin -Dfile.encoding=UTF-8 -classpath /home/jpam/IdeaProjects/votacao-desafio/target/classes:/home/jpam/.m2/repository/org/springframework/boot/spring-boot-starter-validation/3.3.4/spring-boot-starter-validation-3.3.4.jar:/home/jpam/.m2/repository/org/springframework/boot/spring-boot-starter/3.3.4/spring-boot-starter-3.3.4.jar:/home/jpam/.m2/repository/org/springframework/boot/spring-boot/3.3.4/spring-boot-3.3.4.jar:/home/jpam/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.3.4/spring-boot-autoconfigure-3.3.4.jar:/home/jpam/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.3.4/spring-boot-starter-logging-3.3.4.jar:/home/jpam/.m2/repository/ch/qos/logback/logback-classic/1.5.8/logback-classic-1.5.8.jar:/home/jpam/.m2/repository/ch/qos/logback/logback-core/1.5.8/logback-core-1.5.8.jar:/home/jpam/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.23.1/log4j-to-slf4j-2.23.1.jar:/home/jpam/.m2/repository/org/apache/logging/log4j/log4j-api/2.23.1/log4j-api-2.23.1.jar:/home/jpam/.m2/repository/org/slf4j/jul-to-slf4j/2.0.16/jul-to-slf4j-2.0.16.jar:/home/jpam/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/jpam/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/home/jpam/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.30/tomcat-embed-el-10.1.30.jar:/home/jpam/.m2/repository/org/hibernate/validator/hibernate-validator/8.0.1.Final/hibernate-validator-8.0.1.Final.jar:/home/jpam/.m2/repository/jakarta/validation/jakarta.validation-api/3.0.2/jakarta.validation-api-3.0.2.jar:/home/jpam/.m2/repository/org/jboss/logging/jboss-logging/3.5.3.Final/jboss-logging-3.5.3.Final.jar:/home/jpam/.m2/repository/org/springframework/boot/spring-boot-starter-webflux/3.3.4/spring-boot-starter-webflux-3.3.4.jar:/home/jpam/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.3.4/spring-boot-starter-json-3.3.4.jar:/home/jpam/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.17.2/jackson-databind-2.17.2.jar:/home/jpam/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.17.2/jackson-core-2.17.2.jar:/home/jpam/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.17.2/jackson-datatype-jdk8-2.17.2.jar:/home/jpam/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.17.2/jackson-datatype-jsr310-2.17.2.jar:/home/jpam/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.17.2/jackson-module-parameter-names-2.17.2.jar:/home/jpam/.m2/repository/org/springframework/boot/spring-boot-starter-reactor-netty/3.3.4/spring-boot-starter-reactor-netty-3.3.4.jar:/home/jpam/.m2/repository/io/projectreactor/netty/reactor-netty-http/1.1.22/reactor-netty-http-1.1.22.jar:/home/jpam/.m2/repository/io/netty/netty-codec-http/4.1.113.Final/netty-codec-http-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-common/4.1.113.Final/netty-common-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-buffer/4.1.113.Final/netty-buffer-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-transport/4.1.113.Final/netty-transport-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-codec/4.1.113.Final/netty-codec-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-handler/4.1.113.Final/netty-handler-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-codec-http2/4.1.113.Final/netty-codec-http2-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-resolver-dns/4.1.113.Final/netty-resolver-dns-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-resolver/4.1.113.Final/netty-resolver-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-codec-dns/4.1.113.Final/netty-codec-dns-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-resolver-dns-native-macos/4.1.113.Final/netty-resolver-dns-native-macos-4.1.113.Final-osx-x86_64.jar:/home/jpam/.m2/repository/io/netty/netty-resolver-dns-classes-macos/4.1.113.Final/netty-resolver-dns-classes-macos-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-transport-native-epoll/4.1.113.Final/netty-transport-native-epoll-4.1.113.Final-linux-x86_64.jar:/home/jpam/.m2/repository/io/netty/netty-transport-native-unix-common/4.1.113.Final/netty-transport-native-unix-common-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-transport-classes-epoll/4.1.113.Final/netty-transport-classes-epoll-4.1.113.Final.jar:/home/jpam/.m2/repository/io/projectreactor/netty/reactor-netty-core/1.1.22/reactor-netty-core-1.1.22.jar:/home/jpam/.m2/repository/io/netty/netty-handler-proxy/4.1.113.Final/netty-handler-proxy-4.1.113.Final.jar:/home/jpam/.m2/repository/io/netty/netty-codec-socks/4.1.113.Final/netty-codec-socks-4.1.113.Final.jar:/home/jpam/.m2/repository/org/springframework/spring-web/6.1.13/spring-web-6.1.13.jar:/home/jpam/.m2/repository/org/springframework/spring-beans/6.1.13/spring-beans-6.1.13.jar:/home/jpam/.m2/repository/io/micrometer/micrometer-observation/1.13.4/micrometer-observation-1.13.4.jar:/home/jpam/.m2/repository/io/micrometer/micrometer-commons/1.13.4/micrometer-commons-1.13.4.jar:/home/jpam/.m2/repository/org/springframework/spring-webflux/6.1.13/spring-webflux-6.1.13.jar:/home/jpam/.m2/repository/com/mysql/mysql-connector-j/8.0.32/mysql-connector-j-8.0.32.jar:/home/jpam/.m2/repository/org/springdoc/springdoc-openapi-ui/1.7.0/springdoc-openapi-ui-1.7.0.jar:/home/jpam/.m2/repository/org/springdoc/springdoc-openapi-webmvc-core/1.7.0/springdoc-openapi-webmvc-core-1.7.0.jar:/home/jpam/.m2/repository/org/springdoc/springdoc-openapi-common/1.7.0/springdoc-openapi-common-1.7.0.jar:/home/jpam/.m2/repository/io/swagger/core/v3/swagger-core/2.2.9/swagger-core-2.2.9.jar:/home/jpam/.m2/repository/org/apache/commons/commons-lang3/3.14.0/commons-lang3-3.14.0.jar:/home/jpam/.m2/repository/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.17.2/jackson-dataformat-yaml-2.17.2.jar:/home/jpam/.m2/repository/org/springframework/spring-webmvc/6.1.13/spring-webmvc-6.1.13.jar:/home/jpam/.m2/repository/org/springframework/spring-expression/6.1.13/spring-expression-6.1.13.jar:/home/jpam/.m2/repository/org/webjars/swagger-ui/4.18.2/swagger-ui-4.18.2.jar:/home/jpam/.m2/repository/io/springfox/springfox-boot-starter/3.0.0/springfox-boot-starter-3.0.0.jar:/home/jpam/.m2/repository/io/springfox/springfox-oas/3.0.0/springfox-oas-3.0.0.jar:/home/jpam/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.2/swagger-annotations-2.1.2.jar:/home/jpam/.m2/repository/io/swagger/core/v3/swagger-models/2.1.2/swagger-models-2.1.2.jar:/home/jpam/.m2/repository/io/springfox/springfox-core/3.0.0/springfox-core-3.0.0.jar:/home/jpam/.m2/repository/io/springfox/springfox-spring-webmvc/3.0.0/springfox-spring-webmvc-3.0.0.jar:/home/jpam/.m2/repository/io/springfox/springfox-spring-webflux/3.0.0/springfox-spring-webflux-3.0.0.jar:/home/jpam/.m2/repository/io/springfox/springfox-data-rest/3.0.0/springfox-data-rest-3.0.0.jar:/home/jpam/.m2/repository/io/springfox/springfox-bean-validators/3.0.0/springfox-bean-validators-3.0.0.jar:/home/jpam/.m2/repository/com/fasterxml/classmate/1.7.0/classmate-1.7.0.jar:/home/jpam/.m2/repository/org/slf4j/slf4j-api/2.0.16/slf4j-api-2.0.16.jar:/home/jpam/.m2/repository/org/springframework/plugin/spring-plugin-core/2.0.0.RELEASE/spring-plugin-core-2.0.0.RELEASE.jar:/home/jpam/.m2/repository/org/springframework/spring-context/6.1.13/spring-context-6.1.13.jar:/home/jpam/.m2/repository/org/springframework/spring-aop/6.1.13/spring-aop-6.1.13.jar:/home/jpam/.m2/repository/org/springframework/plugin/spring-plugin-metadata/2.0.0.RELEASE/spring-plugin-metadata-2.0.0.RELEASE.jar:/home/jpam/.m2/repository/io/springfox/springfox-swagger2/2.9.2/springfox-swagger2-2.9.2.jar:/home/jpam/.m2/repository/io/swagger/swagger-annotations/1.5.20/swagger-annotations-1.5.20.jar:/home/jpam/.m2/repository/io/swagger/swagger-models/1.5.20/swagger-models-1.5.20.jar:/home/jpam/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.17.2/jackson-annotations-2.17.2.jar:/home/jpam/.m2/repository/io/springfox/springfox-spi/2.9.2/springfox-spi-2.9.2.jar:/home/jpam/.m2/repository/io/springfox/springfox-schema/2.9.2/springfox-schema-2.9.2.jar:/home/jpam/.m2/repository/io/springfox/springfox-swagger-common/2.9.2/springfox-swagger-common-2.9.2.jar:/home/jpam/.m2/repository/io/springfox/springfox-spring-web/2.9.2/springfox-spring-web-2.9.2.jar:/home/jpam/.m2/repository/com/google/guava/guava/20.0/guava-20.0.jar:/home/jpam/.m2/repository/org/mapstruct/mapstruct/1.2.0.Final/mapstruct-1.2.0.Final.jar:/home/jpam/.m2/repository/io/springfox/springfox-swagger-ui/2.9.2/springfox-swagger-ui-2.9.2.jar:/home/jpam/.m2/repository/com/h2database/h2/2.2.224/h2-2.2.224.jar:/home/jpam/.m2/repository/org/projectlombok/lombok/1.18.34/lombok-1.18.34.jar:/home/jpam/.m2/repository/net/bytebuddy/byte-buddy/1.14.19/byte-buddy-1.14.19.jar:/home/jpam/.m2/repository/jakarta/xml/bind/jakarta.xml.bind-api/4.0.2/jakarta.xml.bind-api-4.0.2.jar:/home/jpam/.m2/repository/jakarta/activation/jakarta.activation-api/2.1.3/jakarta.activation-api-2.1.3.jar:/home/jpam/.m2/repository/org/springframework/spring-core/6.1.13/spring-core-6.1.13.jar:/home/jpam/.m2/repository/org/springframework/spring-jcl/6.1.13/spring-jcl-6.1.13.jar:/home/jpam/.m2/repository/io/projectreactor/reactor-core/3.6.10/reactor-core-3.6.10.jar:/home/jpam/.m2/repository/org/reactivestreams/reactive-streams/1.0.4/reactive-streams-1.0.4.jar:/home/jpam/.m2/repository/org/springframework/boot/spring-boot-starter-data-jpa/3.3.4/spring-boot-starter-data-jpa-3.3.4.jar:/home/jpam/.m2/repository/org/springframework/boot/spring-boot-starter-aop/3.3.4/spring-boot-starter-aop-3.3.4.jar:/home/jpam/.m2/repository/org/aspectj/aspectjweaver/1.9.22.1/aspectjweaver-1.9.22.1.jar:/home/jpam/.m2/repository/org/springframework/boot/spring-boot-starter-jdbc/3.3.4/spring-boot-starter-jdbc-3.3.4.jar:/home/jpam/.m2/repository/com/zaxxer/HikariCP/5.1.0/HikariCP-5.1.0.jar:/home/jpam/.m2/repository/org/springframework/spring-jdbc/6.1.13/spring-jdbc-6.1.13.jar:/home/jpam/.m2/repository/org/hibernate/orm/hibernate-core/6.5.3.Final/hibernate-core-6.5.3.Final.jar:/home/jpam/.m2/repository/jakarta/persistence/jakarta.persistence-api/3.1.0/jakarta.persistence-api-3.1.0.jar:/home/jpam/.m2/repository/jakarta/transaction/jakarta.transaction-api/2.0.1/jakarta.transaction-api-2.0.1.jar:/home/jpam/.m2/repository/org/hibernate/common/hibernate-commons-annotations/6.0.6.Final/hibernate-commons-annotations-6.0.6.Final.jar:/home/jpam/.m2/repository/io/smallrye/jandex/3.1.2/jandex-3.1.2.jar:/home/jpam/.m2/repository/org/glassfish/jaxb/jaxb-runtime/4.0.5/jaxb-runtime-4.0.5.jar:/home/jpam/.m2/repository/org/glassfish/jaxb/jaxb-core/4.0.5/jaxb-core-4.0.5.jar:/home/jpam/.m2/repository/org/eclipse/angus/angus-activation/2.0.2/angus-activation-2.0.2.jar:/home/jpam/.m2/repository/org/glassfish/jaxb/txw2/4.0.5/txw2-4.0.5.jar:/home/jpam/.m2/repository/com/sun/istack/istack-commons-runtime/4.1.2/istack-commons-runtime-4.1.2.jar:/home/jpam/.m2/repository/jakarta/inject/jakarta.inject-api/2.0.1/jakarta.inject-api-2.0.1.jar:/home/jpam/.m2/repository/org/antlr/antlr4-runtime/4.13.0/antlr4-runtime-4.13.0.jar:/home/jpam/.m2/repository/org/springframework/data/spring-data-jpa/3.3.4/spring-data-jpa-3.3.4.jar:/home/jpam/.m2/repository/org/springframework/data/spring-data-commons/3.3.4/spring-data-commons-3.3.4.jar:/home/jpam/.m2/repository/org/springframework/spring-orm/6.1.13/spring-orm-6.1.13.jar:/home/jpam/.m2/repository/org/springframework/spring-tx/6.1.13/spring-tx-6.1.13.jar:/home/jpam/.m2/repository/org/springframework/spring-aspects/6.1.13/spring-aspects-6.1.13.jar com.example.votacaodesafio.VotacaoDesafioApplication

      .   ____          _            __ _ _
      /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
     ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
     \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
     '  |____| .__|_| |_|_| |_\__, | / / / /
     =========|_|==============|___/=/_/_/_/

    :: Spring Boot ::                (v3.3.4)

     2024-10-17T16:09:20.100-03:00  INFO 51356 --- [votacao-desafio] [           main] c.e.v.VotacaoDesafioApplication          : Starting VotacaoDesafioApplication using Java 17.0.12 with PID 51356 (/home/jpam/IdeaProjects/votacao-desafio/target/classes started by jpam in /home/jpam/IdeaProjects/votacao-desafio)
     2024-10-17T16:09:20.106-03:00  INFO 51356 --- [votacao-desafio] [           main] c.e.v.VotacaoDesafioApplication          : No active profile set, falling back to 1 default profile: "default"
     2024-10-17T16:09:20.981-03:00  INFO 51356 --- [votacao-desafio] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
     2024-10-17T16:09:21.146-03:00  INFO 51356 --- [votacao-desafio] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 157 ms. Found 2 JPA repository interfaces.
     2024-10-17T16:09:21.706-03:00  INFO 51356 --- [votacao-desafio] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
     2024-10-17T16:09:21.912-03:00  INFO 51356 --- [votacao-desafio] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:testdb user=SA
    2024-10-17T16:09:21.914-03:00  INFO 51356 --- [votacao-desafio] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
    2024-10-17T16:09:21.963-03:00  INFO 51356 --- [votacao-desafio] [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
    2024-10-17T16:09:22.017-03:00  INFO 51356 --- [votacao-desafio] [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.5.3.Final
    2024-10-17T16:09:22.051-03:00  INFO 51356 --- [votacao-desafio] [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
    2024-10-17T16:09:22.398-03:00  INFO 51356 --- [votacao-desafio] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
    2024-10-17T16:09:23.392-03:00  INFO 51356 --- [votacao-desafio] [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
    2024-10-17T16:09:23.444-03:00  INFO 51356 --- [votacao-desafio] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
    2024-10-17T16:09:24.060-03:00 DEBUG 51356 --- [votacao-desafio] [           main] s.w.r.r.m.a.RequestMappingHandlerMapping : 8 mappings in 'requestMappingHandlerMapping'
    2024-10-17T16:09:24.078-03:00 DEBUG 51356 --- [votacao-desafio] [           main] o.s.w.r.handler.SimpleUrlHandlerMapping  : Patterns [/webjars/**, /**] in 'resourceHandlerMapping'
    2024-10-17T16:09:24.112-03:00 DEBUG 51356 --- [votacao-desafio] [           main] o.s.w.r.r.m.a.ControllerMethodResolver   : ControllerAdvice beans: none
    2024-10-17T16:09:24.144-03:00 DEBUG 51356 --- [votacao-desafio] [           main] o.s.w.s.adapter.HttpWebHandlerAdapter    : enableLoggingRequestDetails='false': form data and headers will be masked to prevent unsafe logging of potentially sensitive data
    2024-10-17T16:09:24.395-03:00  INFO 51356 --- [votacao-desafio] [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
    2024-10-17T16:09:24.406-03:00  INFO 51356 --- [votacao-desafio] [           main] c.e.v.VotacaoDesafioApplication          : Started VotacaoDesafioApplication in 4.95 seconds (process running for 6.193)
    2024-10-17T16:10:34.908-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-3] o.s.w.s.adapter.HttpWebHandlerAdapter    : [4bb37452-1] HTTP POST "/api/formulario/acao1"
    2024-10-17T16:10:34.944-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-3] s.w.r.r.m.a.RequestMappingHandlerMapping : [4bb37452-1] Mapped to com.example.votacaodesafio.controller.FormularioController#acao1(FormularioRequest)
    2024-10-17T16:10:35.026-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-3] .s.w.r.r.m.a.ResponseEntityResultHandler : [4bb37452-1] Using 'text/plain;charset=UTF-8' given [*/*] and supported [text/plain;charset=UTF-8, text/event-stream, text/plain;charset=UTF-8, */*]
    2024-10-17T16:10:35.026-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-3] .s.w.r.r.m.a.ResponseEntityResultHandler : [4bb37452-1] 0..1 [java.lang.String]
    2024-10-17T16:10:35.034-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-3] org.springframework.web.HttpLogging      : [4bb37452-1] Writing "Ação 1 executada com sucesso"
    2024-10-17T16:10:35.068-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-3] o.s.w.s.adapter.HttpWebHandlerAdapter    : [4bb37452-1] Completed 200 OK
    2024-10-17T16:12:37.522-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-1] o.s.w.s.adapter.HttpWebHandlerAdapter    : [24f16b5e-2] HTTP POST "/api/selecao"
    2024-10-17T16:12:37.523-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-1] s.w.r.r.m.a.RequestMappingHandlerMapping : [24f16b5e-2] Mapped to com.example.votacaodesafio.controller.SelecaoController#selecionar(SelecaoRequest)
    2024-10-17T16:12:37.525-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-1] .s.w.r.r.m.a.ResponseEntityResultHandler : [24f16b5e-2] Using 'text/plain;charset=UTF-8' given [*/*] and supported [text/plain;charset=UTF-8, text/event-stream, text/plain;charset=UTF-8, */*]
    2024-10-17T16:12:37.525-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-1] .s.w.r.r.m.a.ResponseEntityResultHandler : [24f16b5e-2] 0..1 [java.lang.String]
    2024-10-17T16:12:37.525-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-1] org.springframework.web.HttpLogging      : [24f16b5e-2] Writing "Seleção processada com sucesso"
    2024-10-17T16:12:37.526-03:00 DEBUG 51356 --- [votacao-desafio] [or-http-epoll-1] o.s.w.s.adapter.HttpWebHandlerAdapter    : [24f16b5e-2] Completed 200 OK

     }


   ## Como você versionaria a API da sua aplicação? Que estratégia usar?
  - Versionamento na URL, abordagem eficaz , direta e fácil de entender para os desenvolvedores que consomem a API. Cada versão é tratada como uma nova rota.

   Exemplo:

    V1: https://api.exemplo.com/v1/pautas
    V2: https://api.exemplo.com/v2/pautas


   
