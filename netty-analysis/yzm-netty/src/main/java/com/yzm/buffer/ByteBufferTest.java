package com.yzm.buffer;


import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ##### Netty buffer ByteBuffer
 *
 *      ByteBuffer使用姿势
 *          1、向buffer写数据：channel.read(buffer)
 *          2、从buffer读数据：buffer.get()
 *          3、切换至读模式：flip()
 *          4、切换至写模式：clear()或compact()
 *
 *      重要方法
 *          1、allocate
 *              - 创建的是 HeapByteBuffer
 *              - 分配在堆内存
 *              - 受GC影响
 *          2、allocateDirect
 *              - 创建的是 DirectByteBuffer
 *              - 分配在直接内存
 *              - 少一次拷贝
 *              - 不受GC回收影响
 *
 * @author yzm
 * @date 2024/5/18
 */
@Slf4j
public class ByteBufferTest {

    public static void main(String[] args) throws FileNotFoundException {
        // FileChannel
        // 1、输入输出流间接获取
        try(FileChannel channel = new FileInputStream
                ("netty-analysis/yzm-netty/src/main/resources/com/yzm/bytebuffer")
                .getChannel()){
            // 在堆内存中创建长度为10的数组作为缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);

            while(true){
                // 从channel读取数据，向buffer写入
                int len = channel.read(buffer);
                if (len == -1){
                    break;
                }
                // 从写模式切换至读模式
                buffer.flip();
                while (buffer.hasRemaining()){
                    byte b = buffer.get();
                    System.out.println((char)b);
                }
                // 从读模式切换至写模式
                buffer.clear();

            }

        } catch (IOException e){
        }
    }

    // 重要方法
    private void importantMethod(){
        // 在直接内存中创建长度为10的数组作为缓冲区
         ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        // 从头读起，原理是将position置为0
         buffer.rewind();
        // mark做一个标记，记录position的位置
         buffer.mark();
        // 将position重置到mark的位置
         buffer.reset();
    }

    /**
     * ##### Netty buffer ByteBuffer 粘包半包问题
     *
     *      多条数据发送给服务端，数据之间使用\n进行分割
     *      但是由于某种原因，这些数据在接收时，被进行重新组合，例如原始数据是三条：
     *          "hello world\n"
     *          "I'm zhangsan\n"
     *          "How are you?"
     *
     *      变成下面两个
     *          "hello world\nI'm zhangsan\nHo"
     *          "w are you?\n"
     *      这就是粘包和半包问题
     *
     */
    public void split(){
        // 模拟粘包问题
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("hello world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);
    }

    // 处理粘包问题
    public void split(ByteBuffer source){
        source.flip();
        for (int i = 0; i < source.limit(); i++){
            // 找到一条完整消息
            // 注意get(i)不会移动position
            if (source.get(i) == '\n'){
                int len = i + 1 - source.position();
                // 将完整数据存入新的 ByteBuffer
                ByteBuffer target = ByteBuffer.allocate(len);
                // 从source读，往target写
                for(int j = 0; j < len; j++){
                    target.put(source.get());
                }
            }
        }
    }

}
