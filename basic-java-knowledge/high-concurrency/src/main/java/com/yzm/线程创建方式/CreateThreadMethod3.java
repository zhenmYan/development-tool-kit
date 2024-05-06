package com.yzm.线程创建方式;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：使用Callable和FutureTask
 *
 * @author: yan
 * @description:
 * @create: 2023-02-21 10:45
 **/
public class CreateThreadMethod3 {

    public static void main(String[] args) throws Exception{
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("创建线程的方式三：使用Callable和FutureTask");
                return "return：使用Callable和FutureTask";
        }
        };
        FutureTask<Callable> futureTask = new FutureTask<>(callable);
        Thread t1 = new Thread(futureTask);
        t1.start();

        // 通过futureTask.get()获取Callable的返回值
        // 注意这里get是阻塞的
        System.out.println(futureTask.get());


        Callable callable1 = ()->{
            System.out.println("创建线程的方式三：lambda表达式");
            return null;
        };
        FutureTask<Callable> futureTask1 = new FutureTask<>(callable1);
        Thread t2 = new Thread(futureTask1);
        t2.start();
    }
}
