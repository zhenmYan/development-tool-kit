package com.yzm.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;

/**
 * description:
 *
 * @author yzm
 * @date 2024/5/15
 */
@Intercepts({@Signature(
  type = StatementHandler.class,
  method = "prepare",
  args = {Connection.class, Integer.class})
})
public class SQLModifierInterceptor implements Interceptor {
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    StatementHandler handler = (StatementHandler) invocation.getTarget();
    BoundSql boundSql = handler.getBoundSql();
    String originalSql = boundSql.getSql();

    // 修改SQL语句
//    String modifiedSql = originalSql + " WHERE status = 'ACTIVE'";
    String modifiedSql = originalSql;
    Field sqlField = BoundSql.class.getDeclaredField("sql");
    sqlField.setAccessible(true);
    sqlField.set(boundSql, modifiedSql);
    System.out.println("SQLModifierInterceptor::intercept execute...");
    // 继续执行其他拦截器或原方法
    return invocation.proceed();
  }

  @Override
  public Object plugin(Object target) {
    // System.out.println("SQLModifierInterceptor::plugin execute...");
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    // 这里可以处理配置文件中传入的参数
    System.out.println("SQLModifierInterceptor::setProperties execute...");
    System.out.println(properties.toString());
  }
}
