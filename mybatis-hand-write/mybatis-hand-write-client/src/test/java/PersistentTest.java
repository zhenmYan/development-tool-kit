import com.yzm.io.Resources;
import com.yzm.pojo.User;
import com.yzm.sqlSession.*;
import org.junit.Test;

import java.io.InputStream;

/**
 * description: 测试类
 *
 * @author yzm
 * @date 2024/4/13  16:31
 */
public class PersistentTest {

    @Test
    public void test() throws Exception{

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSqlSession();

        User user = new User();
        user.setId(1);
        user.setUserName("yzm");

        User userR = sqlSession.select("user.select", user);

    }
}
