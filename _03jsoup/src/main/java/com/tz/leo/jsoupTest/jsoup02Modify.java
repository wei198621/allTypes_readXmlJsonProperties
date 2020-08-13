package com.tz.leo.jsoupTest;


import cn.hutool.core.util.CharsetUtil;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

/**
 * Author: tz_wl
 * Date: 2020/5/12 18:39
 * Content:
 */
public class jsoup02Modify {
    static Document doc;
    //取resource中的资源文件  更改
    public static void main(String[] args) throws IOException {

        //需要是本地真实路径
        String localPath = "D:\\04_CodeFromNet\\allTypes_readXmlJsonProperties\\_03jsoup\\src\\main\\resources\\";
        String fileName = "jsoupHtml4Modify.html";

        File f=new File(localPath+fileName);
        if(!f.exists())
            return;

        doc =org.jsoup.Jsoup.parse(f, CharsetUtil.UTF_8);
        System.out.println(doc);

        org.jsoup.nodes.Element e =doc.select("p").first();
        e.attr("class","class1");
        e.appendText(" Hello JSoup");
        System.out.println("=================================================");
        System.out.println(doc);

    }
}
