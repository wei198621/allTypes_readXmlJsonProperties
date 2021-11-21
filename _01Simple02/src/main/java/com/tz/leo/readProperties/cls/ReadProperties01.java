package com.tz.leo.readProperties.cls;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * Author: tz_wl
 * Date: 2020/8/13 14:49
 * Content:
 */
public class ReadProperties01 {

    public  void read() throws IOException {
        Properties props = new Properties();
        String path="/redisConfig.properties";
        InputStream stream = this.getClass().getResourceAsStream(path);
        props.load(stream);

        // props.load(Reader/InputStream);
        //Reader reader = new InputStreamReader(stream);
        //props.load(reader);

       //  加载完成  查看 打印效果
        String str= props.getProperty("redis.ip");
        System.out.println(str);                     // 127.0.0.1
    }

    public void read02() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(new File("")));
        props.load(new BufferedReader(new FileReader("")));
        props.load(new InputStreamReader(new BufferedInputStream(new FileInputStream(new File("")))));

    }
}
