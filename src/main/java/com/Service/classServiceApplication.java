package com.Service;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@SpringBootApplication
@EnableSwagger2
@EnableSwaggerBootstrapUI
@MapperScan("com.Service.mapper")
public class classServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(classServiceApplication.class, args);
        log.info("项目启动......");
    }
}
