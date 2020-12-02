package com.tz.leo.dom4jTest;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/13 16:25
 * Content:
 */
public class Dom4jTest {

    public static void main(String[] args) throws IOException, DocumentException {


  /*      //01  读取Resource目录下的文件
        InputStream inputStream = Dom4jTest.class.getResourceAsStream("/xmlTest202008.xml");
        ReadStreamByDom4j(inputStream);
*/

        //0201  读取本地磁盘下的文件
        String fileName0201="d://temp//tempdata//xmlTest20200408.txt";
        FileInputStream fileInputStream0201 =new FileInputStream(fileName0201);
        ReadStreamByDom4j(fileInputStream0201);

/*        //0201  读取本地磁盘下的文件
        String fileName0201="d://temp//tempdata//xmlTest20200408.txt";
        File file=new File(fileName);
        FileInputStream fileInputStream =new FileInputStream(file);
        ReadStreamByDom4j(fileInputStream);*/

    }

    private static void ReadStreamByDom4j(InputStream inputStream) throws IOException, DocumentException {
        String charset="utf-8";
        String content = IOUtils.toString(inputStream, charset);
        Document dom = DocumentHelper.parseText(content);
        List listNode = dom.selectNodes("project");
        System.out.println(listNode.size());
    }
}
