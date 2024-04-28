package com.yzm.structure.proxy.dynamicproxy.cglibproxy;

import com.yzm.structure.proxy.dynamicproxy.jdkproxy.UserService;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/28
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setTarget(userService);
        UserServiceImpl proxy = (UserServiceImpl)userServiceProxy.getProxy();
        proxy.add();

        // 代理对象的类型：com.sun.proxy.$Proxy0
        System.out.println(proxy.getClass());
        // 用于查看代理对象
        while (true){}
    }

//    public class UserServiceImpl$$EnhancerByCGLIB$$29f2bee extends UserServiceImpl implements Factory {
//        private boolean CGLIB$BOUND;
//        public static Object CGLIB$FACTORY_DATA;
//        private static final ThreadLocal CGLIB$THREAD_CALLBACKS;
//        private static final Callback[] CGLIB$STATIC_CALLBACKS;
//        private MethodInterceptor CGLIB$CALLBACK_0;
//        private static Object CGLIB$CALLBACK_FILTER;
//        private static final Method CGLIB$add$0$Method;
//        private static final MethodProxy CGLIB$add$0$Proxy;
//        private static final Object[] CGLIB$emptyArgs;
//        private static final Method CGLIB$update$1$Method;
//        private static final MethodProxy CGLIB$update$1$Proxy;
//        private static final Method CGLIB$delete$2$Method;
//        private static final MethodProxy CGLIB$delete$2$Proxy;
//        private static final Method CGLIB$query$3$Method;
//        private static final MethodProxy CGLIB$query$3$Proxy;
//        private static final Method CGLIB$equals$4$Method;
//        private static final MethodProxy CGLIB$equals$4$Proxy;
//        private static final Method CGLIB$toString$5$Method;
//        private static final MethodProxy CGLIB$toString$5$Proxy;
//        private static final Method CGLIB$hashCode$6$Method;
//        private static final MethodProxy CGLIB$hashCode$6$Proxy;
//        private static final Method CGLIB$clone$7$Method;
//        private static final MethodProxy CGLIB$clone$7$Proxy;
//
//        public UserServiceImpl$$EnhancerByCGLIB$$29f2bee() {
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee userServiceImpl$$EnhancerByCGLIB$$29f2bee = this;
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(userServiceImpl$$EnhancerByCGLIB$$29f2bee);
//        }
//
//        static {
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$STATICHOOK1();
//        }
//
//        public final void add() {
//            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//            if (methodInterceptor == null) {
//                UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(this);
//                methodInterceptor = this.CGLIB$CALLBACK_0;
//            }
//            if (methodInterceptor != null) {
//                // 实际调用的是UserServiceProxy::intercept方法
//                Object object = methodInterceptor.intercept(this, CGLIB$add$0$Method, CGLIB$emptyArgs, CGLIB$add$0$Proxy);
//                return;
//            }
//            super.add();
//        }
//
//        public final boolean equals(Object object) {
//            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//            if (methodInterceptor == null) {
//                UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(this);
//                methodInterceptor = this.CGLIB$CALLBACK_0;
//            }
//            if (methodInterceptor != null) {
//                Object object2 = methodInterceptor.intercept(this, CGLIB$equals$4$Method, new Object[]{object}, CGLIB$equals$4$Proxy);
//                return object2 == null ? false : (Boolean)object2;
//            }
//            return super.equals(object);
//        }
//
//        public final String toString() {
//            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//            if (methodInterceptor == null) {
//                UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(this);
//                methodInterceptor = this.CGLIB$CALLBACK_0;
//            }
//            if (methodInterceptor != null) {
//                return (String)methodInterceptor.intercept(this, CGLIB$toString$5$Method, CGLIB$emptyArgs, CGLIB$toString$5$Proxy);
//            }
//            return super.toString();
//        }
//
//        public final int hashCode() {
//            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//            if (methodInterceptor == null) {
//                UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(this);
//                methodInterceptor = this.CGLIB$CALLBACK_0;
//            }
//            if (methodInterceptor != null) {
//                Object object = methodInterceptor.intercept(this, CGLIB$hashCode$6$Method, CGLIB$emptyArgs, CGLIB$hashCode$6$Proxy);
//                return object == null ? 0 : ((Number)object).intValue();
//            }
//            return super.hashCode();
//        }
//
//        protected final Object clone() throws CloneNotSupportedException {
//            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//            if (methodInterceptor == null) {
//                UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(this);
//                methodInterceptor = this.CGLIB$CALLBACK_0;
//            }
//            if (methodInterceptor != null) {
//                return methodInterceptor.intercept(this, CGLIB$clone$7$Method, CGLIB$emptyArgs, CGLIB$clone$7$Proxy);
//            }
//            return super.clone();
//        }
//
//        public final void update() {
//            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//            if (methodInterceptor == null) {
//                UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(this);
//                methodInterceptor = this.CGLIB$CALLBACK_0;
//            }
//            if (methodInterceptor != null) {
//                Object object = methodInterceptor.intercept(this, CGLIB$update$1$Method, CGLIB$emptyArgs, CGLIB$update$1$Proxy);
//                return;
//            }
//            super.update();
//        }
//
//        @Override
//        public Object newInstance(Callback[] callbackArray) {
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$SET_THREAD_CALLBACKS(callbackArray);
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee userServiceImpl$$EnhancerByCGLIB$$29f2bee = new UserServiceImpl$$EnhancerByCGLIB$$29f2bee();
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$SET_THREAD_CALLBACKS(null);
//            return userServiceImpl$$EnhancerByCGLIB$$29f2bee;
//        }
//
//        @Override
//        public Object newInstance(Class[] classArray, Object[] objectArray, Callback[] callbackArray) {
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee userServiceImpl$$EnhancerByCGLIB$$29f2bee;
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$SET_THREAD_CALLBACKS(callbackArray);
//            Class[] classArray2 = classArray;
//            switch (classArray.length) {
//                case 0: {
//                    userServiceImpl$$EnhancerByCGLIB$$29f2bee = new UserServiceImpl$$EnhancerByCGLIB$$29f2bee();
//                    break;
//                }
//                default: {
//                    throw new IllegalArgumentException("Constructor not found");
//                }
//            }
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$SET_THREAD_CALLBACKS(null);
//            return userServiceImpl$$EnhancerByCGLIB$$29f2bee;
//        }
//
//        @Override
//        public Object newInstance(Callback callback) {
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$SET_THREAD_CALLBACKS(new Callback[]{callback});
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee userServiceImpl$$EnhancerByCGLIB$$29f2bee = new UserServiceImpl$$EnhancerByCGLIB$$29f2bee();
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$SET_THREAD_CALLBACKS(null);
//            return userServiceImpl$$EnhancerByCGLIB$$29f2bee;
//        }
//
//        public final void delete() {
//            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//            if (methodInterceptor == null) {
//                UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(this);
//                methodInterceptor = this.CGLIB$CALLBACK_0;
//            }
//            if (methodInterceptor != null) {
//                Object object = methodInterceptor.intercept(this, CGLIB$delete$2$Method, CGLIB$emptyArgs, CGLIB$delete$2$Proxy);
//                return;
//            }
//            super.delete();
//        }
//
//        public final void query() {
//            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//            if (methodInterceptor == null) {
//                UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(this);
//                methodInterceptor = this.CGLIB$CALLBACK_0;
//            }
//            if (methodInterceptor != null) {
//                Object object = methodInterceptor.intercept(this, CGLIB$query$3$Method, CGLIB$emptyArgs, CGLIB$query$3$Proxy);
//                return;
//            }
//            super.query();
//        }
//
//        @Override
//        public void setCallbacks(Callback[] callbackArray) {
//            Callback[] callbackArray2 = callbackArray;
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee userServiceImpl$$EnhancerByCGLIB$$29f2bee = this;
//            this.CGLIB$CALLBACK_0 = (MethodInterceptor)callbackArray[0];
//        }
//
//        @Override
//        public void setCallback(int n, Callback callback) {
//            switch (n) {
//                case 0: {
//                    this.CGLIB$CALLBACK_0 = (MethodInterceptor)callback;
//                    break;
//                }
//            }
//        }
//
//        public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] callbackArray) {
//            CGLIB$STATIC_CALLBACKS = callbackArray;
//        }
//
//        public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] callbackArray) {
//            CGLIB$THREAD_CALLBACKS.set(callbackArray);
//        }
//
//        @Override
//        public Callback[] getCallbacks() {
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(this);
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee userServiceImpl$$EnhancerByCGLIB$$29f2bee = this;
//            return new Callback[]{this.CGLIB$CALLBACK_0};
//        }
//
//        @Override
//        public Callback getCallback(int n) {
//            MethodInterceptor methodInterceptor;
//            UserServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BIND_CALLBACKS(this);
//            switch (n) {
//                case 0: {
//                    methodInterceptor = this.CGLIB$CALLBACK_0;
//                    break;
//                }
//                default: {
//                    methodInterceptor = null;
//                }
//            }
//            return methodInterceptor;
//        }
//
//        final boolean CGLIB$equals$4(Object object) {
//            return super.equals(object);
//        }
//
//        final String CGLIB$toString$5() {
//            return super.toString();
//        }
//
//        final void CGLIB$delete$2() {
//            super.delete();
//        }
//
//        final void CGLIB$add$0() {
//            super.add();
//        }
//
//        final void CGLIB$update$1() {
//            super.update();
//        }
//
//        final void CGLIB$query$3() {
//            super.query();
//        }
//
//        final Object CGLIB$clone$7() throws CloneNotSupportedException {
//            return super.clone();
//        }
//
//        final int CGLIB$hashCode$6() {
//            return super.hashCode();
//        }
//
//        public static MethodProxy CGLIB$findMethodProxy(Signature signature) {
//            String string = ((Object)signature).toString();
//            switch (string.hashCode()) {
//                case -1949253108: {
//                    if (!string.equals("update()V")) break;
//                    return CGLIB$update$1$Proxy;
//                }
//                case -1422568652: {
//                    if (!string.equals("add()V")) break;
//                    return CGLIB$add$0$Proxy;
//                }
//                case -1166709331: {
//                    if (!string.equals("query()V")) break;
//                    return CGLIB$query$3$Proxy;
//                }
//                case -508378822: {
//                    if (!string.equals("clone()Ljava/lang/Object;")) break;
//                    return CGLIB$clone$7$Proxy;
//                }
//                case -358764054: {
//                    if (!string.equals("delete()V")) break;
//                    return CGLIB$delete$2$Proxy;
//                }
//                case 1826985398: {
//                    if (!string.equals("equals(Ljava/lang/Object;)Z")) break;
//                    return CGLIB$equals$4$Proxy;
//                }
//                case 1913648695: {
//                    if (!string.equals("toString()Ljava/lang/String;")) break;
//                    return CGLIB$toString$5$Proxy;
//                }
//                case 1984935277: {
//                    if (!string.equals("hashCode()I")) break;
//                    return CGLIB$hashCode$6$Proxy;
//                }
//            }
//            return null;
//        }
//
//        static void CGLIB$STATICHOOK1() {
//            CGLIB$THREAD_CALLBACKS = new ThreadLocal();
//            CGLIB$emptyArgs = new Object[0];
//            Class<?> clazz = Class.forName("com.yzm.structure.proxy.dynamicproxy.cglibproxy.UserServiceImpl$$EnhancerByCGLIB$$29f2bee");
//            Class<?> clazz2 = Class.forName("java.lang.Object");
//            Method[] methodArray = ReflectUtils.findMethods(new String[]{"equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, clazz2.getDeclaredMethods());
//            CGLIB$equals$4$Method = methodArray[0];
//            CGLIB$equals$4$Proxy = MethodProxy.create(clazz2, clazz, "(Ljava/lang/Object;)Z", "equals", "CGLIB$equals$4");
//            CGLIB$toString$5$Method = methodArray[1];
//            CGLIB$toString$5$Proxy = MethodProxy.create(clazz2, clazz, "()Ljava/lang/String;", "toString", "CGLIB$toString$5");
//            CGLIB$hashCode$6$Method = methodArray[2];
//            CGLIB$hashCode$6$Proxy = MethodProxy.create(clazz2, clazz, "()I", "hashCode", "CGLIB$hashCode$6");
//            CGLIB$clone$7$Method = methodArray[3];
//            CGLIB$clone$7$Proxy = MethodProxy.create(clazz2, clazz, "()Ljava/lang/Object;", "clone", "CGLIB$clone$7");
//            clazz2 = Class.forName("com.yzm.structure.proxy.dynamicproxy.cglibproxy.UserServiceImpl");
//            Method[] methodArray2 = ReflectUtils.findMethods(new String[]{"add", "()V", "update", "()V", "delete", "()V", "query", "()V"}, clazz2.getDeclaredMethods());
//            CGLIB$add$0$Method = methodArray2[0];
//            CGLIB$add$0$Proxy = MethodProxy.create(clazz2, clazz, "()V", "add", "CGLIB$add$0");
//            CGLIB$update$1$Method = methodArray2[1];
//            CGLIB$update$1$Proxy = MethodProxy.create(clazz2, clazz, "()V", "update", "CGLIB$update$1");
//            CGLIB$delete$2$Method = methodArray2[2];
//            CGLIB$delete$2$Proxy = MethodProxy.create(clazz2, clazz, "()V", "delete", "CGLIB$delete$2");
//            CGLIB$query$3$Method = methodArray2[3];
//            CGLIB$query$3$Proxy = MethodProxy.create(clazz2, clazz, "()V", "query", "CGLIB$query$3");
//        }
//
//        private static final void CGLIB$BIND_CALLBACKS(Object object) {
//            block2: {
//                Object object2;
//                block3: {
//                    UserServiceImpl$$EnhancerByCGLIB$$29f2bee userServiceImpl$$EnhancerByCGLIB$$29f2bee = (UserServiceImpl$$EnhancerByCGLIB$$29f2bee)object;
//                    if (userServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BOUND) break block2;
//                    userServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$BOUND = true;
//                    object2 = CGLIB$THREAD_CALLBACKS.get();
//                    if (object2 != null) break block3;
//                    object2 = CGLIB$STATIC_CALLBACKS;
//                    if (CGLIB$STATIC_CALLBACKS == null) break block2;
//                }
//                userServiceImpl$$EnhancerByCGLIB$$29f2bee.CGLIB$CALLBACK_0 = (MethodInterceptor)((Callback[])object2)[0];
//            }
//        }
//    }

}
