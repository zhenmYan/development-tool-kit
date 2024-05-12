package com.yzm.dao;

import com.yzm.pojo.User;
import org.dom4j.DocumentException;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/20
 */
public interface UserMapper {

    User selectOne(User user);

    List<User> selectList() throws IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException, DocumentException;

}
