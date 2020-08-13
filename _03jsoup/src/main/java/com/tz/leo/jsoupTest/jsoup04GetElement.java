package com.tz.leo.jsoupTest;

import cn.hutool.core.util.CharsetUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Author: tz_wl
 * Date: 2020/4/24 15:44
 * Content: 获取元素 通过 id ，标签，类名，属性 获取元素
 */
public class jsoup04GetElement {
    public static void main(String[] args) throws IOException {

        String localFileName= "D:\\04_CodeFromNet\\allTypes_readXmlJsonProperties\\_03jsoup\\src\\main\\resources\\jsoup04GetElement.html";
        File f=new File(localFileName);
        if(!f.exists()){
            return;
        }

        //通过id 获取元素
        Document doc = Jsoup.parse(f, CharsetUtil.UTF_8);
        Element ele = doc.getElementById("productName");
        System.out.println(ele);
        System.out.println("******************************");

        //通过标签获取元素
        Elements eles= doc.getElementsByTag("a");
        System.out.println("******************************");
        show(eles);
        System.out.println("******************************");

        //通过类名称获取
        eles = doc.getElementsByClass("RightBox");
        show(eles);
        System.out.println("******************************");

        //通过属性获取
        eles=doc.getElementsByAttribute("name");
        show(eles);
        System.out.println("******************************");



    }

    private static void show(Elements es){
        for(Element e: es){
            System.out.println(e);
        }
    }
}
