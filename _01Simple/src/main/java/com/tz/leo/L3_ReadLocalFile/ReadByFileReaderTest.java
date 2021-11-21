package com.tz.leo.L3_ReadLocalFile;

import org.omg.CORBA_2_3.portable.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Author: tz_wl
 * Date: 2020/8/13 11:39
 * Content:  读取本地文件
 *
 * new BufferedReader( )
 *                    new FileReader( )
 *                                    new File( )
 *
 BufferedReader bufferedReader =new BufferedReader(fileReader);
                                       FileReader fileReader =new FileReader(file);
                                                                        File file=new File(fileName);
 */
public class ReadByFileReaderTest {
    private static Logger logger = LoggerFactory.getLogger(ReadByFileInpuStream.class);

    public static void main(String[] args) throws IOException {
        ReadLocalFile();
       // clazzOfIO();
    }

    /**
     * ReadByFileReaderTest.class.getResource("/product4FileReader.txt").getPath();
     /C:/workspace/workspace_idea/allTypes_readXmlJsonProperties/_01Simple/target/classes/product4FileReader.txt
     product01
     product02
     product03
     product04

     *                                                      String   path
     *                                             file =  File (path)
     *                             fileReader = new FileReader(file);
     *         bufferedReader = new BufferedReader(fileReader);
     * @throws IOException
     */
    private static void ReadLocalFile() throws IOException {
        //String filePath ="D://E//TEMP//product4FileReader.txt";
        String filePath = ReadByFileReaderTest.class.getResource("/product4FileReader.txt").getPath();
        logger.info(filePath);
        File file=new File(filePath);
        if( file.isFile() && file.exists()) {
            Reader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String strTemp = "";
            while ((strTemp = bufferedReader.readLine()) != null) {
                System.out.println(strTemp);
            }
            //注意关闭流
            bufferedReader.close();
            fileReader.close();
        }
    }


    private static void clazzOfIO() {
        Writer wr;
        StringWriter str;
        CharArrayWriter charArrayWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter;
        OutputStreamWriter outputStreamWriter;

        OutputStream outputStream;
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        FilterOutputStream filterOutputStream;
        PrintStream printStream;
        DataOutputStream dataOutputStream;
        BufferedOutputStream bufferedOutputStream;
        PipedOutputStream pipedOutputStream;

        Reader reader;
        StringReader stringReader;
        CharArrayReader charArrayReader;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        FileReader fileReader;
        PipedReader pipedReader;
        BufferedReader bufferedReader1;
        FilterReader filterReader;
        File file1;

        InputStream inputStream;
        FileInputStream fileInputStream;
        ByteArrayInputStream byteArrayInputStream;
        SequenceInputStream sequenceInputStream;
        ObjectInputStream objectInputStream;
        FilterInputStream filterInputStream;
        DataInputStream dataInputStream;
        BufferedInputStream bufferedInputStream;
        StringBufferInputStream stringBufferInputStream;
        PipedInputStream pipedInputStream;

        java.util.zip.ZipInputStream stream;

        OutputStreamWriter outputStreamWriter1;
    }

}
