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
 * ### MyBatis 缓存
 *
 * #需要修改ERROR为DEBUG，才会打印日志信息，方便查看缓存信息
 * log4j.rootLogger=DEBUG, stdout
 *
 *    1、一级缓存
 *
 *      - 默认开启
 *
 *      - 一级缓存结构
 *        - PerpetualCache的cache，是一个map
 *        - key：CacheKey  value：查询结果，即User对象
 *
 *      - 工作流程
 *        - 查询一级缓存，查不到查询数据库，写到一级缓存中
 *
 *
 *    2、二级缓存
 *
 *      - 默认关闭
 *
 *      - 开启流程
 *        - 在配置文件<settings></setting>标签中配置
 *          - <setting>name = "cacheEnabled" value ="true"</>
 *          - 这个默认为true
 *        - 映射文件中配置<cache><cache/>标签
 *        - 在select标签上添加cache属性，设置为true
 *          - 这个默认为true
 *
 *      - 缓存优先级
 *        - 二级 > 一级
 *
 *      - 注意
 *        - 二级缓存的对象（User对象）有可能存到磁盘，所以需要实现序列化接口
 *        - 此外sqlSession1执行完后需要调用commit或者close方法才能使二级缓存生效（因为事务必须为提交状态）
 *        - key：CacheKey  value：数据，不是User对象，每次重新创建对象，所以结果为false
 *
 *
 *
 *
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
    sqlSession1.commit();

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
