package com.zl.dao;

import com.zl.bean.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface OrdersDao {
    @Select("select orders.id as oid,orders.userid,orders.productid,orders.ordersnum,orders.number,orders.orderstatus,product.* from orders,product where orders.productid=product.id and orders.userid=#{userid}")
    @Results(value = {
            @Result(id = true,property = "id",column = "oid"),
            @Result(property = "userid",column = "userid"),
            @Result(property = "productid",column = "productid"),
            @Result(property = "ordersnum", column = "ordersnum"),
            @Result(property = "number", column = "number"),
            @Result(property = "orderstatus", column = "orderstatus"),
            @Result(property = "product.id",column = "id"),
            @Result(property = "product.productname",column = "productname"),
            @Result(property = "product.price", column = "price"),
    })
    List<Orders> findAll(Integer userid);
    //@Select("select * from orders")
    //List<Orders> findAll();

    @Select("SELECT MAX(ordersnum) FROM orders")
     String findMax();

    @Insert("insert into orders (ordersnum,userid,productid,number,orderStatus) values(#{ordersnum},#{userid},#{productid},#{number},#{orderStatus})")
    Integer addOrders(Orders orders);

    @Delete("delete from orders where id=#{orderid}")
    Integer deleteorder(Integer orderid);

    @Select("select orders.id as oid,orders.userid,orders.productid,orders.ordersnum,orders.number,orders.orderstatus,product.* from orders,product where orders.productid=product.id and orders.userid=#{userid} and product.id=#{productid}")
    @Results(value = {
            @Result(id = true,property = "id",column = "oid"),
            @Result(property = "userid",column = "userid"),
            @Result(property = "productid",column = "productid"),
            @Result(property = "ordersnum", column = "ordersnum"),
            @Result(property = "number", column = "number"),
            @Result(property = "orderstatus", column = "orderstatus"),
            @Result(property = "product.id",column = "id"),
            @Result(property = "product.productname",column = "productname"),
            @Result(property = "product.price", column = "price"),
    })
    Orders findorder(@Param(value ="userid") Integer userid,@Param(value ="productid") Integer productid);

}
