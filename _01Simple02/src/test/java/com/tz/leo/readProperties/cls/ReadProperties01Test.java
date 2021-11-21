package com.tz.leo.readProperties.cls;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author leowei
 * @date 2021/11/21  - 23:11
 */
public class ReadProperties01Test {

    @Test
    public void read() {
        try {
            ReadProperties01 readProp = new ReadProperties01();
            readProp.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void read02() {
    }
}