package com.yzm.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * ##### MyBatis 插件
 *
 *    记录执行时间的插件
 *
 * @author yzm
 * @date 2024/5/15
 */
@Intercepts({@Signature(
  type = Executor.class,
  method = "query",
  args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class ExecutionTimeInterceptor implements Interceptor {
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    long start = System.currentTimeMillis();
    Object result = invocation.proceed();
    long end = System.currentTimeMillis();
    System.out.println("SQL执行时间：" + (end - start) + "毫秒");
    return result;
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    // 这里可以处理插件配置参数
  }
}
