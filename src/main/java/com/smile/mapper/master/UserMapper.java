package com.smile.mapper.master;

import com.smile.pojo.User;

import java.util.List;

/**
 * @时间 2020/3/4 9:47
 * @作者 liutao
 * @描述
 */
public interface UserMapper {

    List<User> selectUserAll();
}
