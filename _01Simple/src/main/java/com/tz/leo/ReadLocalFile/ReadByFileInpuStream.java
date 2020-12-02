package com.tz.leo.ReadLocalFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * https://my.oschina.net/u/2489258/blog/727245
 * Author: tz_wl
 * Date: 2020/8/13 13:46
 * Content:
 * new BufferedReader(    )
 *                    new InputStreamReader(  )
 *                                           new InputStream()
 * BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
 * str= bufferedReader.readLine()
 */
public class ReadByFileInpuStream {
    public static void main(String[] args) throws IOException {
        //java.io.InputStream
        //java.io.FileInputStream
        //java.io.InputStreamReader
        //java.io.BufferedReader

        InputStreamReader01();

    }

    private static void InputStreamReader01() throws IOException {
        String fileName="D://temp//tempdata//product4FileReader.txt";
        String encoding="utf-8";
        File file = new File(fileName);
        if(file.isFile() && file.exists()) {
            String strTmp = "";     //临时变量
            StringBuilder stringBuilder = new StringBuilder();   //
            InputStream inputStream = new FileInputStream(file);
            Reader inputStreamReader = new InputStreamReader(inputStream,encoding);  //如果需要进行编码
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((strTmp = bufferedReader.readLine()) != null) {
                stringBuilder.append(strTmp);
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder.toString());
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        }
    }
}
