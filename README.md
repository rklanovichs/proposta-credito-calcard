# proposta-credito-calcard
Projeto Propósta de Crédito ao cliente

⦁	Passo a passo para compilação, instalação e execução do projeto propostacredito, o qual apresenta módulo de Proposta de Crédito ao Cliente com as funcionalidades de cadastrar, remover e consultar proposta de crédito.

⦁	O projeto foi desenvolvido na IDE Spring Tool Suite 4.7, versão do Java 1.8, Spring Boot v2.1.9.RELEASE, persistência com Spring Data JPA, Maven como gerenciar de dependências e MySQL 8.0 como banco de dados. O frontend foi feito em AngularJS 1.5.7, Bootstrap 4, CSS, HTML5, Javascript, foi utilizado o modelo de rotas do próprio AngularJS para navegar entre as páginas/templates e acessar os controllers de cada requisição/rota do módulo. No backend foi utilizado design pattern do SpringMVC com as classes anotadas com @RestController para interceptar e receber as requisições no padrão RESTful, @Service para os serviços e regras de negócio, @Component para injeção de dependência e auto-configuração e detecção de beans no conteiner do Spring, @Model para a entidade modelo atuante no banco de dados, e por fim o @Repository para utilizar o repositório de ações de interação e persistir o modelo no BD. A configuração de acesso ao BD estão no arquivo application.properties. Não é necessário criar o banco de dados manualmente, pois o mesmo é criado automaticamente através do Spring Data JPA, sempre que a aplicação sobe, ele dropa e cria novamente o DB. Para documentação dos endpoints foi utilizado o Swagger2 que pode ser acessado em http://localhost:8080/swagger-ui.html.

⦁	Para abrir o projeto, o ideal é utilizar a IDE Spring Tool Suite 4.4 e importar como projeto Maven executando em seguida os comandos clean e install. E por fim executar a aplicação através do click com botão direito e rodar como “Spring Boot App”. O projeto sobe e roda automaticamente num Tomcat disponibilizado pelo próprio Spring. Outras forma de executar o projeto é compilar via maven e colocar o propostacredito-0.0.1-SNAPSHOT.war (gerado dentro da pasta target) dentro do contexto do Tomcat 9. O link de acesso ao aplicativo é feito via http://localhost:8080/.

⦁	A estratégia usada para desenvolver foi utilizar o padrão MVC do Spring, em conjunto com api no modelo RESTful, realizando as operações básicas de insert, delete e select através dos métodos disponíveis no Spring Data JPA, é possível realizar a consulta pelos 2 campos juntos, parcialmente juntos ou isolados.

⦁	Para definição e configuração das regras de negócio do motor de crédito, foi utilizado a api Easy Rules (https://github.com/j-easy/easy-rules), mesmo eu não dominando ela por completado, achei interessante o modo com que ela gerencia e executa as regras definidas. Infelizmente não tive tempo hábil (por motivo de força maior) para desenvolver as regras levando em consideração todos os dados inputados no cadastro, mas durante o tempo de desenvolvimento me dediquei ao máximo para entregar o projeto rodando, bem como o maior número de requisitos desejados/solicitados.

⦁	Pontos fortes da aplicação:  a arquitetura robusta e enxuta provida através do Spring Boot, API no formato RESTful consumindo e provendo JSON entre as camadas de back e frontend, bem como boas práticas de programação orientada à objetos.

⦁	Ponto a ser melhorado é incrementar com mais regras negociais através dos dados cadastrados, para uma melhor análise e definição de limite de crédito.

 
