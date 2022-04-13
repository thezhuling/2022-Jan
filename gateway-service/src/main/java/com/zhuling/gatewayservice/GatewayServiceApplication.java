package com.zhuling.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("person-service", r -> r.path("/person/api/**").uri("lb://person-service"))
                .route("company-service", r -> r.path("/company/api/**").uri("lb://company-service"))
                .route("order-service", r -> r.path("/order/api/**").uri("lb://order-service"))
                .route("product-service", r -> r.path("/product/api/**").uri("lb://product-service"))
                .build();
    }
}
