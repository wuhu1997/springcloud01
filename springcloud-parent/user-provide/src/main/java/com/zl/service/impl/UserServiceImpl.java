package com.zl.service.impl;

import com.zl.bean.User;
import com.zl.dao.UserDao;
import com.zl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    static  int id;
    @Autowired
    private UserDao userDao;

    //@Autowired
    //private RedisTemplate redisTemplate;
    @Override
    public User find(String username, String password) {
        //String key = "user"+id;
        //System.out.println(key);
        ////先看缓存中是否有数据
        //User users = (User) redisTemplate.boundValueOps(key).get();
        ////如果有，直接取缓存数据
        //if(users!=null){
        //    System.out.println("数据来源于Redis");
        //    return users;
        //}
        //
        ////如果没有，则查询数据
        //users = userDao.find(username,password);
        //System.out.println("数据来源于mysql");
        ////Integer id = users.getId();
        ////再将数据存入到缓存
        //redisTemplate.boundValueOps(key).set(users);
        User users = userDao.find(username, password);
        System.out.println(users);
        return  users;
    }
}
