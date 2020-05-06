# Spring Movie Database

We are going to make a Springboot API service to store movie ratings into a database.

## Goals

For this extra credit assignment, you need to convert the [movie database app](https://github.com/robot297/java-intro-to-sql)
into a Spring Boot application.  You will also need to create a Docker image with your application as well.

If you follow along the video tutorial, you should have built your very first Spring app and have it run in a container!

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

* Have Docker installed and running.
  * [Docker](https://www.docker.com/get-started)
* Build the image with the command `docker build . -t movie_db`
* Create a container with the command `docker run -i -t -p 8080:8080 --rm movie_db:latest`
* To run **my** image, do the following:
  * First pull my image down by running `docker pull robot297/spring-movie-app`
  * Then create a container by running `docker run -i -t -p 8080:8080 -rm robot297/spring-movie-app`
* When you're done running the application, just hit the keys `ctrl + c` in terminal to kill the process

### Other information

* You can access the swagger spec [here](http://localhost:8080/swagger-ui.html)
