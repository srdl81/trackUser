package ams.labs.configuration;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ams.labs.controller"))
                .paths(paths())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact("Serdil Akyüz", "www.nba.com", "serdil.akyuz@arbetsformedlingen.se"))
                .title("User Activity")
                .description("platsbankenLabz")
                .version("1.0")
                .build();
    }

    private Predicate<String> paths() {
        return or(
                regex("/user.*"),
                regex("/log.*"),
                regex("/jobs.*"),
                regex("/most-viewed.*"),
                regex("/location.*"),
                regex("/profession.*"),
                regex("/employer.*"));
    }

}


