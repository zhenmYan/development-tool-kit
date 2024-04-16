package com.yzm.service;

import com.github.pagehelper.PageInfo;
import com.yzm.dao.User;

import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/16  18:55
 */
public interface UserService {
    User selectById(int id);
    PageInfo<User> selectUserList(int pageNum, int pageSize);
}
