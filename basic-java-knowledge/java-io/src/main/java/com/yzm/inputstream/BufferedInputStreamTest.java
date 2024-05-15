package com.yzm.inputstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ### java-io BufferedInputStream
 *
 *      缓存流
 *
 *      8192字节数组，占8k
 *
 *
 *
 * @author yzm
 * @date 2024/5/15
 */
public class BufferedInputStreamTest {

    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream
                = new BufferedInputStream(new FileInputStream(
                        "basic-java-knowledge/java-io/src/main/resources/text/bufferedInputStream"));

        // 单个读取
        int b ;
        while ((b = bufferedInputStream.read()) != -1){
            System.out.println(b);
        }

        // 读取多个
        int b1;
        byte[] bytes = new byte[4];
        while ((b1 = bufferedInputStream.read(bytes)) != -1){
            System.out.println(b1);
        }

        bufferedInputStream.close();
    }

}
