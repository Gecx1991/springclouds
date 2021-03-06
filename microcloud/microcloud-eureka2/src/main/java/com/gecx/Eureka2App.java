package com.gecx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/18 13:31
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka2App {

    public static void main(String[] args) {
        SpringApplication.run(Eureka2App.class);
    }
}
