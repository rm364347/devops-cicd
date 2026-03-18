🚀 DevOps CI/CD Pipeline - Java + Maven + GitHub Actions + SonarCloud
📌 Descrição
Este projeto tem como objetivo demonstrar a implementação de um pipeline completo de CI/CD (Continuous Integration e Continuous Delivery) utilizando:
Java (Spring Boot)
Maven
GitHub Actions
SonarCloud
JaCoCo (cobertura de testes)
k6 (testes de performance)
O pipeline automatiza desde o build até o deploy em múltiplos ambientes, garantindo qualidade, rastreabilidade e confiabilidade na entrega de software.
---
🏗️ Arquitetura do Pipeline
Commit → Unit Tests → Code Analysis → Build → Deploy → Testes → Promoção de ambiente
---
🔄 Fluxo por ambiente
Branch	Ambiente	Etapas
develop	STG	Deploy + Smoke + Integração + Performance
release	PRE	Deploy + Smoke + Funcional
main	PRD	Deploy
---
⚙️ Tecnologias utilizadas
Java 17
Spring Boot
Maven
GitHub Actions
SonarCloud
JaCoCo
k6
Thymeleaf (Front-end)
---
📁 Estrutura do projeto
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   ├── resources/
│   │   │   └── templates/
│   │   └── scripts/
│   │       ├── deploy-stg.sh
│   │       ├── deploy-pre.sh
│   │       ├── deploy-prd.sh
│   │       ├── smoketest.sh
│   │       ├── testeIntegrado.sh
│   │       └── testesFuncionais.sh
│   └── test/
├── tests/
│   └── performance/
│       └── performance-test.js
├── pom.xml
└── .github/workflows/ci-cd.yml
---
🔁 Pipeline (GitHub Actions)
🧪 1. Unit Test
Execução de testes unitários
Geração de cobertura com JaCoCo
Publicação de relatório de cobertura
🔍 2. Code Analysis
Análise estática de código com SonarCloud
Validação do Quality Gate
📦 3. Build
Empacotamento da aplicação
Geração do artefato `.jar`
Publicação do artifact no pipeline
🚀 4. Deploy STG (branch develop)
Deploy em ambiente de homologação
🔥 5. Smoke Test
Validação básica da aplicação (health check)
🔗 6. Integration Test
Testes de integração entre componentes
⚡ 7. Performance Test
Testes de carga utilizando k6
🧪 8. Deploy PRE (branch release)
Deploy em ambiente de pré-produção
🔥 9. Smoke Test PRE
Validação do ambiente de pré-produção
🧪 10. Functional Test
Testes funcionais de ponta a ponta
🏁 11. Deploy PRD (branch main)
Deploy em ambiente de produção
---
📊 Qualidade de código (SonarCloud)
O projeto utiliza o SonarCloud para:
Análise estática de código
Identificação de vulnerabilidades
Cobertura de testes
Validação de qualidade (Quality Gate)
---
🔑 Configuração do SonarCloud
No GitHub, configure o secret:
SONAR_TOKEN = <seu_token_sonarcloud>
---
🧪 Testes
✔️ Testes unitários
mvn test
🔗 Testes de integração
mvn -Dtest=*IntegrationTest test
🧪 Testes funcionais
mvn -Dtest=*FunctionalTest test
🔥 Smoke test
./src/main/scripts/smoketest.sh
⚡ Testes de performance
k6 run tests/performance/performance-test.js
---
📈 Cobertura de código
Gerada com JaCoCo:
mvn verify
Relatório disponível em:
target/site/jacoco/index.html
---
🚀 Execução local
Build da aplicação
mvn clean package
Execução da aplicação
java -jar target/*.jar
Acesso
http://localhost:8080
---
🎯 Objetivo acadêmico
Este projeto demonstra na prática:
Integração contínua (CI)
Entrega contínua (CD)
Automação de testes
Controle de qualidade de código
Deploy por múltiplos ambientes
Boas práticas DevOps
---
👨‍💻 Autor
Projeto acadêmico desenvolvido para estudo de DevOps e CI/CD.