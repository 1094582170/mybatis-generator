package com.lw.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: langwei
 * @date: 2018-12-01 22:41:57
 **/
@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.lw.bootdemo.mapper.**")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
