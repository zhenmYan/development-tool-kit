package com.yzm.创建线程的方式;

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
        Thread thread = new Thread(futureTask);
        thread.start();

        // 通过futureTask.get()获取Callable的返回值
        System.out.println(futureTask.get());
    }
}
