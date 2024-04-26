package com.yzm.终止线程;

import java.util.HashMap;

/**
 * @author: yan
 * @description: 两阶段终止
 * @create: 2023-02-21 18:03
 **/
public class TwoPhaseTermination {

    private static int percent;
    private static final int MAX = 100;

    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        map.put(1,21);
        DownloadThread downloadThread = new DownloadThread();
        downloadThread.start();
        Thread.sleep(4000);
        downloadThread.stopMe();
    }

    private static class DownloadThread extends Thread{

        public DownloadThread() {
            super("download-thread");
        }

        @Override
        public void run() {
            while (true){
                if (isTerminated()){
                    System.out.println("取消下载,退出");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    String cur = "已下载: %" + ++percent;
                    System.out.println(cur);
                    if(percent >= MAX){
                        System.out.println("下载完成");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void stopMe(){
            interrupt();
        }

        public boolean isTerminated(){
            return Thread.currentThread().isInterrupted();
        }
    }

}
