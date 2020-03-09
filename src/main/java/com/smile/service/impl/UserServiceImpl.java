package com.smile.service.impl;


import com.smile.mapper.master.UserMapper;
import com.smile.pojo.User;
import com.smile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @时间 2020/3/4 10:30
 * @作者 liutao
 * @描述
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserAll() {
        return userMapper.selectUserAll();
    }
}
