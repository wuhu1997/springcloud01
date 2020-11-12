package com.zl.service;

import com.zl.bean.User;

import java.util.List;

public interface UserService {
    User find(String username, String password);
}
