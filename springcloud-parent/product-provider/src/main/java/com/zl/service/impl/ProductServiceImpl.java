package com.zl.service.impl;

import com.zl.bean.Product;
import com.zl.dao.ProductDao;
import com.zl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<Product> find() {
        return productDao.find();
    }

    @Override
    public Product findByid(Integer id) {
        //String key = "product";
        //System.out.println(key);
        ////先看缓存中是否有数据
        //Product product = (Product) redisTemplate.boundValueOps(key).get();
        //
        ////如果有，直接取缓存数据
        //if(product!=null){
        //    System.out.println("数据来源于Redis");
        //    return product;
        //}
        //
        ////如果没有，则查询数据
       Product product = productDao.findByid(id);
        //System.out.println("数据来源于mysql");
        System.out.println(product);
        //再将数据存入到缓存
        //redisTemplate.boundValueOps(key).set(product);
        return  product;
    }
}
