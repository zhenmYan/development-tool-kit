package com.yzm.cache;

import com.yzm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * ### MyBatis 缓存测试
 *
 * #需要修改ERROR为DEBUG，才会打印日志信息，方便查看缓存信息
 * log4j.rootLogger=DEBUG, stdout
 *
 * @author yzm
 * @date 2024/5/15
 */
public class CacheTest {

  @Test
  public void firstCacheTest() throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    User user1 = new User();
    user1.setId(1);
    user1.setUsername("张三");
    User userR1 = sqlSession.selectOne("com.yzm.mapper.UserMapper.selectOne", user1);

    User user2 = new User();
    user2.setId(1);
    user2.setUsername("张三");
    User userR2 = sqlSession.selectOne("com.yzm.mapper.UserMapper.selectOne", user2);

    System.out.println(userR1 == userR2);

    sqlSession.close();
  }

  @Test
  public void secCacheTest() throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession1 = sqlSessionFactory.openSession();

    User user1 = new User();
    user1.setId(1);
    user1.setUsername("张三");
    User userR1 = sqlSession1.selectOne("com.yzm.mapper.UserMapper.selectOne", user1);

    SqlSession sqlSession2 = sqlSessionFactory.openSession();

    User user2 = new User();
    user2.setId(1);
    user2.setUsername("张三");
    User userR2 = sqlSession2.selectOne("com.yzm.mapper.UserMapper.selectOne", user2);

    System.out.println(userR1 == userR2);

    sqlSession1.close();
    sqlSession2.close();
  }
}
