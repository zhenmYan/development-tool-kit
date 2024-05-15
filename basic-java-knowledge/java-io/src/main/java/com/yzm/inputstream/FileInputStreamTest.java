package com.yzm.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * ### java-io FileInputStream
 *
 *      字节输入流的细节
 *
 *            1、创建对象
 *              - 如果文件不存在，报错
 *
 *            2、写数据
 *              - 读到末尾返回-1
 *
 *            3、释放资源
 *
 * @author yzm
 * @date 2024/5/15
 */
public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream("basic-java-knowledge/java-io/src/main/resources/text/fileInputStream");
        // 1、一次读取一个字节
        int stream1 = fis.read();
        int stream2 = fis.read();
        System.out.println(stream1);
        System.out.println(stream2);

        // 2、循环读取
        int b;
        while((b = fis.read()) != -1){
            System.out.println(b);
        }

        // 3、一次读取多个字节（这里是5M）
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
            System.out.println(b);
        }

        fis.close();
    }
}
