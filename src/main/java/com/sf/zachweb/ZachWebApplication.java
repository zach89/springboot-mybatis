package com.sf.zachweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sf.zachweb.mapper")
public class ZachWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZachWebApplication.class, args);
    }
}
