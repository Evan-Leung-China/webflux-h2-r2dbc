package com.evan.demo.webflux.webfluxh2r2dbc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

/**
 * Swagger访问路径： http://localhost:8900/swagger-ui.html#/
 */
@Configuration
@EnableSwagger2WebFlux
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.evan.demo.webflux.webfluxh2r2dbc.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("WebFlux-H2-R2dbc")
                        .description("WebFlux-H2-R2dbc，详细信息......")
                        .version("9.0")
                        .contact(new Contact("Evan","https://mp.csdn.net/console/article","aaa@gmail.com"))
                        .license("The Apache License")
                        .licenseUrl("https://mp.csdn.net/console/article")
                        .build());
    }
}
