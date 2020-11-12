package com.zl.dao;

import com.zl.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductDao {

    @Select("select * from product")
    List<Product> find();

    @Select("select * from product where id=#{id}")
    Product findByid(Integer id);
}
