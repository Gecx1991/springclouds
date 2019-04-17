package com.gecx.service.impl;

import com.gecx.mapper.ProductMapper;
import com.gecx.service.ProduceService;
import com.gecx.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/15 1:11
 */
@Service
public class ProductServiceImpl implements ProduceService {


    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product get(long id) {
        return productMapper.findById(id);
    }

    @Override
    public boolean add(Product product) {
        return productMapper.create(product);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }
}
