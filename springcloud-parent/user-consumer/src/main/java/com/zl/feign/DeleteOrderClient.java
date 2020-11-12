package com.zl.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("orders-provider")
public interface DeleteOrderClient {
    @RequestMapping("/orders/deleteorder")
    Integer deleteorder(@RequestParam(value = "orderid") Integer orderid);
}
