package com.tiza.leo.ymlBySpring;

import com.tiza.leo.ymlBySpring.config.ForwardConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: tz_wl
 * Date: 2021/4/9 21:16
 * Content:
 */
@SpringBootApplication
public class Boot implements ApplicationRunner {

    @Autowired
    ForwardConfig forwardConfig;

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }

    public void run(ApplicationArguments args) throws Exception {
        forwardConfig.readYml();
    }
}
