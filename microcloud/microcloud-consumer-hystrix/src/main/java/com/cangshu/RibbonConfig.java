package com.cangshu;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/19 22:42
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule() {
        //随机访问策略
        return new com.netflix.loadbalancer.RandomRule();
    }
}
