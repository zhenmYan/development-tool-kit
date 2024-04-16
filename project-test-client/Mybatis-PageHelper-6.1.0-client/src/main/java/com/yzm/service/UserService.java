package com.yzm.service;

import com.yzm.dao.User;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/16  18:55
 */
public interface UserService {
    User selectById(int id);
}
