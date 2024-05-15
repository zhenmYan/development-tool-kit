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
 * description:
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

    System.out.println(user1 == user2);

    sqlSession.close();
  }
}
