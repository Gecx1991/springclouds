package com.gecx;

import com.cangshu.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/18 11:21
 */
@SpringBootApplication
@RibbonClient(name = "MICROCLOUD-PROVIDER-PRODUCT", configuration = RibbonConfig.class)
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }
}
