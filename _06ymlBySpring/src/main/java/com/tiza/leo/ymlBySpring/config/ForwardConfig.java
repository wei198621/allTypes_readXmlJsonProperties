package com.tiza.leo.ymlBySpring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Author: tz_wl
 * Date: 2021/4/9 21:15
 * Content:
 */
@Configuration
@Slf4j
public class ForwardConfig {

    @Autowired
    private Environment env;

    public void readYml(){
        String ip = env.getProperty("gateway.ip");
        Integer port = Integer.valueOf(env.getProperty("gateway.port"));

        log.error("ip is :"+ ip + "; port is : "+ port);
        // ip is :192.168.121.55; port is : 9088

    }

}
