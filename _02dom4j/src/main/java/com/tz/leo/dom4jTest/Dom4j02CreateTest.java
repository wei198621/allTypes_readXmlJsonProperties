package com.tz.leo.dom4jTest;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author: tz_wl
 * Date: 2020/8/13 17:30
 * Content:
 * https://blog.csdn.net/linmengmeng_1314/article/details/79975599
 */
public class Dom4j02CreateTest {
    public static void main(String[] args) throws IOException {

        String localFilePath = "D:\\temp\\tempdata\\";
        String fileName = "dom4jhtml"+ cn.hutool.core.date.SystemClock.now() + ".html";
        //建立一个XML文档
        createXMLFile2(localFilePath+ fileName);
        formatXMLFile(localFilePath+ fileName);
    }


    /**
     * @Description: 建立一个XML文档
     * @Param:
     * @return:
     * @date: 2020/5/12
     */
    public static int createXMLFile2(String localFileName) throws IOException {
        int returnValue = 0;

        org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();

        org.dom4j.Element books = document.addElement("books");
        books.addComment(" thie is a test for dom4j ,weilei 2020");

        org.dom4j.Element bookL1 = books.addElement("book");
        bookL1.addAttribute("show", "yes");

        org.dom4j.Element titleElement = bookL1.addElement("title");
        titleElement.setText("Dom4j tutorials");

        /** 类似的完成后两个book */
        bookL1 = books.addElement("book");
        bookL1.addAttribute("show", "yes");
        titleElement = bookL1.addElement("title");
        titleElement.setText("Lucene Studing");
        bookL1 = books.addElement("book");
        bookL1.addAttribute("show", "no");
        titleElement = bookL1.addElement("title");
        titleElement.setText("Lucene in Action");

        /** 加入owner节点 */
        org.dom4j.Element ownerElement = books.addElement("owner");
        ownerElement.setText("O'Reilly");

        File f = new File(localFileName);
        XMLWriter writer = new XMLWriter(new FileWriter(f));
        writer.write(document);
        writer.close();
        return returnValue;
    }


    /**
     * 格式化XML文档,并解决中文问题
     * @param filename
     * @return
     */
    public static int formatXMLFile(String filename){
        int returnValue = 0;
        try{
            XMLWriter writer = null;
            SAXReader saxReader = new SAXReader();
            File f =new File( filename);

            Document document = saxReader.read(f);

            /** 格式化输出,类型IE浏览一样 */
            OutputFormat format = OutputFormat.createPrettyPrint();
            /** 指定XML编码 */
            format.setEncoding("GBK");


            writer= new XMLWriter(new FileWriter(f),format);
            writer.write(document);
            writer.close();
            /** 执行成功,需返回1 */
            returnValue = 1;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return returnValue;
    }
}
