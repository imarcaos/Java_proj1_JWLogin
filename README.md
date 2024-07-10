# JAVA Projeto 1 - Web MVC Login

Projeto Web MVC CRUD, MySQL, Tomcat, Servlet, JSP - Netbeans IDE

Segui um tutorial da internet para construir este projeto e  estudar a estruturação, organização, conexão com a base de dados MySQL.

#### Os exercícios e explicações poderão estar comentados no próprio código ou nos pontos descritos a seguir, irei detalhar sempre no primeiro projeto.

## Projeto 1 - Java Web - Tela de Login
Iniciado: 2024-06-30

### Ferramentas que vou Utilizar:
- JDK 21 LTS
- IDE Netbeans 18
- Tomcat Servidor Web 10.1
- MySQL Base de Dados (MariaDB 10.4.32)
- Dbeaver SGBD

### Criando a BD no MySQL
- Adicionar uma nova folha de SQL Queries e aplicar os comandos a seguir:
        ``` sql
        create database proj1_java;

        use proj1_java;

        create table users (
            id_user int(11) primary key auto_increment,
            user_name varchar(100) not null,
            user_email varchar(100) not null,
            created_at timestamp default current_timestamp not null,
            updated_at timestamp default current_timestamp on update current_timestamp not null,
            deleted_at timestamp default null null
        );

        insert into users (user_name, user_email) values ('Marcos', 'marcos@teste.com');

        update users set user_name = "Marcos Melo" where id_user = 1;

        select * from users;
        ```
### Criação do Projeto Java Web no Netbeans 
- Será um página web de Login que dá acesso a outra página.
- Nome do Projeto: Proj1_JWLogin
- File > New Project > Java with Ant > Java Web > Web Application > "Project_Name" > Next > Verificar se o Servidor Tomcat esta selecionado > Next > Nesta momento não selecionamos nenhuma framework > Finish.
- Vou criar mais dois packages para seguir o modelo MVC
    - controllers
    - models
     - Na diretório Web Pages ficam as nossas "Views"
- Alterando o nome da página inicial index.html para uma outra qualquer, necessitamos de criar o ficheiro deployment descriptor dentro do diretório "WEB-INF", para isso:
	- BT DT em cima de "WEB-INF" > New > Other... > Web > Standard Deployment Descriptor (web.xml) > Next > Finish.
	- Se o ficheiro`web.xml` não abrir automaticamente, é só editá-lo.
	- entre as tags `<web-app>` adicionar o seguinte código
	``` xml
	<welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
    ```
	- Dentro das tags `<welcome-file>` adicionamos o nome do nosso ficheiro, que neste caso iremos criar um `index.jsp`.
	- Apagar o "index.html" que não iremos utilizar.
	- Em cima da diretoria "Web Pages" > BT DT > New > JSP... > Damos o nome que vamos utilizar, no meu caso "Index" > Finish.
    - Podemos ver mais configurações oficiais do [Deployment Descriptor no site da Oracle](https://docs.oracle.com/cd/E13222_01/wls/docs81/webapp/web_xml.html)
    - Para descarregar a library do MySQL Connector, fazemos uma pesquisa por MySQL Connector, e fazemos download do `JDBC Driver for MySQL (Connector/J)` > selecionamos "Platform Independent" > ficheiro zip (se preferir) > em baixo da página "No thanks, just start my download" > Extrair.
	- Agora importamos para dentro do nosso projeto:
		- BT DT em cima de "Libraries" > Add JAR/Folder... > buscamos o ficheiro extraído: `mysql-connector-j-version.jar`.
### Conexão com a DB MySQL
- Dentro da diretoria `models` vamos criar uma classe "Conexao" ou outro nome.
- Dentro da classe criamos 4 variáveis do tipo `String` para conexão:
	- `classDriver`, `url`, `user`, `pass`.
	- para encontrar o formato de `String` vamos ao site [Oficial do MySQL](https://dev.mysql.com/doc/) > Documentations > Rolamos a página para baixo até encontrar "Connector/J" e entrar > Clicamos em "Connector/J Examples" > Clicamos na primeira opção Example 7.1, “Connector/J: Obtaining a connection from the DriverManager” (poderá ser outra versão).
	- Copiamos a String Driver `com.mysql.cj.jdbc.Driver` para a nossa variável `classDriver` 
	- Copiamos a String Connection `jdbc:mysql://localhost/test` para a nossa variável `url`, onde está "teste" será o nome da nossa DB `proj1_java`.
- Criamos o método para efetuar a ligação e outro para fechar.
- Para testar nossa conexão, foi criado um novo package de testes e uma classe de teste dentro.
### Criando a classe UserModel no "models"
- adicionamos os atributos referentes aos campos que temos na tabela Users da nossa BD.
### Adicionando Bibliotecas JQuery e Bootstrap ao projeto.
- Dentro da diretoria "Web Pages", criamos uma pasta como o nome:
- "assets" e dentro dela mais 2 pastas:
	- js  (ficheiros JavaScript) 
	- css  (ficheiros CSS)
- arrastamos o ficheiros:
- JQuery para a pasta "js"
-  Na pasta do extraída anteriormente Bootstrap, dentro desta pasta em css, buscamos o ficheiro `bootstrap.min` e arrastamos para a nossa pasta "css".
- Ainda na pasta do Bootstrap, dentro de js `bootstrap.bundle.min` arrastamos para a nossa "js".
- Agora criamos um botão "teste" no nosso `index.jsp`  e uma pequena função script para testar os nosso scripts JQuery e Bootstrap.
### Criando o Controller Servlet
- Intermediário entre a camada model e a view.
- BT DT em cima de "controller" > new Servlet... > dei o nome: "UserController" > Next > Finish.
- Criamos um formulário no ficheiro "index.jsp" para testar o método "POST".
### Adicionando uma Navbar ao projeto e estilizá-la.
- Adicionamos um menu com os botões para:
	- Home e Users
- Uma folha de Estilo "main.css" dentro da pasta "css"

### Função JQuery Ajax, getAllUsers
- Criação da Função JQuery Ajax, getAllUsers.
- No diretório Web Pages > assets > js > adicionamos um novo ficheiro JavaScript: main.js e incluímos dentro do ficheiro "index.jsp"  (no NetBeans, só arrastar o ficheiro para a zona onde o queremos chamar).
- Vamos utilizar a biblioteca "jackson" no nosso "UserController.java", para isso fazemos uma pesquisa por: "maven repository" e dentro do site [MavenRepository](https://mvnrepository.com/), pesquisamos por "jackson", precisamos fazer download das 3 bibliotecas:
	- Jackson Databind
	- Jackson Core
	- Jackson Annotations
	- Clicar em cima do número da última versão e fazer download do "jar".
	- Depois do Download, adicionamos as bibliotecas do projeto:
		- BT DT em cima de "libraries" > Add Jar/Folder.. > buscar as bibliotecas e adicionar.
- Neste ponto, depois de tudo pronto, ao testar o projeto apareceu este erro: (2024-07-06)

### Erro no Projeto: build-impl.xml:1033
2024-07-06
- Erro apresentado ao fazer o build:
    - `caminho_do_projeto\nbproject\build-impl.xml:1033: The module has not been deployed. See the server log for details`.
    - Fiz várias pesquisas desde alterar o "context.xml", desinstalar o servidor TomCat
    - Em uma das explicações foi sugerido desinstalar o servidor TomCat e instalar novamente e criar um novo projeto (sim imagina o trabalho), já estou a horas aqui (coisa de iniciante?)
    - O certo foi que depois de reinstalar o servidor Tomcat já consigo criar novos projetos e executá-los.
    - Um grande erro que cometi, não utilizar "Branch" no Git, talvez conseguisse manter o projeto original intacto.
    - Como até o momento não sei outra forma de resolver este erro, vou criar um novo projeto "Java_proj1_JWLogin" e tentar reaproveitar o código do anterior. Agora irei trabalhar com "Branch", bom para praticar, só utilizei quando estudei sobre Git e GitHub.

2024-07-07
- Estou trabalhando no GIT agora utilizando "Branch" para ter um pouco mais de segurança no código:
    - uptest (para updates do código, depois merge para o principal). 
- Depois reconstruir o projeto até o ponto onde estava, ainda continua com o mesmo erro no novo projeto. Vou deixar o projeto parado neste ponto.

2024-07-08
- Decidi hoje tentar mais uma vez, fiz inúmeras pesquisas e cai neste site [Code Project](https://www.codeproject.com/questions/717546/error-the-module-has-not-been-deployed-see-the-ser) e no final falava sobre o log do servidor que dizia algo sobre o mapeamento (em JavaScript e PHP, conhecia por Roteamento), resultado faltava uma `/` no mapeamento do código contido que apontava para "GetAllUsers", dentro da classe `UserController.java` na "annotation" (posso estar errado em alguns termos, ainda estou familiarizando-me), trecho do código errado e o corrigido:
	- Errado: `@WebServlet(name = "UserController", urlPatterns = {"/UserController", "GetAllUsers"})`
	- Corrigido: `@WebServlet(name = "UserController", urlPatterns = {"/UserController", "/GetAllUsers"})` 
- Não sei como expressar o alívio que sinto depois de 2 dias as voltas com o erro (descritos anteriormente), deixo duas ressalvas:
    - Vou manter a versão 2 do Projeto que está com a Branch criada, o projeta está com outro nome.
    - e esse trecho do erro, pois talvez em alguma pesquisa pode vir ajudar alguém na mesma situação.

### Apresentar Registos no FrontEnd
2024-07-10
- No `index.jsp` criar uma div com um nome de class "tabela-users" para referenciarmos e apresentarmos os registos.
- Adicionamos mais 2 div interiores a este, no último adicionamos a nossa tabela.
- Preparar a tabela utilizando o Bootstrap para estilizar.
- Depois de criada a tabela dentro do `index.jsp` e testada, recortamos os 2 últimos div com a nossa tabela e todo o conteúdo.
- Dentro do `main.js` criamos uma função `tableUsers` e dentro da função fazemos o "paste" da tabela.
- Efetuamos as modificações necessários para iterarmos com os dados obtidos dos registos.