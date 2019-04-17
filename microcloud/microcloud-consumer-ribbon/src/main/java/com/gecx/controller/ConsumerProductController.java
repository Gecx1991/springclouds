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
import java.net.URI;
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
//    public static final String PRODUCT_GET_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/prodcut/get/";
//    public static final String PRODUCT_LIST_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/prodcut/list/";
//    public static final String PRODUCT_ADD_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/prodcut/add/";

    public static final String PRODUCT_TOPIC = "MICROCLOUD-PROVIDER-PRODUCT";

    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders httpHeaders;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping("/product/list")
    public Object listProduct() {
//        List<Product> list = restTemplate.getForObject(PRODUCT_LIST_URL, List.class);
        //获取服务服务提供方的具体信息
        ServiceInstance instance = this.loadBalancerClient.choose("MICROCLOUD-PROVIDER-PRODUCT");
        System.out.println("instance host:" + instance.getHost() + "/ instance port:" + instance.getPort() + "/ instance serviceId:" + instance.getServiceId());
//        List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class).getBody();

        URI uri = URI.create(String.format("http://%s:%s/product/list/", instance.getHost(), instance.getPort()));
//        URI uri = URI.create(String.format("http://%s:%s/prodcut/list/" ,serviceInstance.getHost(), serviceInstance.getPort()));
        List list = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return list;
    }


}
