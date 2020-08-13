package com.tz.leo.jsoupTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Author: tz_wl
 * Date: 2020/4/24 15:44
 * Content:
 * 获取元素  org.jsoup.Jsoup.parse(***) ,将文档转换为 org.jsoup.nodes.Document 然后使用
 * 获取数据源有三种
 * 1.  基于字符串方式
 * 2.  基于文件方式
 * 3.  基于URL方式
 */
public class jsoup03GetData {
    public static void main(String[] args) throws IOException {
        String html = "<html><body><p>Hello HTML</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println("基于字符串方式得到的 Document:\\r\\n" + doc);
        System.out.println("==============================================================");
        Elements arrayE = doc.getElementsByTag("p");
        for (Element e : arrayE) {
            System.out.println(e.text());
        }


        System.out.println("==============================================================");
        String localFileName = "D:\\04_CodeFromNet\\allTypes_readXmlJsonProperties\\_03jsoup\\src\\main\\resources\\jsoup03Simple.html";
        File f = new File(localFileName);
        if (f.exists()) {
            Document dom2 = Jsoup.parse(f, "utf-8");
            System.out.println("基于文件方式得到的 Document:\r\n" + dom2);
        }


        System.out.println("==============================================================");
        String url = "http://www.baidu.com";
        Document dom3 = Jsoup.parse(new URL(url), 5000);
        System.out.println("基于URL方式得到的 Document:\r\n" + dom3);

        System.out.println("==============================================================");
    }
}
