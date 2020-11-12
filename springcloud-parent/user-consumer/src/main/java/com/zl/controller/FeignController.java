package com.zl.controller;

import com.zl.bean.Orders;
import com.zl.bean.Product;
import com.zl.bean.User;
import com.zl.feign.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private UserClient userClient;
    @Autowired
    private ProductClient productClient;
    @Autowired
    private ProFindClient proFindClient;
    @Autowired
    private OrdersClient ordersClient;
    @Autowired
    private FindMaxClient findMaxClient;
    @Autowired
    private AddOrdersClient addOrdersClient;
    @Autowired
    private FindNumClient findNumClient;
    @Autowired
    private DeleteOrderClient deleteOrderClient;
    @RequestMapping(value = "/userfind")
    public String userfind(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, Model model) {
        User user = userClient.find(username, password);
        if (user!=null){
            System.out.println("登录成功");
            model.addAttribute("user",user);
            Integer userid = user.getId();
            return "redirect:/feign/productfind?userid="+userid;
        }
        return null;
    }

    @RequestMapping("/productfind")
    public String productfind(Integer userid, Model model) {
        List<Product> products = productClient.find();
        model.addAttribute("userid",userid);
        model.addAttribute("products",products);
        return "product-list";
    }

    @RequestMapping("/profindid")
    public String profindid(@RequestParam(value = "id") Integer id,Model model) {
        Product product = proFindClient.findbyid(id);
        model.addAttribute("product",product);
        return "product";
    }

    //@RequestMapping("/ordersfind")
    //public String ordersfind(@RequestParam(value = "userid") Integer userid,Model model) {
    //    List<Orders> ordersList = ordersClient.findAll(userid);
    //    System.out.println(ordersList);
    //    System.out.println(userid);
    //    System.out.println(ordersList);
    //    model.addAttribute("ordersList",ordersList);
    //    return "orders-list";
    //}
    @RequestMapping("/ordersfind")
    public String ordersfind(@RequestParam(value = "userid") Integer userid,Model model) {
        List<Orders> ordersList = ordersClient.findAll(userid);
        model.addAttribute("ordersList",ordersList);
        return "orders-list";
    }

    @RequestMapping("/orderadd")
    public String orderadd(Integer userid,Integer productid,String productname,Integer price){
        String ordermax = findMaxClient.findMax();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // 时间字符串产生方式
        String uid_pfix = "GL" + format.format(new Date()); // 组合流水号前一部分，NO+时间字符串，如：NO20160126
        if (ordermax != null && ordermax.contains(uid_pfix)) {
            String uid_end = ordermax.substring(10, 16); // 截取字符串最后四六位，结果:000002
            int endNum = Integer.parseInt(uid_end); // 把String类型的000002转化为int类型的2
            int tmpNum = 1000000 + endNum + 1; // 结果1000003
            String tmpVar = String.valueOf(tmpNum);
            ordermax = uid_pfix + tmpVar.substring(1, 7) ;// 把1000003首位的1去掉，再拼成NO201601260002字符串
        } else {
            ordermax = uid_pfix + "000001";
        }
        Orders orders = new Orders();
        Orders order = findNumClient.findpronum(userid, productid);

        if (order==null){
            orders.setNumber(1);
        }else {
            int findpronum = order.getNumber();
            int orderid = order.getId();
            Integer count = deleteOrderClient.deleteorder(orderid);
            int number = findpronum+1;
            orders.setNumber(number);
        }

        orders.setOrdersnum(ordermax);
        orders.setUserid(userid);
        orders.setProductid(productid);
        orders.setOrderStatus(0);
        //System.out.println(orders);
        Integer count = addOrdersClient.addOrder(orders);
        return "redirect:/feign/ordersfind?userid="+userid;
    }

    @RequestMapping("/deleteorder")
    public String deleteorder(@RequestParam (value = "orderid") Integer orderid,@RequestParam (value = "userid") Integer userid) {
        Integer count = deleteOrderClient.deleteorder(orderid);
        return "redirect:/feign/ordersfind?userid="+userid;
    }
    @RequestMapping("/phyment")
    public String phyment(@RequestParam(value = "productid") Integer productid,@RequestParam(value = "orderid") Integer orderid,@RequestParam (value = "userid") Integer userid) {
        Orders order = findNumClient.findpronum(userid,productid);
        order.setOrderStatus(1);
        Integer count1 = deleteOrderClient.deleteorder(orderid);
        Integer count2 = addOrdersClient.addOrder(order);
        return "redirect:/feign/ordersfind?userid="+userid;
    }
}
