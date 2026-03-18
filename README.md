Projeto Acadêmico DevOps - Pipeline CI/CD com GitHub Actions, Java, Maven e SonarCloud
Objetivo
Este projeto foi preparado como trabalho acadêmico para demonstrar um pipeline completo de build, validação de qualidade e deploy de uma aplicação Java com Maven, utilizando GitHub como plataforma central do repositório e da automação.
A solução entrega:
aplicação Java com front-end
pipeline CI/CD no GitHub Actions
análise de qualidade com SonarCloud
conjunto de testes cobrindo as etapas pedidas no trabalho
documentação completa para apresentação acadêmica
---
Requisitos atendidos
Aplicação com front-end: sim
Aplicação Java com Maven: sim
Pipeline com no mínimo 3 steps: sim
Uso do Sonar para garantir qualidade: sim (SonarCloud)
Uso do GitHub para todo o projeto: sim
Entregáveis com código completo da aplicação e da automação: sim
---
Tipos de testes implementados
O pipeline foi ajustado para executar exatamente os tipos de validação solicitados:
Testes unitários  
Validam regras isoladas da aplicação.
Smoke tests  
Verificam rapidamente se a aplicação está ativa e respondendo.
Testes de integração  
Validam a comunicação entre as camadas da aplicação via requisições HTTP.
Testes funcionais  
Simulam o comportamento do usuário final no fluxo da aplicação.
Testes de performance  
Executam carga controlada com k6 para validar tempo de resposta.
---
Stack utilizada
Java 17
Spring Boot
Maven
Thymeleaf
JUnit 5 / Spring Test
JaCoCo
SonarCloud
Docker
GitHub Actions
k6
---
Estrutura de pastas
```
.
├── .github/workflows/ci-cd.yml
├── src/main/java/com/example/devopspipeline
├── src/main/resources/templates/index.html
├── src/main/resources/static/
├── src/main/scripts/
│   ├── deploy-stg.sh
│   ├── deploy-pre.sh
│   ├── deploy-prd.sh
│   ├── smoketest.sh
│   ├── testeIntegrado.sh
│   └── testesFuncionais.sh
├── src/test/java/
├── tests/performance/performance-test.js
├── Dockerfile
├── pom.xml
├── README.md
```
---
Descrição da aplicação
A aplicação possui uma interface web simples utilizando Thymeleaf, onde o usuário interage com um fluxo básico de deploy. O objetivo não é a complexidade funcional, mas sim permitir a validação de um pipeline DevOps completo com testes e automação.
---
Pipeline no GitHub Actions
O pipeline principal está no arquivo:
```
.github/workflows/ci-cd.yml
```
---
Steps do pipeline
Checkout do código  
Download do repositório no runner.
Configuração do Java 17  
Setup do ambiente de build.
Testes unitários + cobertura (JaCoCo)  
Execução dos testes e geração de relatório.
Análise de código (SonarCloud)  
Validação de qualidade e segurança.
Build da aplicação  
Geração do artefato `.jar`.
---
Fluxo por ambiente
🔧 Ambiente STG (branch develop)
Deploy STG
Smoke Test
Testes de Integração
Testes de Performance
---
🧪 Ambiente PRE (branch release)
Deploy PRE
Smoke Test PRE
Testes Funcionais
---
🚀 Ambiente PRD (branch main)
Deploy PRD
---
Como executar localmente
1. Rodar testes unitários
```bash
mvn -Dtest='*Test' test
```
2. Rodar testes de integração
```bash
mvn -Dtest='*IntegrationTest' test
```
3. Rodar testes funcionais
```bash
mvn -Dtest='*FunctionalTest' test
```
4. Gerar o pacote da aplicação
```bash
mvn clean package -DskipTests
```
5. Subir a aplicação
```bash
java -jar target/*.jar
```
6. Executar smoke tests
```bash
./src/main/scripts/smoketest.sh
```
7. Executar testes de performance
```bash
k6 run tests/performance/performance-test.js
```
---
Como usar o SonarCloud
Configuração no GitHub
Criar o seguinte secret:
```
SONAR_TOKEN
```
---
Execução da análise (via Maven)
```bash
mvn verify sonar:sonar \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.organization=SEU_ORG \
  -Dsonar.projectKey=SEU_PROJECT_KEY \
  -Dsonar.login=SEU_TOKEN
```
---
Como usar no GitHub
Criar um repositório no GitHub
Subir o código do projeto
Configurar o secret:
`SONAR_TOKEN`
Garantir as branches:
`develop`
`release`
`main`
Realizar push para disparar o pipeline
---
Exemplo de narrativa para apresentação acadêmica
Este trabalho demonstra a aplicação prática de conceitos de DevOps em uma aplicação Java com Maven hospedada no GitHub. O pipeline foi estruturado para garantir qualidade em múltiplos níveis. Inicialmente são executados testes unitários, seguidos por análise de qualidade com SonarCloud. Em seguida, o sistema é empacotado e promovido para diferentes ambientes. No ambiente de homologação são realizados testes de integração e performance. No ambiente de pré-produção são executados testes funcionais. Por fim, a aplicação é disponibilizada em produção. Esse fluxo demonstra como pipelines modernos combinam automação, testes e governança de qualidade para garantir entregas confiáveis.
---
Observações importantes
O pipeline é totalmente baseado em GitHub Actions
O uso do SonarCloud elimina a necessidade de infraestrutura local
O deploy é simulado para fins acadêmicos
A execução dos testes depende da estrutura de scripts definida no projeto
---
Conclusão
O projeto atende plenamente aos requisitos propostos, implementando um pipeline CI/CD completo utilizando GitHub, com automação de testes, análise de qualidade com SonarCloud e deploy estruturado por ambientes. A solução demonstra na prática como integrar desenvolvimento, testes e operações em uma esteira moderna de entrega contínua.