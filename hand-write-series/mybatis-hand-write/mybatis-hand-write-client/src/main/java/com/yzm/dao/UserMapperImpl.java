package com.yzm.dao;

import com.yzm.io.Resources;
import com.yzm.pojo.User;
import com.yzm.sqlSession.SqlSession;
import com.yzm.sqlSession.SqlSessionFactory;
import com.yzm.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/20
 */
public class UserMapperImpl {

    /**
     *  问题：
     *
     *      1、代码重复
     *          第1、2、3步是重复的
     *      2、statementId 硬编码
     *
     *  解决思路：
     *      动态代理
     *
     */
    public User selectOne()
            throws IllegalAccessException, IntrospectionException, InstantiationException,
            NoSuchFieldException, SQLException, InvocationTargetException,
            ClassNotFoundException, DocumentException {
        // 1、根据配置文件路径加载字节输入流，存入内存中
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        /**
         *   2、创建SqlSessionFactory，解析mybatis-config.xml字节流，将配置文件内容存储到Configuration、MappedStatement对象
         *
         *         - Configuration类：全局配置类，存储mybatis-config.xml解析出的内容
         *         - MappedStatement类：映射配置类，存储mapper.xml解析出的内容
         *
         */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3、创建SqlSession、创建sql执行器Executor
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setUsername("张三");

        // 调用 sqlSession 的方法
        User userR = sqlSession.selectOne("user.selectOne", user);

        System.out.println(userR.toString());
        return null;
    }

    public List<User> selectList(User user) {
        return null;
    }

}
