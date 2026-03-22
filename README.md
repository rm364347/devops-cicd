# Projeto Acadêmico DevOps - Pipeline CI/CD com GitHub Actions, Java, Maven e SonarCloud

## Objetivo
Este projeto foi preparado como trabalho acadêmico para demonstrar um pipeline completo de **build, validação de qualidade e deploy** de uma aplicação **Java com Maven**, utilizando **GitHub** como plataforma central do repositório e da automação.

A solução entrega:
- aplicação Java com front-end
- pipeline CI/CD no **GitHub Actions**
- análise de qualidade com **SonarCloud**
- conjunto de testes cobrindo as etapas pedidas no trabalho
- documentação completa para apresentação acadêmica

---

## Requisitos atendidos
- Aplicação com front-end: **sim**  
- Aplicação Java com Maven: **sim**  
- Pipeline com no mínimo 3 steps: **sim**  
- Uso do Sonar para garantir qualidade: **sim (SonarCloud)**  
- Uso do GitHub para todo o projeto: **sim**  
- Entregáveis com código completo da aplicação e da automação: **sim**

---

## Tipos de testes implementados

O pipeline foi ajustado para executar exatamente os tipos de validação solicitados:

1. **Testes unitários**  
   Validam regras isoladas da aplicação.

2. **Smoke tests**  
   Verificam rapidamente se a aplicação está ativa e respondendo.

3. **Testes de integração**  
   Validam a comunicação entre as camadas da aplicação via requisições HTTP.

4. **Testes funcionais**  
   Simulam o comportamento do usuário final no fluxo da aplicação.

5. **Testes de performance**  
   Executam carga controlada com k6 para validar tempo de resposta.

---

## Stack utilizada
- **Java 17**
- **Spring Boot**
- **Maven**
- **Thymeleaf**
- **JUnit 5 / Spring Test**
- **JaCoCo**
- **SonarCloud**
- **Docker**
- **GitHub Actions**
- **k6**

---

## Estrutura de pastas

```
.
├── .github/workflows/ci-cd.yml
├── src/main/java/com/example/devopspipeline
├── src/main/resources/templates/index.html
├── src/main/resources/static/
├── scripts/
│   ├── smoke-test.sh
│   ├── testeIntegrado.sh
│   ├── testesFuncionais.sh
├── src/test/java/
├── tests/performance/performance-test.js
├── Dockerfile
├── pom.xml
├── README.md
```

---

## Descrição da aplicação
A aplicação possui uma interface web simples utilizando **Thymeleaf**, onde o usuário interage com um fluxo básico de deploy.

---

## Pipeline no GitHub Actions

Arquivo:
```
.github/workflows/ci-cd.yml
```

---

## Fluxo por ambiente

### STG (develop)
- Deploy  
- Smoke  
- Integração  
- Performance  

### PRE (release)
- Deploy  
- Smoke  
- Funcional  

### PRD (main)
- Deploy  

---

## Execução local

```bash
mvn clean package -DskipTests
java -jar target/*.jar
```

---

## Execução no Codespaces

```bash
java -version
mvn -v
mvn clean package -DskipTests
java -jar target/*.jar
```

Acesse:
http://localhost:8080

---

## SonarCloud

Configurar:
```
SONAR_TOKEN
```

---

## Conclusão
Pipeline completo CI/CD com testes, qualidade e deploy por ambientes.
