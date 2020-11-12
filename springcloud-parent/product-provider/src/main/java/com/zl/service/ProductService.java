package com.zl.service;

import com.zl.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> find();
    Product findByid(Integer id);
}
