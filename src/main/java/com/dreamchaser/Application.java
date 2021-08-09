package com.dreamchaser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//当有多个数据源时就得这样设置
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.dreamchaser.mapper")
@EnableSwagger2

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
