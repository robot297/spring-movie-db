package org.obot.moviedb.config;

import org.obot.moviedb.dto.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
//@EnableSwagger2WebMvc
//@Import(SpringDataR)
@ComponentScan("org.obot.moviedb")
@PropertySources({@PropertySource(value = {"application.properties"})})
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
}
