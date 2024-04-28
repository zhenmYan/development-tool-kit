package com.yzm.structure.proxy.dynamicproxy.cglibproxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  Cglib代理
 *
 * @author yzm
 * @date 2024/4/28
 */
public class UserServiceProxy implements MethodInterceptor {

    // 被代理类
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        // 1、创建Enhancer对象，类似JDK的Proxy类
        Enhancer enhancer = new Enhancer();
        // 2、设置父类的字节码对象
        enhancer.setSuperclass(target.getClass());
        // 3、设置回调函数
        enhancer.setCallback(this);
        // 4、创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log(method.toString());
        method.invoke(target, objects);
        return null;
    }

    public void log(String methodName){
        System.out.println("执行了"+methodName+"方法");
    }
}
