package com.smile.mapper.slaver;

import com.smile.pojo.Login;

import java.util.List;

/**
 * @时间 2020/3/4 10:27
 * @作者 liutao
 * @描述
 */
public interface LoginMapper {

    List<Login> selectAllLogin();
}
