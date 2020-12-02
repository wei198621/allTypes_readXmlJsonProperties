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
 *
 BufferedReader bufferedReader =new BufferedReader(fileReader);
                                       FileReader fileReader =new FileReader(file);
                                                                        File file=new File(fileName);
 */
public class ReadByFileReaderTest {
    public static void main(String[] args) throws IOException {
        //java.io.File;
        //java.io.FileReader
        //java.io.BufferedReader

        String fileName="D://temp//tempdata//product4FileReader.txt";
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
