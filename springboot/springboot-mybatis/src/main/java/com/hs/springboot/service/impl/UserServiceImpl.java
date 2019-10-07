package com.hs.springboot.service.impl;

import com.hs.springboot.dao.UserMapper;
import com.hs.springboot.entity.User;
import com.hs.springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }

    @Override
    public int delUser(int id) {
        return userMapper.delUser(id);
    }

    @Override
    public User toUpdate(int id) {
        return userMapper.toUpdate(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
