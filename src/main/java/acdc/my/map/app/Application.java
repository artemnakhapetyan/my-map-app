
package acdc.my.map.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@EnableMongoRepositories
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
  public Docket getApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.regex("/api.*"))
          .build()
        .pathMapping("/")
        /*.directModelSubstitute(LocalDate.class,
            String.class)*/
        .genericModelSubstitutes(ResponseEntity.class)
        .enableUrlTemplating(true);
  }
    
}
