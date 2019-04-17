package com.gecx.controller;

import com.gecx.service.IProductClientService;
import com.gecx.service.IZUUlClientService;
import com.gecx.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gecx
 * @Description: Feign = RestTempate + HttpHeader + Ribbon + Eureka 综合体，使用feign大大增加了代码的灵活程度
 * @date 2019/3/18 11:28
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

    @Autowired
    private IProductClientService productClientService;
    @Autowired
    private IZUUlClientService izuUlClientService;

    @RequestMapping("/product/get")
    public Object getProduct(long id) {
//        Product product = restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
//        Product product = restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return productClientService.get(id);
    }

    @RequestMapping("/product/list")
    public Object listProduct() {
//        List<Product> list = restTemplate.getForObject(PRODUCT_LIST_URL, List.class);
        //获取服务服务提供方的具体信息
//        ServiceInstance instance = this.loadBalancerClient.choose("MICROCLOUD-PROVIDER-PRODUCT");
//        System.out.println("instance host:" + instance.getHost() + "/ instance port:" + instance.getPort() + "/ instance serviceId:" + instance.getServiceId());
//        List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return productClientService.list();
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
//        Boolean result = restTemplate.postForObject(PRODUCT_ADD_URL, product, Boolean.class);
//        Boolean result = restTemplate.exchange(PRODUCT_ADD_URL, HttpMethod.POST,
//                new HttpEntity<Object>(product, httpHeaders), Boolean.class).getBody();
        return productClientService.add(product);
    }

    @RequestMapping("/product/getProductAndUser")
    public Object getProductAndUser(long id) {
        Map<String, Object> result = new HashMap<>();
        result.put("product", izuUlClientService.getProduct(id));
        result.put("user", izuUlClientService.getUsers(String.valueOf(id)));
        return result;
    }

}
