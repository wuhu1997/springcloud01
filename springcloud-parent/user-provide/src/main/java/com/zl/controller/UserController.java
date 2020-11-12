package com.zl.controller;

import com.zl.bean.User;
import com.zl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/find")
    //public User find(@PathVariable (value = "username") String username,@PathVariable (value = "password") String password) {
      public User find(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password){
        System.out.println(username+password);
        User user = userService.find(username,password);
        if (user != null) {
            System.out.println(user);
        }
        return user;
    }


}