package com.zl.service;

import com.zl.bean.Orders;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    //List<Orders> findAll(Integer userid);
    List<Orders> findAll(Integer userid);
    String findMax();
    Integer addOrders(Orders orders);
    Integer deleteorder(Integer orderid);
    Orders findorder(Integer userid,Integer productid);
}
