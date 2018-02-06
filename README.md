# O que é?
Exemplo de um sistema de gerenciamento de contas a pagar e receber, que utiliza os mais novos recursos da plataforma JavaEE8,
como JSF 2.3 e CDI 2.0.  

O objetivo é testar a implementação de um projeto utilizando JavaEE e JSF, que possa ser utilizado
como referência de estudo ara quem estiver interessado em iniciar um projeto com JavaEE e aproveitar a ocasião e testar algumas
das novas funiconalidades da versão 8 do JavaEE (o que inclui tmbm o JSF 2.3), **mas também poderá ser usado como referência para
quem quer usar JSF 2.2.**

## Quais as ferramentas/frameworks utilizadas(os)?
 * Java 8
 * JavaEE 8
 * JSF 2.3
 * Eclipse Oxygen.2
 * Tomcat 8.5.24 
 * Maven
 * CDI 2.0 (Weld Servlet 2.4.5)
 * Hibernate 5.2.12
 * FlyWay 5.0.3
 * JUnit 5.0.2
 * MySQL 5.7.21
 * MySQL Workbench (opcional)
 
 ## Como utilizar/rodar o projeto?
  
  Como pode ser visto no tópico acima o projeto depende do Java 8, então é necessário baixar o <a href="http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html">JDK 8 </a> ou superior, depois baixe o <a href="http://www.eclipse.org/downloads/">Eclipse</a>, agora é a vez de baixar o <a href="https://tomcat.apache.org/download-80.cgi">Tomcat</a> e por último baixe o <a href="https://dev.mysql.com/downloads/mysql/">MySQL Server</a>.  
  
  Obs.: O MySQl Workbench é opcional, mas bastante recomendável, para que possa ser possível acompanhar a evolução dos dados
  no BD de forma fácil em uma inteface gráfica, mas nada impede que se use a inteface via linha de comando.
  
  Após todos os downloads, clone o projeto via Eclipse, <a href="https://medium.com/@josevieiraneto/git-workflow-com-eclipse-660e83221f41"> veja aqui como clonar um projeto usando o Eclipse</a>, e o adicione ao seu workspace. Clique com o botão direito
  do mouse no projeto, selecione run as -> run configurations. Na janela que irá abrir clique o botão direito em Maven Build e depois clique em New. Nas opçes que irão aparecer no lado direito da tela clique em workspace e selecione o projeto. No campo goals digite o seguinte comando: clean install flyway:migrate e depois clique em run.
  
Esse procedimento irá construir o projeto e fazer executar os scritps de criação de tabelas e inserção de dados, criando inclusive o banco de dados no MySQl, assim sendo não é necessário criar o banco manualmente pelo Workbench ou pela linha de comando.

Depois clique novamente com o botão direito do mouse no projeto, selecione run as -> run on server, faça as configurações necessárias do tomcat e finalize. Pronto o projeto está rodando!


  
  .

