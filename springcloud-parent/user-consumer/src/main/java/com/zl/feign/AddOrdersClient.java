package com.zl.feign;

import com.zl.bean.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("orders-provider")
public interface AddOrdersClient {
    @RequestMapping("/orders/addorder")
    Integer addOrder(Orders orders);
}
