package com.gecx.service;

import com.gecx.vo.Product;

import java.util.List;

public interface ProduceService {
    Product get(long id);
    boolean add(Product product);
    List<Product> list();
}
