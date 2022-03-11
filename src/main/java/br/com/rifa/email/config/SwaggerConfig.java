package br.com.rifa.email.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/*
  Swagger generates a document for API
  You can see at ["localhost:8080/swagger-ui.html"]
*/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket producAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.rifa.email"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "API REST para a aplicação Rifa enviar e-mail",
                "API REST irá enviar e-mail usando o meu e-mail particular (otavio.basiliosaraiva@gmail.com) nessa primeira versão.",
                "1.0",
                "Terms of Service",
                new Contact("Otavio B Saraiva", "", "otavio.basiliosaraiva@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}