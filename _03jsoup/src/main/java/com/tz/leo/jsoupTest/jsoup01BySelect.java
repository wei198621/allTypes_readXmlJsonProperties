package com.tz.leo.jsoupTest;

import cn.hutool.core.util.CharsetUtil;

import java.io.File;
import java.io.IOException;

/**
 * Author: tz_wl
 * Date: 2020/5/12 18:32
 * Content:
 */
public class jsoup01BySelect {

    static org.jsoup.nodes.Document doc;
    public static void main(String[] args) throws IOException {
        String path = ClassLoader.getSystemResource("jsoupHtml4Select.html").getPath();
        System.out.println(path);
        File f =new File(path);
        if(!f.exists()){
            return;
        }
        doc =org.jsoup.Jsoup.parse(f, CharsetUtil.UTF_8);

        //像 jquery 那样的选择器语法
        show("选择所有的超链", "a");
        show("根据id进行选择", "#logocover");
        show("根据class进行选择", ".clearfloat");
        show("根据属性进行选择", "[href]");
        show("有属性以tar开头", "[^tar]");
        show("根据属性值选择", "[type='application/javascript']");
        show("属性值以什么开头", "[href^='http://www.oracle.com']");
        show("属性值以什么结尾", "[href$='index.html']");
        show("属性值包含什么", "[href*='download']");

    }


    private static void show(String text,String selector){
        show(text,selector,3);
    }

    private static void show(String text,String selector,int limit){
        org.jsoup.select.Elements es=doc.select(selector);
        if(es.size()>1){
            System.out.println(String.format("%s - 使用的选择器是: \"%s\" \t (最多显示 %d 条 )", text,selector,limit));
        }else{
            System.out.println(String.format("%s - 使用的选择器是: \"%s\"", text,selector));
        }
        int i=0;
        for(org.jsoup.nodes.Element  e: es){
            if(i++<limit){
                System.out.println(e);
            }
        }
        System.out.println();
    }

}
