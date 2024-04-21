package com.yzm.mybatis.test;


import com.yzm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/21
 */
public class MybatisTest {

    /**
     * 传统方式：即只用配置文件进行数据库操作
     */
    @Test
    public void test() throws IOException {
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
        sqlSession.close();
    }
}
