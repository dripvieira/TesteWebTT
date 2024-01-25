# TesteWebTT
**README - Projeto ERP Contábil com Java, BDD, Cucumber, Selenium e JUnit**

Este repositório contém o código-fonte e os recursos necessários para o desenvolvimento de um sistema ERP Contábil utilizando Java, BDD (Behavior-Driven Development), Cucumber, Selenium e JUnit. Este sistema é projetado para uma plataforma AJAX, fornecendo uma experiência interativa e responsiva aos usuários.

**Tecnologias Utilizadas:**
- Java: Linguagem de programação principal utilizada no projeto.
- BDD (Behavior-Driven Development): Metodologia de desenvolvimento baseada em cenários e comportamentos do software.
- Cucumber: Framework BDD utilizado para escrever e executar cenários em linguagem natural.
- Selenium: Ferramenta de automação de testes usada para testes de integração e funcionais.
- JUnit: Framework de teste unitário para testar unidades individuais de código Java.

**Pré-requisitos:**
- JDK (Java Development Kit) instalado.
- Maven para gerenciamento de dependências.
- ChromeDriver (ou outro driver de navegador compatível com Selenium) para execução de testes de interface do usuário.

**Configuração do Ambiente:**
1. Clone este repositório em sua máquina local.
2. Certifique-se de que o JDK e o Maven estão configurados corretamente em seu ambiente.
3. Baixe e configure o ChromeDriver (ou outro driver de navegador compatível com Selenium) e adicione ao seu PATH.

**Executando os Testes:**
1. Navegue até o diretório raiz do projeto.
2. Execute `mvn test` no terminal para executar todos os testes.
3. Para executar testes individuais, utilize as anotações do JUnit em seus respectivos métodos de teste.

**Estrutura do Projeto:**
- **src/main/java**: Contém o código-fonte do projeto.
  - **pages**: Contém as classes de Page Objects que representam as páginas da aplicação e encapsulam o mapeamento dos elementos da interface do usuário.
  - **funcs**: Contém as classes que realizam as ações com os comandos do Selenium, interagindo com os elementos mapeados nas classes de Page Objects.
- **src/test/java**: Contém os testes de unidade.
- **src/test/resources**: Contém arquivos de recursos para testes, como arquivos de configuração e arquivos de dados para testes de integração.
- **features**: Contém os arquivos de especificações de comportamento escritos em linguagem Gherkin para o Cucumber.
- **stepDefinitions**: Contém as definições dos passos dos cenários escritos em Gherkin.


Este projeto destina-se a demonstrar a implementação de um sistema ERP Contábil utilizando as tecnologias mencionadas acima. Se você tiver alguma dúvida ou problema, não hesite em abrir uma issue para discutir. Agradecemos sua contribuição e interesse neste projeto!
