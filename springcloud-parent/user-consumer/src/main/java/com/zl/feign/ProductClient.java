package com.zl.feign;

import com.zl.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient("product-provider")
public interface ProductClient {
    @RequestMapping("/product/find")
    List<Product> find();
}
