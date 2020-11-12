package com.zl.service.impl;

import com.zl.bean.Orders;
import com.zl.dao.OrdersDao;
import com.zl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersDao ordersDao;
    //@Override
    //public List<Orders> findAll(Integer userid) {
    //    return ordersDao.findAll(userid);
    //}
    public List<Orders> findAll(Integer userid) {
        return ordersDao.findAll(userid);
    }

    @Override
    public String findMax() {
        return ordersDao.findMax();
    }

    @Override
    public Integer addOrders(Orders orders) {
        return ordersDao.addOrders(orders);
    }

    @Override
    public Integer deleteorder(Integer orderid) {
        return ordersDao.deleteorder(orderid);
    }

    @Override
    public Orders findorder(Integer userid, Integer productid) {
        return ordersDao.findorder(userid, productid);
    }


}
