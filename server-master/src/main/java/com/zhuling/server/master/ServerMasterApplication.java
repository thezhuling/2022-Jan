package com.zhuling.server.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerMasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerMasterApplication.class, args);
    }
}
