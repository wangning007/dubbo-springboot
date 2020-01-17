package com.inspur;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wang.ning
 * @create 2020-01-07 16:42
 */

@EnableDubbo(scanBasePackages = "com.inspur.provider")
@MapperScan(basePackages = "com.inspur.mybatis.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
