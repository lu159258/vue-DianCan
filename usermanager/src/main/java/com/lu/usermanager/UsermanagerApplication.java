package com.lu.usermanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lu.usermanager.dao")
public class UsermanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermanagerApplication.class, args);
    }

}
