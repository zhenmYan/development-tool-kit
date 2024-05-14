package com.yzm.test;

import com.yzm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * description:
 *
 * @author yzm
 * @date 2024/5/13
 */
public class MybatisTest {

  @Test
  public void test() throws Exception{

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

    /**
     * 3、创建事务对象，创建cachingExecutor，创建DefaultSqlSession
     */
    SqlSession sqlSession = sqlSessionFactory.openSession();

    User user = new User();
    user.setId(1);
    user.setUsername("张三");

    // 4、委派给Executor，Executor会委派给其他很多handler，进行参数设置，sql执行，结果集封装
    User userR = sqlSession.selectOne("com.yzm.dao.UserMapper.selectOne", user);

    System.out.println(userR.toString());
    // 5、释放资源
    sqlSession.close();
  }
}
