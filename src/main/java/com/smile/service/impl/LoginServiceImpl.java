package com.smile.service.impl;


import com.smile.mapper.slaver.LoginMapper;
import com.smile.pojo.Login;
import com.smile.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @时间 2020/3/4 10:30
 * @作者 liutao
 * @描述
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<Login> selectAllLogin() {
        return loginMapper.selectAllLogin();
    }
}
