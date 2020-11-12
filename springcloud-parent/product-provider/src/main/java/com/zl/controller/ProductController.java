package com.zl.controller;

import com.zl.bean.Product;
import com.zl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/find")
    public List<Product> find() {
        List<Product> products = productService.find();
        System.out.println(products);
        return  products;
    }
    @RequestMapping("/findbyid")
    public Product findByid(@RequestParam(value = "id") Integer id) {
        System.out.println(id);
        Product product = productService.findByid(id);
        System.out.println(product);
        return product;
    }
}
