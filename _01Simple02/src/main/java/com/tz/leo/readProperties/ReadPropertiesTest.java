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
 *             new InputStreamReader(  )
 *                                    ReadPropertiesTest.class.getClass().getResourceAsStream(path);
 */
public class ReadPropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        String path="/redisConfig.properties";
        InputStream stream = ReadPropertiesTest.class.getClass().getResourceAsStream(path);
        Reader reader = new InputStreamReader(stream);
        props.load(reader);
        //  加载完成  查看 打印效果
        String str= props.getProperty("redis.ip");
        System.out.println(str);                   // 127.0.0.1
    }
}
