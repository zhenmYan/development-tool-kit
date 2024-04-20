package yzm.test;

import com.yzm.dao.UserMapper;
import com.yzm.io.Resources;
import com.yzm.pojo.User;
import com.yzm.sqlSession.*;
import org.junit.Test;

import java.io.InputStream;

/**
 * description: 测试类
 *
 * @author yzm
 * @date 2024/4/13
 */
public class HandWriteMybatisTest {

    /**
     * 不使用mapper代理测试
     *
     * @throws Exception
     */
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

        // 3、创建SqlSession、创建sql执行器Executor
        SqlSession sqlSession = sqlSessionFactory.openSqlSession();

        User user = new User();
        user.setId(1);
        user.setUsername("张三");

        // 调用 sqlSession 的方法
        User userR = sqlSession.selectOne("user.selectOne", user);

        System.out.println(userR.toString());
        sqlSession.close();

    }

    /**
     * 动态代理的测试
     *
     * 之后这些对象的创建交给spring boot去完成
     *
     * @throws Exception
     */
    @Test
    public void proxyTest() throws Exception{
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
        SqlSession sqlSession = sqlSessionFactory.openSqlSession();

        // 返回代理对象
        UserMapper userMapperProxy = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        User userR = userMapperProxy.selectOne(user);

        System.out.println(userR.toString());
        sqlSession.close();

    }
}
