package com.zl.feign;

import com.zl.bean.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("orders-provider")
public interface OrdersClient {
   @RequestMapping("/orders/list")
   //List<Orders> findAll(@RequestParam(value = "userid") Integer userid);
    List<Orders> findAll(@RequestParam(value = "userid") Integer userid);
}
