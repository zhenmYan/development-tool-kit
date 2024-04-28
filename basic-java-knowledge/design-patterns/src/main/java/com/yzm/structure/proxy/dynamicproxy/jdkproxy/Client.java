package com.yzm.structure.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/28
 */
public class Client {
    public static void main(String[] args) {
        //真实业务
        UserServiceImpl userService = new UserServiceImpl();
        //代理类
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setTarget(userService);
        //使用代理类实现日志功能！
        UserService proxy = (UserService)userServiceProxy.getProxy();
        proxy.add();

        // 代理对象的类型：com.sun.proxy.$Proxy0
        System.out.println(proxy.getClass());

        // 用于查看代理对象
        while (true){}
    }

//    /**
//     * 通过Arthas工具生成的代理对象
//     */
//    public final class $Proxy0 extends Proxy implements UserService {
//        private static Method m1;
//        private static Method m6;
//        private static Method m2;
//        private static Method m3;
//        private static Method m5;
//        private static Method m0;
//        private static Method m4;
//
//        /**
//         *   invocationHandler即下面的h
//         *
//         *   也是UserServiceProxy中getProxy()方法里Proxy.newProxyInstance的第三个入参，this，即UserServiceProxy的对象
//         */
//        public $Proxy0(InvocationHandler invocationHandler) {
//            super(invocationHandler);
//        }
//
//        static {
//            try {
//                m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
//                m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
//                m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
//                m6 = Class.forName("com.yzm.structure.proxy.dynamicproxy.jdkproxy.UserService").getMethod("query", new Class[0]);
//                m3 = Class.forName("com.yzm.structure.proxy.dynamicproxy.jdkproxy.UserService").getMethod("add", new Class[0]);
//                m5 = Class.forName("com.yzm.structure.proxy.dynamicproxy.jdkproxy.UserService").getMethod("delete", new Class[0]);
//                m4 = Class.forName("com.yzm.structure.proxy.dynamicproxy.jdkproxy.UserService").getMethod("update", new Class[0]);
//                return;
//            }
//            catch (NoSuchMethodException noSuchMethodException) {
//                throw new NoSuchMethodError(noSuchMethodException.getMessage());
//            }
//            catch (ClassNotFoundException classNotFoundException) {
//                throw new NoClassDefFoundError(classNotFoundException.getMessage());
//            }
//        }
//
//        public final void add() {
//            try {
//                /**
//                 *  h是Proxy内定义的InvocationHandler类，也就是上面构造方法的入参
//                 *
//                 *  所以这里是调用UserServiceProxy的对象的invoke方法
//                 */
//                this.h.invoke(this, m3, null);
//                return;
//            }
//            catch (Error | RuntimeException throwable) {
//                throw throwable;
//            }
//            catch (Throwable throwable) {
//                throw new UndeclaredThrowableException(throwable);
//            }
//        }
//
//        public final boolean equals(Object object) {
//            try {
//                return (Boolean)this.h.invoke(this, m1, new Object[]{object});
//            }
//            catch (Error | RuntimeException throwable) {
//                throw throwable;
//            }
//            catch (Throwable throwable) {
//                throw new UndeclaredThrowableException(throwable);
//            }
//        }
//
//        public final String toString() {
//            try {
//                return (String)this.h.invoke(this, m2, null);
//            }
//            catch (Error | RuntimeException throwable) {
//                throw throwable;
//            }
//            catch (Throwable throwable) {
//                throw new UndeclaredThrowableException(throwable);
//            }
//        }
//
//        public final int hashCode() {
//            try {
//                return (Integer)this.h.invoke(this, m0, null);
//            }
//            catch (Error | RuntimeException throwable) {
//                throw throwable;
//            }
//            catch (Throwable throwable) {
//                throw new UndeclaredThrowableException(throwable);
//            }
//        }
//
//        public final void update() {
//            try {
//                this.h.invoke(this, m4, null);
//                return;
//            }
//            catch (Error | RuntimeException throwable) {
//                throw throwable;
//            }
//            catch (Throwable throwable) {
//                throw new UndeclaredThrowableException(throwable);
//            }
//        }
//
//        public final void delete() {
//            try {
//                this.h.invoke(this, m5, null);
//                return;
//            }
//            catch (Error | RuntimeException throwable) {
//                throw throwable;
//            }
//            catch (Throwable throwable) {
//                throw new UndeclaredThrowableException(throwable);
//            }
//        }
//
//        public final void query() {
//            try {
//                this.h.invoke(this, m6, null);
//                return;
//            }
//            catch (Error | RuntimeException throwable) {
//                throw throwable;
//            }
//            catch (Throwable throwable) {
//                throw new UndeclaredThrowableException(throwable);
//            }
//        }
//    }
}
