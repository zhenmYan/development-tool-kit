package com.yzm.mapper;

import com.yzm.pojo.User;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/5/14
 */
public interface UserMapper {

  User selectOne(User user);

  List<User> selectList() throws IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException;

}
