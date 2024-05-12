package yzm.test;

import com.yzm.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * description: ##### JDBC
 *
 * 一、JDBC执行步骤
 *      1、加载驱动
 *      2、获取连接
 *      3、创建PreparedStatement
 *      4、查询结果
 *      5、结果集解析
 *      6、资源释放
 *
 *  二、问题分析
 *      1、硬编码
 *      2、频繁创建并释放连接
 *      3、解析结果集十分繁琐
 *
 *  三、解决思路
 *      1、连接信息、SQL等信息配置在文件中
 *      2、通过框架去控制连接、释放资源、解析结果集
 *
 * @author yzm
 * @date 2024/4/19
 */
public class JdbcTest {

    @Test
    public void test() throws Exception{
        // 1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2、获取连接
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test" +
                                "?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC"
                        ,"root","123");
        String sql = "select * from user where username = ?";
        // 3、创建PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"王五");
        // 4、查询结果
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> result = new ArrayList<User>();
        // 5、结果集解析
        while (resultSet.next()){
            User user = new User();
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            result.add(user);
        }
        // 6、资源释放
        connection.close();
        preparedStatement.close();
        resultSet.close();

        for(User user:result){
            System.out.println(user.toString());
        }
    }
}
