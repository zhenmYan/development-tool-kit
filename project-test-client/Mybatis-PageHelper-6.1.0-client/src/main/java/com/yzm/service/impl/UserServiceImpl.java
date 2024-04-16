package com.yzm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzm.dao.User;
import com.yzm.mapper.UserMapper;
import com.yzm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/16  18:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectById(int id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public PageInfo<User> selectUserList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        List<User> userList = pageInfo.getList();
        return pageInfo;
    }
}
