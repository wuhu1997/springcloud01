package com.zl.feign;

import com.zl.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product-provider")
public interface ProFindClient {
    @RequestMapping("/product/findbyid")
    Product findbyid(@RequestParam(value = "id") Integer id);
}
