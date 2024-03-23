package com.bgtb01.bgtb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.bgtb01.bgtb.mapper")
@EnableSwagger2
@SpringBootApplication
public class BgtbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgtbApplication.class, args);
    }

}
