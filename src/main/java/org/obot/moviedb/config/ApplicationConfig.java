package org.obot.moviedb.config;

import org.obot.moviedb.dto.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@Import(SpringDataR)
@ComponentScan("org.obot.moviedb")
@PropertySources({@PropertySource(value = {"application.properties"}, ignoreResourceNotFound = true)})
public class ApplicationConfig {

    @Autowired
    Environment env;

    @Value("moviedb")
    String appName;

    @Value("${dbconnector}")
    String connector;

    @Bean
    public ApplicationProperties properties(){
        return new ApplicationProperties();
    }

    @Bean
    public Database database(){
        return new Database(connector);
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
