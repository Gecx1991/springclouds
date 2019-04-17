package com.gecx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/4/17 17:39
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApp.class, args);
    }
}
