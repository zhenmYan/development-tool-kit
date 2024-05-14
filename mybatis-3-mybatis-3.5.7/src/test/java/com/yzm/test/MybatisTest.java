package com.yzm.test;

import com.yzm.mapper.UserMapper;
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
    User userR = sqlSession.selectOne("com.yzm.mapper.UserMapper.selectOne", user);

    System.out.println(userR.toString());
    // 5、释放资源
    sqlSession.close();
  }

  /**
   * 代理方式
   *
   * @throws Exception
   */
  @Test
  public void ProxyTest() throws Exception{

    // 1、根据配置文件路径加载字节输入流，存入内存中
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

    /**
     * 2、创建SqlSessionFactory，解析mybatis-config.xml字节流，将配置文件内容存储到Configuration、MappedStatement对象
     *
     *     - Configuration类：全局配置类，存储mybatis-config.xml解析出的内容
     *     - MappedStatement类：映射配置类，存储mapper.xml解析出的内容
     *
     */
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    /**
     * 3、创建事务对象，创建cachingExecutor，创建DefaultSqlSession
     */
    SqlSession sqlSession = sqlSessionFactory.openSession();

    /**
     * 4、##### Mybatis mapper代理
     *
     *    问题1：<package name="com.yzm.mapper"></package>如何解析
     *      - 扫描配置文件，根据name属性的值加载该包下的所有mapper接口
     *      - 将mapper接口及代理工厂对象存到knowMappers中
     *      - 替换mapper接口的路径，定位到对应的映射配置文件，通过XmlMapperBuilder进行解析，存到mappedStatement中
     *
     *    问题2：sqlSession.getMapper(UserMapper.class)如何生成代理对象
     *      - 通过type 到 knownMappers 中获取代理工厂对象 MapperProxyFactory
     *      - 通过 mapperProxyFactory 生成mapperProxy， mapperProxy产生mapper代理对象
     *      - mapperProxy 通过jdk动态代理生成对象
     *        - return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),
     *          new Class[] { mapperInterface }, mapperProxy);
     *
     *    问题3：User userR = userMapperProxy.selectOne(user);怎么执行的
     *      - 实际执行invoke方法
     *      - 根据type判断执行类型
     *
      */
    UserMapper userMapperProxy = sqlSession.getMapper(UserMapper.class);

    User user = new User();
    user.setId(1);
    user.setUsername("张三");
    User userR = userMapperProxy.selectOne(user);


    System.out.println(userR.toString());
    sqlSession.close();

    // 5、释放资源
    sqlSession.close();
  }
}
