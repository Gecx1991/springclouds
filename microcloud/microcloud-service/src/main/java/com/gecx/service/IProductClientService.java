package com.gecx.service;

import com.gecx.config.FeignClientConfig;
import com.gecx.service.fallback.IProductClientServiceFallbackFactory;
import com.gecx.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "MICROCLOUD-PROVIDER-PRODUCT", configuration = FeignClientConfig.class, fallbackFactory = IProductClientServiceFallbackFactory.class)
public interface IProductClientService {

    @RequestMapping(value = "/prodcut/get/{id}")
    public Product get(@PathVariable("id") long id);

    @RequestMapping(value = "/prodcut/add")
    public boolean add(@RequestBody Product product);

    @RequestMapping(value = "/prodcut/list")
    public List<Product> list();
}
