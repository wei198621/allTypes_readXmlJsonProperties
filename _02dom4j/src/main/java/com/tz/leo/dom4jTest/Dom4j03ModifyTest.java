package com.tz.leo.dom4jTest;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/13 17:30
 * Content:
 */
public class Dom4j03ModifyTest {
    public static void main(String[] args) {

        //需要是本地真实路径
        String localPath = "D:\\04_CodeFromNet\\allTypes_readXmlJsonProperties\\_02dom4j\\src\\main\\resources\\";
        String fileName = "dom4jhtml20200814.html";
        //修改一个文档
        ModifyXmlFile(localPath, fileName, "dom4jhtmlNew.html");
        //格式化一个文档
        formatXMLFile(localPath + fileName);
    }


    public static int ModifyXmlFile(String localPath, String filename, String newFileName) {
        int returnVal = 0;

        File f = new File(localPath + filename);

        try {
            org.dom4j.io.SAXReader saxReader = new SAXReader();
            org.dom4j.Document doc = saxReader.read(f);

            /** 修改内容之一: 如果book节点中show属性的内容为yes,则修改成no */
            /** 先用xpath查找对象 */
            List list = doc.selectNodes("/books/book/@show");
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                org.dom4j.Attribute attr = (Attribute) iterator.next();
                if (attr.getValue().equals("yes")) {
                    attr.setValue("no");
                }
            }

            /* 修改内容之二: 把owner项内容改为Tshinghua
             * 并在owner节点中加入date节点,date节点的内容为2004-09-11,还为date节点添加一个属性type
             */
            list = doc.selectNodes("/books/owner");
            iterator = list.iterator();
            if (iterator.hasNext()) {
                org.dom4j.Element ownerE = (org.dom4j.Element) iterator.next();
                ownerE.setText("Tshinghua");
                org.dom4j.Element dateE = ownerE.addElement("date");
                dateE.setText("20200813");
                dateE.addAttribute("type", "typeLaoLi");
            }



            try {
                File fileNew = new File(localPath + newFileName);
                XMLWriter writer = new XMLWriter(new FileWriter(fileNew));
                writer.write(doc);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return returnVal;

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
