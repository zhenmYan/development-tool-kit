package com.yzm.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  22:50
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user =sqlSession.selectOne("com.yzm.pojo.mapper.UserMapper.findUserById", 1);
        System.out.println(user);
        sqlSession.close();
    }

}
