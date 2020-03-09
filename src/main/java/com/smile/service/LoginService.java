package com.smile.service;

import com.smile.pojo.Login;

import java.util.List;

/**
 * @时间 2020/3/4 10:29
 * @作者 liutao
 * @描述
 */
public interface LoginService {

    List<Login> selectAllLogin();
}
