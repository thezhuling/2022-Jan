package com.zhuling.sign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignServiceApplication.class, args);
    }

}
