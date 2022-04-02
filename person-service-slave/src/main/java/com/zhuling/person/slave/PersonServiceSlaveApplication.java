package com.zhuling.person.slave;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableRedisDocumentRepositories(basePackages = "com.zhuling.person.slave.*")
public class PersonServiceSlaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceSlaveApplication.class, args);
    }

}
