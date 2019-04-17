package com.gecx.controller;

import com.gecx.service.ProduceService;
import com.gecx.vo.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/18 11:45
 */
@RestController
@RequestMapping("/prodcut")
public class ProductController {


    @Autowired
    private ProduceService iProductService;

    /**
     * 进行Eureka的发现服务
     */
    @Autowired
    private DiscoveryClient client;

    /**
     * 一旦 get()方法上抛出了错误的信息，那么就认为该服务有问题
     * 会默认使用“@HystrixCommand”注解之中配置好的fallbackMethod 调用类中的指定方法，返回相应数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Object get(@PathVariable("id") long id) {
        Product product = iProductService.get(id);
        if (null == product) {
            throw new RuntimeException("该产品已下架");
        }
        return product;
    }

    public Object getFallback(@PathVariable("id") long id) {
        Product product = new Product();
        product.setProductName("HystrixName");
        product.setProductDesc("HystrixDesc");
        return product;
    }

    @RequestMapping(value = "/add")
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product);
    }

    @RequestMapping(value = "/list")
    public Object list() {
        return this.iProductService.list();
    }

    @RequestMapping("/discover")
    public Object discover() { // 直接返回发现服务信息
        return this.client;
    }


}
