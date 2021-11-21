package com.tz.leo.readProperties;

import com.tz.leo.readProperties.cls.ReadProperties01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * Author: tz_wl
 * Date: 2020/8/13 14:44
 * Content:
 * props.load ( )
 *            stream =  ReadPropertiesTest.class.getClass().getResourceAsStream(path);
 */
public class ReadPropertiesTest {
    public static void main(String[] args) throws IOException {
        getPathSimplest();
       // run01();

    }

    // 最简单获取路径方法
    private static void getPathSimplest() {
        String path = ClassLoader.getSystemResource("redisConfig.properties").getPath();
        System.out.println(path);
    }


    private static void run01() throws IOException {
        String path="/redisConfig.properties";
        Properties props = new Properties();
        InputStream stream = ReadPropertiesTest.class.getClass().getResourceAsStream(path);
        props.load(stream);
        String str= props.getProperty("redis.ip");           //  加载完成  查看 打印效果
        System.out.println(str);                   // 127.0.0.1
    }
       /* Reader reader = new InputStreamReader(stream);
        props.load(reader);*/
}
