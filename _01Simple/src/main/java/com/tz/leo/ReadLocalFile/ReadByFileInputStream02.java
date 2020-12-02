package com.tz.leo.ReadLocalFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Author: tz_wl
 * Date: 2020/8/13 14:21
 * Content:    还是会有 字符集的问题  me":"通� �产品组","groupcode":
 * new BufferedInputStream(  )
 *                         new FileInpuStream( )
 */
public class ReadByFileInputStream02 {
    public static void main(String[] args) throws IOException {

        //java.io.FileInputStream
        //java.io.BufferedInputStream

        String fileName="D://temp//tempdata//product4FileReader.txt";
        String encoding="utf-8";
        InputStream inputStream = new FileInputStream(fileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = new byte[1024];
        int len=0;
        while((len=bufferedInputStream.read(bytes))!=-1){
            String str = new String(bytes,0,len, Charset.forName(encoding));
            System.out.println(str);
        }
        bufferedInputStream.close();
        inputStream.close();
    }
}
