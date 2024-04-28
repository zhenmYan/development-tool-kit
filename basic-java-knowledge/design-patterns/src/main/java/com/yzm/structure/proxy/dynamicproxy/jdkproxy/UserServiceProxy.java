package com.yzm.structure.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ##### 设计模式 design patterns 动态代理
 *
 *      1、JDK动态代理
 *          - 实现InvocationHandler接口
 *          - newProxyInstance的三个重要参数
 *              - 类加载器
 *              - 接口数组
 *              - 代理对象
 *          - 为什么JDK只能代理接口
 *              - 临时生成的代理对象$Proxy0继承了Proxy类，而Java单继承
 *
 *      2、Cglib动态代理
 *          - 实现MethodInterceptor接口
 *          - 基于Enhancer类
 *          - 其实质是生成被代理类的子类，所以不需要定义接口
 *
 * @author yzm
 * @date 2024/4/28
 */
public class UserServiceProxy implements InvocationHandler {

    // 被代理类
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(
                // 类加载器
                this.getClass().getClassLoader(),
                // 接口数组
                target.getClass().getInterfaces(),
                // InvocationHandler
                this);
    }

    // proxy : 代理类
    // method : 代理类的调用处理程序的方法对象.
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    public void log(String methodName){
        System.out.println("执行了"+methodName+"方法");
    }

}
