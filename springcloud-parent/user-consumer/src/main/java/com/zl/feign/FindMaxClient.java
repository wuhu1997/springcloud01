package com.zl.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("orders-provider")
public interface FindMaxClient {
    @RequestMapping("/orders/findmax")
    String findMax();
}
