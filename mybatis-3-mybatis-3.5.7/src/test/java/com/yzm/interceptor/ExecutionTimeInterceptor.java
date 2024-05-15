package com.yzm.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * ##### MyBatis 插件 原理
 *
 *    记录执行时间的插件
 *
 *
 *   原理
 *      1、在解析plugin标签时，会判断是否配置了拦截器（也可以通过spring boot注入对象），
 *      如果配置则创建拦截器对象，添加到拦截器链interceptorChain中，interceptorChain是Configuration的属性
 *
 *      2、在创建被拦截对象时，如executor，会判断拦截器链中是否需要拦截该对象，如果需要，则创建JDK代理对象
 *
 *   注意顺序
 *
 *      添加到拦截器链中的顺序是按照配置文件的顺序，但是执行的顺序是反的（因为是层层代理的）
 *
 *    @Intercepts 控制拦截的地方
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

  /**
   * 拦截的逻辑
   *
   * @param invocation
   * @return
   * @throws Throwable
   */
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    long start = System.currentTimeMillis();
    Object result = invocation.proceed();
    long end = System.currentTimeMillis();

    // 这里就可以调用Executor的所有方法了，所以看你需要实现什么功能，调用什么方法，这里都能实现
    Executor e = (Executor)invocation.getTarget();
    System.out.println("ExecutionTimeInterceptor::intercept execute...");
    System.out.println("SQL执行时间：" + (end - start) + "毫秒");
    return result;
  }

  /**
   * 将目标对象生成代理对象，添加到拦截器链中
   *
   *    如Object target是statementHandler，那么就是生成statementHandler的代理对象
   *
   * @param target
   * @return
   */
  @Override
  public Object plugin(Object target) {
    // System.out.println("ExecutionTimeInterceptor::plugin execute...");
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    System.out.println("ExecutionTimeInterceptor::setProperties execute...");
    // 这里可以处理插件配置参数
    System.out.println(properties.toString());
  }
}
