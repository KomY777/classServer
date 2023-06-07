package com.Service.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger文档的配置类
 */
@Configuration
public class SwaggerConf {

    @Bean
    public Docket getDocket() {

        //创建 ApiInfo对象，为文档的信息进行配置
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("课堂派后台系统接口文档")
                .version("1.0.0")
                .description("课堂派后台系统接口文档，里面详细记录了课堂派后台的接口信息。")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .groupName("simulation_project")
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.Service.controller"))
                .build();
    }
}
