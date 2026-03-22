Projeto Acadêmico DevOps - Pipeline CI/CD com GitHub Actions, Java, Maven e SonarCloud
Objetivo

Este projeto foi preparado como trabalho acadêmico para demonstrar um pipeline completo de build, validação de qualidade e deploy de uma aplicação Java com Maven, utilizando GitHub como plataforma central do repositório e da automação.

A solução entrega:

aplicação Java com front-end
pipeline CI/CD no GitHub Actions
análise de qualidade com SonarCloud
conjunto de testes cobrindo as etapas pedidas no trabalho
documentação completa para apresentação acadêmica
Requisitos atendidos
Aplicação com front-end: sim
Aplicação Java com Maven: sim
Pipeline com no mínimo 3 steps: sim
Uso do Sonar para garantir qualidade: sim (SonarCloud)
Uso do GitHub para todo o projeto: sim
Entregáveis com código completo da aplicação e da automação: sim
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
Estrutura de pastas
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
Descrição da aplicação

A aplicação possui uma interface web simples utilizando Thymeleaf, onde o usuário interage com um fluxo básico de deploy. O objetivo não é a complexidade funcional, mas sim permitir a validação de um pipeline DevOps completo com testes e automação.

Pipeline no GitHub Actions

O pipeline principal está no arquivo:

.github/workflows/ci-cd.yml
Steps do pipeline
Checkout do código
Configuração do Java 17
Testes unitários + cobertura (JaCoCo)
Análise de código (SonarCloud)
Build da aplicação
Fluxo por ambiente
🔧 Ambiente STG (branch develop)
Deploy STG
Smoke Test
Testes de Integração
Testes de Performance
🧪 Ambiente PRE (branch release)
Deploy PRE
Smoke Test PRE
Testes Funcionais
🚀 Ambiente PRD (branch main)
Deploy PRD
Como executar localmente
1. Rodar testes unitários
mvn -Dtest='*Test' test
2. Rodar testes de integração
mvn -Dtest='*IT' test
3. Rodar testes funcionais
mvn -Dtest='*FT' test
4. Gerar o pacote da aplicação
mvn clean package -DskipTests
5. Subir a aplicação
java -jar target/*.jar
6. Executar smoke tests
./scripts/smoke-test.sh
7. Executar testes de performance
k6 run tests/performance/performance-test.js
💻 Execução no GitHub Codespaces

O projeto pode ser executado diretamente no GitHub Codespaces, sem necessidade de instalação local.

⚙️ Pré-requisito

O Codespace deve estar utilizando Java 17 ou superior, pois o Maven 4 exige essa versão.

🚀 Passo a passo
1. Abrir o projeto no Codespaces
Acesse o repositório no GitHub
Clique em Code → Codespaces → Create codespace
2. Validar versão do Java
java -version
mvn -v
3. Gerar o build da aplicação
mvn clean package -DskipTests
4. Subir a aplicação
java -jar target/*.jar

ou

mvn spring-boot:run
5. Acessar a aplicação
http://localhost:8080
🧪 Teste rápido
curl http://localhost:8080/actuator/health
📌 Observação

O front-end da aplicação é renderizado pelo próprio Spring Boot utilizando Thymeleaf, não sendo necessário subir um servidor separado.

Como usar o SonarCloud
Configuração no GitHub

Criar o seguinte secret:

SONAR_TOKEN
Execução da análise
mvn verify sonar:sonar \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.organization=SEU_ORG \
  -Dsonar.projectKey=SEU_PROJECT_KEY \
  -Dsonar.login=SEU_TOKEN
Como usar no GitHub
Criar repositório
Subir o código
Configurar SONAR_TOKEN
Criar branches:
develop
release
main
Fazer push
Exemplo de narrativa para apresentação acadêmica

Este trabalho demonstra a aplicação prática de DevOps em uma aplicação Java. O pipeline valida o sistema em múltiplos níveis: testes unitários, análise de qualidade com SonarCloud, testes de integração, testes funcionais e testes de performance. A aplicação é promovida entre ambientes até chegar à produção, demonstrando uma esteira completa de entrega contínua.

Observações importantes
Pipeline baseado em GitHub Actions
Uso de SonarCloud (sem infra local)
Deploy acadêmico simulado
Scripts utilizados para execução dos testes
Conclusão

O projeto atende plenamente aos requisitos, demonstrando uma pipeline CI/CD completa com automação de testes, qualidade de código e deploy por ambientes, utilizando GitHub como plataforma central.