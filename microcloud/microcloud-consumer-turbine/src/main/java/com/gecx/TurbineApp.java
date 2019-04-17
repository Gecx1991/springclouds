package com.gecx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/4/17 18:14
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApp {
    public static void main(String[] args) {
        SpringApplication.run(TurbineApp.class,args);
    }

}
