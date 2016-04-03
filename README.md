# Geral

 - Montar uma pequena aplicação java web, com as funcionalidades de um crud web simples, usando as seguintes tecnologias:
 Hibernate para persistência dos dados e consultas
 Spring MVC para implementar o controller REST
 Angular JS montar a interface html se comunicando com os controller REST
 O banco de dados e o servidor de aplicação utilizados podem ser qualquer um

Maven 3.3.3 para o gerenciamento de dependências. 
Tomcat 7 e banco de dados MySql 5.

Utilizei Spring 4.2.5.RELEASE + Hibernate 5.1.0.Final + Jackson(parse) 2.6.3 com Java 1.7.

Como utilizei Spring versão 4 achei mais coerente fazer a configuração do Spring e Beans com @Annotations ao invés de utilizar .xml. 

A configuração de banco de dados e hibenate se encontra no application.properties do projeto. 

A tela consume os serviços rest com Angular conforme solicitado e utilizei alguma coisa de bootstrap para facilitar e também ficar um pouco mais legível. 

Não fiz tratamento de exceções nesse momento, fiz algumas validações na tela com o próprio angular e tentei dar algum tratamento ao retorno HTTP na camada rest. 

# Uso

- Criar o pacote WAR com o maven (mvn clean install).
- Efetuar a configuração do banco de dados e hibernate no arquivo application.properties. 
- Hibernate está configurado para create-drop então criará as tabelas automáticamente.
- Acessar a URL http://ip:porta/simplecrudapp/ - o index está mapeado em um controler(IndexController) para redirecionamento para a tela de cadastro.
- Serviços REST estão na URL http://ip:porta/simplecrudapp/rest
  - http://ip:porta/simplecrudapp/rest GET retorna a lista de cadastros
  - http://ip:porta/simplecrudapp/rest/{id} GET retorna o usuário daquele id
  - http://ip:porta/simplecrudapp/rest POST(user) cria um novo usário
  - http://ip:porta/simplecrudapp/rest/{id} PUT(user) faz update do usuário
  - http://ip:porta/simplecrudapp/rest/{id} DELETE(id) deleta o usuário.

# Testes 
- A serem criados.
