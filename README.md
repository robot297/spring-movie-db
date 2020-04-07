# Spring Movie Database

We are going to make a Springboot API service to store movie ratings into a database.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Docker

* Make sure Docker is installed and running.
* Build the image with the command `docker build . -t movie_db`
* Create a container with the command `docker run -p 8080:8080 --rm movie_db:latest `

### Other information

* You can access the swagger spec [here](http://localhost:8080/swagger-ui.html)
