package com.hs.springboot.service;

import com.hs.springboot.entity.User;

import java.util.List;

public interface UserService {
    int add(User user);

    List<User> userList();

    int delUser(int id);

    User toUpdate(int id);

    int updateUser(User user);
}
