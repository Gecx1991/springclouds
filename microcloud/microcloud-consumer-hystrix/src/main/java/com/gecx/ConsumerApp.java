package com.gecx;

import com.cangshu.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/18 11:21
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.gecx.service")
@RibbonClient(name = "MICROCLOUD-PROVIDER-PRODUCT",configuration = RibbonConfig.class)
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class);
    }
}
