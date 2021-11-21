package com.tz.leo.readProperties;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import java.io.IOException;
import java.util.Properties;
/**
 * Author: tz_wl
 * Date: 2020/8/13 15:35
 * Content:
 */
public class ReadPropertiesTest04 {
    public static void main(String[] args) throws IOException {
        String fileName = "redisConfig.properties";
        Properties props = new Properties();
        props=PropertiesLoaderUtils.loadAllProperties(fileName);
        for(Object objKey: props.keySet()){
            System.out.print("key is : "+ objKey);
            System.out.println("  ;value is :"+ props.get(objKey));
        }
        /*
        key is : redis.ip  ;value is :127.0.0.1
        key is : redis.port  ;value is :6379
        */
    }
}
