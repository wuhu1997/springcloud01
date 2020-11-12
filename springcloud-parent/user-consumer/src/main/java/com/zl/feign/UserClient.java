package com.zl.feign;

import com.zl.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@FeignClient("user-provider")
public interface UserClient {
    @RequestMapping(value = "/user/find")
    User find(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password);
}
