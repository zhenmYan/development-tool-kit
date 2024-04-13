package com.yzm.dao;

import com.yzm.pojo.User;

import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  19:13
 */
public interface UserDao {

    User select(int id, String userName);

    List<User> selectAll();

}
