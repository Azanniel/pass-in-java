# ✍️ Anotações

As anotações contidas aqui estão estritamente ligadas a base de código especificada aqui, logo é importante ter um conhecimento básico em relação a base e as especificações já escritas em outro documento referenciado no README do projeto.

## ☕ JAVA

Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation.

Ela está encima do paradigma orientado a objetos então durante o projeto é utilizado muito classes e conceitos de orientação a objetos. Além disso, o java é uma línguagem de programação que chamamos de híbrida, pois ela é tanto compilada quanto interpretada. Dado que ela pode ser compilada em qualquer hardware e executada/interpretada em qualquer outro hardware.

No java temos o que chamamos de JVM que é a Máquina Virtual Java que interpreta essa aplicação compilada que chamamos de código de máquina intermediário. No java, também, temos o JDK e JRE que são:

- JDK (Java Development Kit) -> Kit de desenvolvimento para criação de aplicações Java
- JRE (Java Runtime Environment) -> Caso queira somente executar uma aplicação java, ou seja, kit para executar as aplicações java (mais leve)

## 🍃 Framework Spring

O Spring é um framework para o desenvolvimento de aplicações java que estabelece uma série de padrões e facilita o desenvolvimento de aplicações java. Dentro do Spring existe um módulo exclusivo para o desenvolvimento de aplicações web.

O Spring Boot facilita a criação de aplicativos independentes baseados em Spring de nível de produção que você pode "simplesmente executar". o Spring Boot é uma extensão do Spring Framework que traz diversos recursos pré configurados facilitando e acelerando o processo de manutenção e setup.

Para criar um projeto (como no caso desse) utilizamos o [spring initializr](https://start.spring.io/), nele (usando *maven*) adicionamos as seguintes dependências:
- Spring Web -> Módulo exclusivo para criação de aplicações Web
- Flyway Migration -> Controle de versão para seu banco de dados
- Dev Tools -> Oferece reinicializações rápidas, LiveReload e configurações para uma experiência de desenvolvimento aprimorada.
- Lombok -> Biblioteca de anotações Java que ajuda a reduzir o código boilerplate
- JPA -> Persistir dados em armazenamentos SQL com a API Java Persistence usando Spring Data e Hibernate

Após o setup das dependências e do preenchimento das informações seu projeto vai estar criado e pronto para uso.

## 🎲 Banco de dados

Para o projeto atual será utilizado o HyperSQL (será utilizado por conta da simplicidade), um banco de dados escrito em Java, que pode ser utilizado em memória ou baseado em arquivo. Ele é super leve e tem suporte a multi thread.

Para adicionar o HyperSQL na aplicação é necessário adicionar a dependência dele no pom.xml.

O pom.xml é um arquivo de configuração do Maven que contém os metadados de um projeto. O pom.xml é a base de um projeto Maven e contém todas as informações sobre o projeto e dependências que são importantes para a execução do projeto

Logo, dentro do pom.xml, na categoria das dependências, adicione:

```xml
<dependency>
    <groupId>org.hsqldb</groupId>
    <artifactId>hsqldb</artifactId>
    <version>2.7.1</version>
</dependency>
```
É importante para que o HyperSQL use o armazenamento em disco a configuração básica dele para isso em `application.prperties`:

```
spring.datasource.driver-class-name=org.hsqldb.jdbc.JDBCDriver
spring.datasource.url=jdbc:hsqldb:file:src/main/resources/database/myDb;shutdown=true
```

## 📌 Migrações

As `migrations` são os códigos em SQL que serão responsáveis por controlar as estruturas do nosso banco de dados e permitir o versionamento para controle temporal das mudanças.