package com.yzm.zipstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * ### java-io ZipInputStream
 *
 * @author yzm
 * @date 2024/5/15
 */
public class ZipStreamTest {

    public static void main(String[] args) throws IOException {
        // 待解压的文件
        File src = new File("src.zip");
        // 解压后的目录
        File dest = new File("dest");

        unzip(src, dest);
    }

    // 解压的本质：把压缩包里的每一个文件或文件夹读取出来，按层级拷贝到目的地中
    private static void unzip(File src, File dest) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        ZipEntry zipEntry;
        while((zipEntry = zis.getNextEntry()) != null){
            // 文件夹
            if (zipEntry.isDirectory()){
                File file = new File(dest, zipEntry.toString());
                file.mkdirs();
                // 文件
            } else {
                FileOutputStream fos = new FileOutputStream(new File(dest, zipEntry.toString()));
                int b;
                while ((b=zis.read())!= -1){
                    fos.write(b);
                }
                fos.close();
                zis.closeEntry();
            }
        }
    }
}
