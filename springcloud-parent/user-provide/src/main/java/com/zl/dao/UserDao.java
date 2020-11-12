package com.zl.dao;

import com.zl.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user where username=#{username} and password=#{password}")
    User find(@Param(value = "username") String username,@Param(value = "password") String password);
}
