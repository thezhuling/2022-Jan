package com.zhuling.server.slave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerSlaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerSlaveApplication.class, args);
    }
}
