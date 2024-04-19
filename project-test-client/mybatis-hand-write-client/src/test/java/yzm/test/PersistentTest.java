package yzm.test;

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
public class PersistentTest {

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

        SqlSession sqlSession = sqlSessionFactory.openSqlSession();

        User user = new User();
        user.setId(1);
        user.setUserName("yzm");

        User userR = sqlSession.select("user.select", user);

    }
}
