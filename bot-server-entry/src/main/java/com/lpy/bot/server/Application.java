package com.lpy.bot.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lpy.bot.server.infra")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
