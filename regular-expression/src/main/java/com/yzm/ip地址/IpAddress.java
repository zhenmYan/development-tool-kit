package com.yzm.ip地址;/**
 * @author yan
 * @date 2024/6/10
 * @Description
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:
 *
 * @author yzm
 * @date 2024/6/10 
 */
public class IpAddress {

    public static void main(String[] args) {
        String content = "私有地址（Private address）属于非注册地址，专门为组织机构内部使用。\n" +
                "以下列出留用的内部私有地址\n" +
                "A类 10.0.0.0--10.255.255.255\n" +
                "B类 172.16.0.0--172.31.255.255\n" +
                "C类 192.168.0.0--192.168.255.255";
        // \\d 表示任意数字
        // \\. 表示 .
        String regex = "\\d+\\.\\d+\\.\\d+\\.\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }


    }
}
