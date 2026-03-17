# Projeto Acadêmico DevOps - Pipeline CI/CD com GitHub Actions, Java, Maven e SonarQube

## Objetivo
Este projeto foi preparado como trabalho acadêmico para demonstrar um pipeline completo de **build, validação de qualidade e deploy** de uma aplicação **Java com Maven**, utilizando **GitHub** como plataforma central do repositório e da automação.

A solução entrega:
- aplicação Java com front-end
- pipeline CI/CD no **GitHub Actions**
- análise de qualidade com **SonarQube**
- conjunto de testes cobrindo as etapas pedidas no trabalho
- documentação completa para apresentação acadêmica

## Requisitos atendidos
- Aplicação com front-end: **sim**
- Aplicação Java com Maven: **sim**
- Pipeline com no mínimo 3 steps: **sim**
- Uso do SonarQube para garantir qualidade: **sim**
- Uso do GitHub para todo o projeto: **sim**
- Entregáveis com código completo da aplicação e da automação: **sim**

## Tipos de testes implementados
O pipeline foi ajustado para executar exatamente os tipos de validação solicitados:

1. **Testes unitários**  
   Validam regras isoladas da aplicação, como a normalização e a geração da mensagem de retorno.

2. **Smoke tests**  
   Verificam rapidamente se a aplicação subiu corretamente e se os endpoints principais estão disponíveis.

3. **Testes de integração**  
   Validam o comportamento da aplicação já inicializada, com requisições HTTP reais para a camada web.

4. **Testes funcionais**  
   Simulam o fluxo do formulário de deploy para verificar o comportamento esperado do ponto de vista do usuário.

5. **Testes de performance**  
   Executam uma carga leve com k6 para validar tempo de resposta e taxa de erro.

## Stack utilizada
- **Java 17**
- **Spring Boot**
- **Maven**
- **Thymeleaf**
- **JUnit 5 / Spring Test**
- **JaCoCo**
- **SonarQube**
- **Docker**
- **GitHub Actions**
- **k6**

## Estrutura de pastas
```text
.
├── .github/workflows/ci-cd.yml
├── deploy/docker-compose.yml
├── scripts/smoke-test.sh
├── tests/performance/smoke-load.js
├── src/main/java/com/example/devopspipeline
├── src/main/resources/templates/index.html
├── src/main/resources/static/css/style.css
├── src/test/java/com/example/devopspipeline/service/MessageServiceTest.java
├── src/test/java/com/example/devopspipeline/controller/WebControllerIT.java
├── src/test/java/com/example/devopspipeline/controller/DeployFlowFT.java
├── Dockerfile
├── Jenkinsfile
├── docker-compose-sonarqube.yml
├── pom.xml
├── README.md
└── sonar-project.properties
```

## Descrição da aplicação
A aplicação possui uma interface web simples com front-end em Thymeleaf. O usuário informa uma mensagem de deploy e a aplicação retorna um resultado simulando a publicação bem-sucedida. Essa abordagem mantém o projeto simples para fins acadêmicos, mas com uma esteira DevOps completa.

## Pipeline no GitHub Actions
O pipeline principal está no arquivo:
```text
.github/workflows/ci-cd.yml
```

### Steps do pipeline
1. **Checkout do código**  
   Baixa o código do repositório GitHub.

2. **Configuração do Java 17**  
   Prepara o runner do GitHub Actions para compilar o projeto Maven.

3. **Testes unitários**  
   Executa os testes com sufixo `*Test`.

4. **Testes de integração**  
   Executa os testes com sufixo `*IT`.

5. **Testes funcionais**  
   Executa os testes com sufixo `*FT`.

6. **Build da aplicação**  
   Gera o JAR da aplicação.

7. **Subida da aplicação para validações adicionais**  
   Inicializa a aplicação localmente dentro do runner.

8. **Smoke tests**  
   Valida se a aplicação está no ar e saudável.

9. **Testes de performance**  
   Executa teste de carga básico com k6.

10. **Análise SonarQube**  
   Executa a análise estática e de qualidade.

11. **Build da imagem Docker**  
   Gera a imagem da aplicação.

12. **Deploy acadêmico com Docker**  
   Sobe o container como demonstração de publicação automatizada.

13. **Smoke pós-deploy**  
   Confirma se o deploy terminou de forma válida.

## Como executar localmente
### 1. Rodar testes unitários
```bash
mvn -Dtest='*Test' test
```

### 2. Rodar testes de integração
```bash
mvn -Dtest='*IT' test
```

### 3. Rodar testes funcionais
```bash
mvn -Dtest='*FT' test
```

### 4. Gerar o pacote da aplicação
```bash
mvn clean package -DskipTests
```

### 5. Subir a aplicação
```bash
java -jar target/devops-pipeline-1.0.0.jar
```

### 6. Executar smoke tests
```bash
./scripts/smoke-test.sh http://localhost:8080
```

### 7. Executar testes de performance
Instale o k6 e rode:
```bash
k6 run tests/performance/smoke-load.js -e BASE_URL=http://localhost:8080
```

## Como usar o SonarQube
### Subir o SonarQube localmente
```bash
docker compose -f docker-compose-sonarqube.yml up -d
```

### Rodar a análise
```bash
mvn verify sonar:sonar \
  -Dsonar.projectKey=devops-pipeline \
  -Dsonar.projectName=devops-pipeline \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=SEU_TOKEN
```

## Como usar no GitHub
1. Criar um repositório no GitHub.
2. Subir todo o conteúdo deste projeto.
3. Criar os secrets do repositório:
   - `SONAR_TOKEN`
   - `SONAR_HOST_URL`
4. Garantir que a branch principal seja `main`.
5. Fazer push para disparar o pipeline automaticamente.

## Exemplo de narrativa para apresentação acadêmica
Este trabalho demonstra como aplicar práticas de DevOps em uma aplicação Java com Maven hospedada no GitHub. A proposta não se limita apenas ao build do sistema. O pipeline foi desenhado para validar a entrega em vários níveis. Primeiro, são executados os testes unitários, de integração e funcionais. Em seguida, a aplicação é iniciada para permitir smoke tests e testes de performance. Depois disso, o código passa pelo SonarQube para assegurar padrões mínimos de qualidade. Somente após essas validações o pipeline gera a imagem Docker e executa o deploy acadêmico automatizado. Dessa forma, o projeto mostra que uma entrega contínua moderna precisa unir automação, testes e governança de qualidade.

## Observações importantes
- O projeto mantém o arquivo `Jenkinsfile` apenas como referência complementar, mas o pipeline principal do trabalho está no **GitHub Actions**, conforme solicitado.
- O step de SonarQube no GitHub só roda quando os secrets `SONAR_TOKEN` e `SONAR_HOST_URL` estiverem configurados.
- O deploy foi modelado para fins acadêmicos, usando Docker no runner do GitHub Actions.

## Conclusão
Com essa estrutura, o projeto passa a atender o novo escopo solicitado, usando o **GitHub como plataforma central** e incluindo no pipeline os passos de **testes unitários, smoke tests, testes de integração, testes funcionais e testes de performance**, além da análise de qualidade com **SonarQube** e do **deploy automatizado**.
