package com.gecx.service.fallback;

import com.gecx.service.IProductClientService;
import com.gecx.vo.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gecx
 * @Description: 在某些情况下，服务提供方并没有失效，但可能由于网络原因，服务的消费方并不能调用到服务接口，在这种情况下，
 * 直接在服务的提供方提供熔断机制依然还是不够的，这方面的处理需要在服务的消费方进行服务的回退处理
 * 服务的降级：降级指的是当服务的提供方不可使用的时候，程序不会出现异常，而会出现本地的操作调用，服务的降级是在服务消费方实现的，
 * 在断网情况下服务提供方的任何处理都是没有意义的
 * @date 2019/4/17 17:21
 */
@Component
public class IProductClientServiceFallbackFactory implements FallbackFactory<IProductClientService> {
    @Override
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            @Override
            public Product get(long id) {
                Product product = new Product();
                product.setProductId(9999L);
                product.setProductName("feign-hystrixName");
                product.setProductDesc("feign-hystrixDesc");
                return product;
            }

            @Override
            public boolean add(Product product) {
                return false;
            }

            @Override
            public List<Product> list() {
                return null;
            }
        };
    }
}
