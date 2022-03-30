<h1 align="center"> Projeto_CitiesAPI </h1>
Projeto feito atraves do lab da DIO para pratica de spring boot e deploy no heroku

Dependencias Spring Initializr
* Spring Web
* Spring data jpa
* PostgreSql driver

Criando o banco de dados no docker
* sudo docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
* nome do container: cities-db
* -d : mantem o container rodando
* -p : define a porta
* -e : por ser imagem oficial suporta as variaveis de ambiente definidas após o "e"
* nome do usuario do banco: postgres_user_city
* password do banco: super_password
* nome do banco de dados: cities
* imagem: postgres

Conexão com o banco na IDE
 * spring.datasource.url=jdbc:postgresql://localhost:5432/cities
 * spring.datasource.username=postgres_user_city
 * spring.datasource.password=super_password

Repositorio clonado para dados
 * https://github.com/chinnonsantos/sql-paises-estados-cidades

Popular banco de dados
 * Rodar um novo container com o comando : sudo docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash
 * -it : modo iterativo 
 * --rm : o container sera excluido quando fechar a janela
 * os dados ficarão dentro da pasta tmp
 * rodar o script : psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
 *                  psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
 *                  psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

Paginação
 * public Page<Country> countries(Pageable page){
      return repository.findAll(page);
  }
 * Pageable e Page são itens do java que nos permitem trazer resultados paginados via query params
 * Ex de query param: http://localhost:8080/countries?page=0&size=10&sort=name.asc
  
  pt9
