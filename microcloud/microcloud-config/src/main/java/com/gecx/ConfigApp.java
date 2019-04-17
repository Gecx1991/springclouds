package com.gecx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/4/17 23:18
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp.class, args);
    }

}
