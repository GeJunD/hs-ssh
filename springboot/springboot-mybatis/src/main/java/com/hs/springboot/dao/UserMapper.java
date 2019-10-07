package com.hs.springboot.dao;

import com.hs.springboot.entity.User;

import java.util.List;

public interface UserMapper {
    int add(User user);

    List<User> userList();

    int delUser(int id);

    User toUpdate(int id);

    int updateUser(User user);
}
