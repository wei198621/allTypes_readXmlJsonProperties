package com.tz.leo.jsoupTest;

import cn.hutool.core.util.CharsetUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * Author: tz_wl
 * Date: 2020/4/24 16:20
 * Content:   获取内容和文本
 */
public class jsoup05GetAttr {
    public static void main(String[] args) throws IOException {

        //https://blog.csdn.net/Captain249/article/details/98172911
        //多重获取路径方式

        String strClassGetResource= jsoup05GetAttr.class.getResource("/jsoup04GetElement.html").getPath();
        String strClassGetClassLoader =jsoup05GetAttr.class.getClassLoader().getResource("jsoup04GetElement.html").getPath();

        String strClassLoader =ClassLoader.getSystemClassLoader().getResource("jsoup04GetElement.html").getPath();
        String strClassLoader2 =ClassLoader.getSystemResource("jsoup04GetElement.html").getPath();

        String strThread =Thread.currentThread().getContextClassLoader().getResource("jsoup04GetElement.html").getPath();

        System.out.println(strClassGetResource);
        System.out.println(strClassGetClassLoader);
        System.out.println(strClassLoader);
        System.out.println(strClassLoader2);
        System.out.println(strThread);

        File f=new File(jsoup05GetAttr.class.getResource("/jsoupHtml4Select.html").getPath());
        if(!f.exists()){
            return;
        }

        Document doc = Jsoup.parse(f, CharsetUtil.UTF_8);
        Element ele =doc.getElementById("d1");
        System.out.println(ele);

        System.out.println(ele.attr("id"));   //获取属性
        System.out.println(ele.attributes());  //获取所有属性
        System.out.println(ele.id());          //获取id
        System.out.println(ele.className());   //获取类名称
        System.out.println(ele.classNames());  //获取所有类名称
        System.out.println(ele.text());        //获取文本
        System.out.println(ele.html());        //获取html
        System.out.println(ele.outerHtml());   //获取外html
        System.out.println(ele.tagName());     //获取标签信息

    }
}
