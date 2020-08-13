package com.tz.leo.ReadLocalFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Author: tz_wl
 * Date: 2020/8/13 11:39
 * Content:  读取本地文件
 *
 * new BufferedReader( )
 *                    new FileReader( )
 *                                    new File( )
 * 本地磁盘放置文件  E://tempData//productType20200408.txt
 * String fileName="E://tempData//productType20200408.txt";
 File file=new File(fileName);
 FileReader fileReader =new FileReader(file);
 BufferedReader bufferedReader =new BufferedReader(fileReader);
 strTemp=bufferedReader.readLine()
 System.out.println(strTemp);
 */
public class ReadByFileReaderTest {
    public static void main(String[] args) throws IOException {
        //java.io.File;
        //java.io.FileReader
        //java.io.BufferedReader

        String fileName="E://tempData//productType20200408.txt";
        File file=new File(fileName);
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
}
