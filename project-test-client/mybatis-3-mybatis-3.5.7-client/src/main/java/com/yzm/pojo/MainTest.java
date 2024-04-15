package com.yzm.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.TreeSet;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  22:50
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        // 1、找到一个合适的类加载器对类进行加载，加载成字节输入流
        // 配置文件并没有被解析，只被加载
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user =sqlSession.selectOne("user.findUserById", 1);
        System.out.println(user);
        sqlSession.close();
    }

}
