package com.gecx.controller;

import com.gecx.service.ProduceService;
import com.gecx.vo.Product;
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

    @RequestMapping(value = "/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.iProductService.get(id);
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
        return this.client ;
    }


}
