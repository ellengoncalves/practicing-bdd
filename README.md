# Praticando BDD

Mini projeto de automação de testes web usando BDD, Cucumber, Selenium WebDriver, Java e Maven.

O projeto foi adaptado para usar o site [Automation Exercise](https://automationexercise.com/), já que o site usado originalmente no curso (`automationpractice.com`) não está mais disponível.

## Objetivo

Automatizar cenários de compra em um e-commerce de treino, usando escrita em Gherkin e organização com Page Objects.

Fluxos implementados:

- Pesquisa de produto.
- Adição de produto ao carrinho.
- Validação de produto no carrinho.
- Validação de quantidade no carrinho.
- Fluxo de compra com login, checkout, pagamento e mensagem final.

## Tecnologias

- Java
- Maven
- Cucumber
- Selenium WebDriver
- JUnit
- WebDriverManager
- Extent Reports

## BDD

BDD significa Behavior Driven Development, ou Desenvolvimento Orientado por Comportamento.

A ideia principal do BDD é melhorar a comunicação entre pessoas de negócio, desenvolvimento e qualidade. Ele ajuda o time a entender o comportamento esperado do sistema antes da implementação, usando exemplos claros e uma linguagem comum.

No BDD, os critérios de aceitação podem ser escritos em Gherkin, usando uma estrutura como:

```gherkin
Cenário: Adicionar produto ao carrinho
  Dado que um usuário acessa o site "https://automationexercise.com"
  E pesquisa pelo produto "Blue Top"
  Quando adiciona o produto "Blue Top" ao carrinho
  Então o produto "Blue Top" deve estar presente no carrinho
```

Os critérios de aceitação representam os requisitos do cliente. O Gherkin é apenas uma forma padronizada de especificar esses comportamentos.

## Organização Do Projeto

Estrutura principal:

- `src/test/resources/features`: arquivos `.feature` com os cenários em Gherkin.
- `src/test/java/com/everis/steps`: steps que conectam o Gherkin ao código Java.
- `src/test/java/com/everis/pages`: Page Objects com os elementos e ações das páginas.
- `src/test/java/com/everis/tests/RunnerTest.java`: runner que executa os cenários com Cucumber.
- `src/test/java/com/everis/util`: classes utilitárias, configurações e hooks.

Fluxo geral:

```text
RunnerTest -> Feature -> Steps -> Pages -> Navegador
```

## Configuração Local

Para executar o fluxo de compra, é necessário ter uma conta criada no site:

```text
https://automationexercise.com/
```

Depois, crie um arquivo chamado `local.properties` na raiz do projeto.

Esse arquivo guarda dados locais usados nos testes, como login e dados de cartão. Ele está no `.gitignore` e não deve ser commitado.

Exemplo:

```properties
automationexercise.email=seu-email@teste.com
automationexercise.password=sua-senha

automationexercise.card.name=Teste Automatizado
automationexercise.card.number=4111111111111111
automationexercise.card.cvc=123
automationexercise.card.expiry.month=12
automationexercise.card.expiry.year=2030
```

Também é possível informar esses valores por VM options ou variáveis de ambiente.

Exemplo de VM options:

```text
-Dautomationexercise.email=seu-email@teste.com
-Dautomationexercise.password=sua-senha
-Dautomationexercise.card.name=Teste Automatizado
-Dautomationexercise.card.number=4111111111111111
-Dautomationexercise.card.cvc=123
-Dautomationexercise.card.expiry.month=12
-Dautomationexercise.card.expiry.year=2030
```

## Como Rodar

1. Instale o Java e o Maven.
2. Clone o projeto.
3. Crie uma conta no Automation Exercise.
4. Crie o arquivo `local.properties` na raiz do projeto.
5. Execute a classe `RunnerTest`.

Pelo Maven:

```bash
mvn test
```

Pelo IntelliJ:

- Abra a classe `src/test/java/com/everis/tests/RunnerTest.java`.
- Execute a classe como teste JUnit.

O runner está configurado para executar apenas cenários com a tag `@test`:

```java
@CucumberOptions(features = "classpath:features", tags = "@test")
```

## Boas Práticas Aplicadas

- Uso de Page Object para separar regras de tela dos steps.
- Steps escritos com foco no comportamento do usuário.
- Cenários independentes entre si.
- Dados sensíveis fora do código, usando `local.properties`, VM options ou variáveis de ambiente.
- Seletores centralizados nas Pages.
- Uso de waits explícitos para reduzir instabilidade dos testes.

## Observações

O Automation Exercise exibe anúncios e pode alterar pequenos comportamentos da interface. Por isso, alguns seletores e fluxos foram ajustados para deixar os testes mais estáveis.

Este projeto tem finalidade de estudo e prática de BDD com automação de interface web.
