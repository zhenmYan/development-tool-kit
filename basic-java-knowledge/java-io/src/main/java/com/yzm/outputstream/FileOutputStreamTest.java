package com.yzm.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ### java-io FileOutputStream
 *
 *      字节输出流的细节
 *
 *          1、创建对象
 *              - 不会创建新的文件，需要保证路径文件时已经存在的
 *              - 如果文件已经存在，创建对象会清空之前的文件
 *                  - FileOutputStream的入参可以设置是否续写
 *
 *          2、写数据
 *              - 入参是整数，但实际上写到本地的是ASCII对应的字符
 *
 *          3、释放资源
 *              - 每次使用都要释放资源
 *
 *
 * @author yzm
 * @date 2024/5/15
 */
public class FileOutputStreamTest {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("basic-java-knowledge/java-io/src/main/resources/text/fileOutputStream.txt");

        // 1、一次写一个字节
        fos.write(66);
        fos.write(67);
        fos.write(10);// 换行

        // 2、一次写一个字节流
        byte[] byteStream = new byte[]{97,98,99,100,101,102,103};
        fos.write(byteStream);
        fos.write(10);// 换行

        // 3、一次写一个字节流的一部分
        fos.write(byteStream, 3, 2);
        fos.write(10);// 换行

        // 4、使用getBytes
        String s = new String("yzm");
        fos.write(s.getBytes());

        fos.close();
    }


}
