package com.tracy.web.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置项<br/>
 *
 * @author pengc
 * @see com.tracy.web.config.swagger
 * @since 2018/6/11
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.tracy.web.module")).build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("platform-dubbo restful api").description("platform-dubbo接口文档说明").termsOfServiceUrl("http://localhost:8080").version("1.0").build();
    }

}
