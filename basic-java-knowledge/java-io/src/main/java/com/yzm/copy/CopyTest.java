package com.yzm.copy;

import java.io.*;

/**
 * ### java-io 拷贝
 *
 * @author yzm
 * @date 2024/5/15
 */
public class CopyTest {

    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream("");
        OutputStream fos = new FileOutputStream("");
        int b;
        // 1、一个一个字节读取
        while ((b = fis.read())!= -1){
            fos.write(b);
        }

        // 2、一次读 5M
        // 返回值是一次读取到的数量
        /**
         * 比如abcde，每次读取两个字节
         *
         *  第一次读ab 返回2
         *  第二次读cd 返回2
         *  第三次读ed 返回1
         *  第四次读空 返回-1
         *
         *  所以需要注意第三次需要取长度的值，
         */
        byte[] stream = new byte[1024*1024*5];
        while ((b = fis.read(stream))!= -1){
            fos.write(b);
        }


        fis.close();
        fos.close();


    }
}
