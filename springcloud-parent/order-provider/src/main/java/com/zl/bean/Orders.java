package com.zl.bean;

import java.io.Serializable;

public class Orders implements Serializable {
    private int id;
    private String ordersnum;
    private int userid;
    private int productid;
    private int number;
    private int orderstatus;
    private Product product;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ordersnum='" + ordersnum + '\'' +
                ", userid=" + userid +
                ", productid=" + productid +
                ", number=" + number +
                ", orderStatus=" + orderstatus +
                ", product=" + product +
                '}';
    }

    public int getOrderStatus() {
        return orderstatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderstatus = orderStatus;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdersnum() {
        return ordersnum;
    }

    public void setOrdersnum(String ordersnum) {
        this.ordersnum = ordersnum;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
