package com.tz.leo.readProperties;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Author: tz_wl
 * Date: 2020/8/13 15:06
 * Content:   ResourceBundle 方法获取 文件内容  注意 fileName 没有后缀
 */
public class ReadProperties02WithResourceBundle {
    public static void main(String[] args) {
        //配置文件放在resource源包下，注意文件路径  不用加后缀
        String fileName="redisConfig";   //    /redisConfig  写法也不行
        ResourceBundle rsBundle = ResourceBundle.getBundle(fileName);
        Enumeration<String> keys = rsBundle.getKeys();
        ArrayList<String> valList = new ArrayList<>();
        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            String val = rsBundle.getString(key);
            valList.add(val);
        }
        System.out.println(valList);   //[127.0.0.1, 6379]

    }
}
