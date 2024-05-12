package com.yzm.双亲委派;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: yan
 * @description: 测试自定义String是否能够加载
 * @create: 2023-02-24 13:46
 **/
public class TestString {

    public static void main(java.lang.String[] args) {

        // 自定义类加载器
        ClassLoader myLoad = new ClassLoader() {
            @Override
            public Class<?> loadClass(java.lang.String name)throws ClassNotFoundException {
                java.lang.String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (null == is) {
                    return super.loadClass(name);
                }
                try {
                    byte[] b= new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };
        try {
//            Object obj = myLoad.loadClass("JVM.双亲委派.String").newInstance();
//            System.out.println(obj.getClass());
//            // 这个obj使用的是自定义的classLoad 与 虚拟机自带的不是一个类加载器，所以返回false
//            System.out.println(obj instanceof String);
//            System.out.println();
            // lang包下的String
            java.lang.String s = "";
            System.out.println(s.getClass());
            // 自定义包下的String
            java.lang.String s1 = new java.lang.String();
            System.out.println(s1.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
