package com.gecx.controller;

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
import java.util.List;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/18 11:28
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

    //    public static final String PRODUCT_GET_URL = "http://localhost:8080/prodcut/get/";
//    public static final String PRODUCT_LIST_URL = "http://localhost:8080/prodcut/list/";
//    public static final String PRODUCT_ADD_URL = "http://localhost:8080/prodcut/add/";
    public static final String PRODUCT_GET_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/prodcut/get/";
    public static final String PRODUCT_LIST_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/prodcut/list/";
    public static final String PRODUCT_ADD_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/prodcut/add/";

    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders httpHeaders;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/product/get")
    public Object getProduct(long id) {
//        Product product = restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
        Product product = restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return product;
    }

    @RequestMapping("/product/list")
    public Object listProduct() {
//        List<Product> list = restTemplate.getForObject(PRODUCT_LIST_URL, List.class);
        //获取服务服务提供方的具体信息
        ServiceInstance instance = this.loadBalancerClient.choose("MICROCLOUD-PROVIDER-PRODUCT");
        System.out.println("instance host:" + instance.getHost() + "/ instance port:" + instance.getPort() + "/ instance serviceId:" + instance.getServiceId());
        List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
//        Boolean result = restTemplate.postForObject(PRODUCT_ADD_URL, product, Boolean.class);
        Boolean result = restTemplate.exchange(PRODUCT_ADD_URL, HttpMethod.POST,
                new HttpEntity<Object>(product, httpHeaders), Boolean.class).getBody();
        return result;
    }

}
