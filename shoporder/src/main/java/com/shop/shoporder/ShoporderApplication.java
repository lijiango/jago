package com.shop.shoporder;

import org.mybatis.spring.annotation.MapperScan;
//import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// 该注解表示扫描指定包下所有文件都为mapper
@MapperScan(value = "com.shop.shoporder.mapper")
@SpringBootApplication
@EnableCaching
@EnableRabbit

public class ShoporderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoporderApplication.class, args);
    }

}
