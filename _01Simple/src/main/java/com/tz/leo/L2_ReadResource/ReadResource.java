package com.tz.leo.L2_ReadResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author leowei
 * @date 2021/11/21  - 16:25
 *
 * https://blog.csdn.net/oschina_40188932/article/details/78833754
 */
public class ReadResource {
    private static Logger logger = LoggerFactory.getLogger(ReadResource.class);
    public static void main(String[] args) throws IOException {

       // GetResourceM1();


       // GetPathM2();

       // GetPathM3();


       // GetPropertyM4();

      //  ClassLoaderGetResource();

        ClassLoad_VS_Class_getPath();

    }

    /**
     * class.getResource                                       此类的根目录是  **\\target\\classes
     * class.getClassLoader().getResource      类加载器当前目录就是此类的根目录 **\\target\\classes
     *
     * classGetResource default path:     /C:/workspace/workspace_idea/allTypes_readXmlJsonProperties/_01Simple/target/classes/
     * classLoadGetResource default path: /C:/workspace/workspace_idea/allTypes_readXmlJsonProperties/_01Simple/target/classes/
     */
    private static void ClassLoad_VS_Class_getPath() {
        String classGetResource = ReadResource.class.getResource("/").getPath();
        String classLoadGetResource = ReadResource.class.getClassLoader().getResource("").getPath();
        logger.info(
                "\n"
                        + "classGetResource default path: " + classGetResource
                        + "\n"
                        + "classLoadGetResource default path: " + classLoadGetResource);
    }

    /**
     * a）class.getClassLoader().getResourceAsStream(String name)
     * 默认从classpath中找文件(文件放在resources目录下)
     * ，name不能带"/"，否则会抛空指针。采用相对路径, "/"就相当于当前进程的根目录，即项目根目录；
     * @throws IOException
     *
     *  properties/test.properties  的内容
    name = laoli
    logName = org.apache.log4j.FileAppender
    logFile = ./log_log4j/logFile.log
     *
     */
    private static void ClassLoaderGetResource() throws IOException {
        InputStream in = ReadResource.class.getClassLoader().getResourceAsStream("properties/test.properties");
        Properties properties = new Properties();
        properties.load(in);
        String name = properties.getProperty("name");
        logger.info("name is :"+ name );
    }

    /**
     * b）class.getResourceAsStream(String name) 是采用绝对路径，
     * 绝对路径是相对于 classpath 根目录的路径，"/" 就代表着 classpath，所以 name 属性需要前面加上 "/"；
     * @throws IOException
     */
    private static void GetResource() throws IOException {
        InputStream in = ReadResource.class.getResourceAsStream("/properties/test.properties");
        Properties properties = new Properties();
        properties.load(in);
        String name = properties.getProperty("name");
        logger.info("name is :"+ name );
    }

    /**
     * file:/C:/workspace/workspace_idea/allTypes_readXmlJsonProperties/_01Simple/target/classes/
     * C:\workspace\workspace_idea\allTypes_readXmlJsonProperties
     */
    private static void GetPathM3() {
        java.net.URL uri = ReadResource.class.getResource("/");
        logger.info(uri.toString());

        String property =System.getProperty("user.dir");
        logger.info(property);
    }

    /**
     *  C:\workspace\workspace_idea\allTypes_readXmlJsonProperties
     * @throws IOException
     */
    private static void GetPathM2() throws IOException {
        File directory = new File("");   //参数为空
        String canonicalPath = directory.getCanonicalPath();// 标准路径
        String absolutePath = directory.getAbsolutePath();// 绝对路径
        logger.info( "canonicalPath" );
        logger.info(canonicalPath);
        logger.info("absolutePath");
        logger.info(absolutePath);
    }

    /**
     *
     *  path:  /C:/workspace/workspace_idea/allTypes_readXmlJsonProperties/_01Simple/target/classes/product4FileReader.txt
     : file:  /C:/workspace/workspace_idea/allTypes_readXmlJsonProperties/_01Simple/target/classes/product4FileReader.txt
     */
    private static void GetResourceM1() {
        String path = ReadResource.class.getClassLoader().getResource("product4FileReader.txt").getPath();
         String file = ReadResource.class.getClassLoader().getResource("product4FileReader.txt").getFile();
        //String file = "";

                logger.info( "\n path:  "+ path +" \n  : file:  "+file);
    }


}
