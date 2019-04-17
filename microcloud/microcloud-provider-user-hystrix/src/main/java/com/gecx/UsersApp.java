package com.gecx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/4/17 17:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class UsersApp {
    public static void main(String[] args) {
        SpringApplication.run(UsersApp.class, args);
    }
}
