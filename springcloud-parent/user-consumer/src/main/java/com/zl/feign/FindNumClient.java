package com.zl.feign;

import com.zl.bean.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("orders-provider")
public interface FindNumClient {
    @RequestMapping("/orders/findpronum")
    Orders findpronum(@RequestParam(value = "userid") Integer userid, @RequestParam(value = "productid") Integer productid);
}
