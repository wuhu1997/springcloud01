package com.zl.controller;

import com.zl.bean.Orders;
import com.zl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;
    //@RequestMapping("/list")
    //public List<Orders> orderlist(@RequestParam(value = "userid") Integer userid, Model model) {
    //    System.out.println(userid);
    //    System.out.println("2222222222222222222222");
    //    List<Orders> ordersList = orderService.findAll(userid);
    //    model.addAttribute("ordersList",ordersList);
    //    System.out.println(ordersList);
    //    return ordersList;
    //
    //}
    @RequestMapping("/list")
    public List<Orders> orderlist(@RequestParam(value = "userid") Integer userid,Model model) {
        List<Orders> ordersList = orderService.findAll(userid);
        model.addAttribute("ordersList",ordersList);
        return  ordersList;
    }


    @RequestMapping("/findmax")
    public String findMax(Model model) {
        String ordersmax = orderService.findMax();
        model.addAttribute("ordersmax",ordersmax);
        System.out.println(ordersmax);
        return ordersmax;
    }

    @RequestMapping("/addorder")
    public Integer addOrder(@RequestBody Orders orders, Model model) {
        Integer count = orderService.addOrders(orders);
        model.addAttribute("count",count);
        System.out.println(count);
        return count;
    }

    @RequestMapping("/findpronum")
    public Orders findorder(@RequestParam(value = "userid") Integer userid,@RequestParam(value = "productid") Integer productid,Model model) {
        Orders number = orderService.findorder(userid,productid);
        System.out.println(number);
        //model.addAttribute("number",number);
        return number;
    }

    @RequestMapping("/deleteorder")
    public Integer deleteorder(@RequestParam(value = "orderid") Integer orderid) {
        Integer count = orderService.deleteorder(orderid);
        return count;
    }
}
