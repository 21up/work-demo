package com.wen.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by 21up on 2020/9/26
 */
@MapperScan("com.wen.mybatisplus.mapper")
@SpringBootApplication
public class ApplicationMybatisPlus {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMybatisPlus.class,args);
    }
}
