package com.yzm.io;

import java.io.InputStream;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/12
 */
public class Resources {

    /**
     *  加载配置文件
     */
    public static InputStream getResourceAsStream(String path){
        InputStream resourceAsStream
                = Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }


}
