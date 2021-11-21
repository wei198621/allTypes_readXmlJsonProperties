package com.tz.leo.L1_simpleIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author leowei
 * @date 2021/11/21  - 15:30
 */
public class _01getkey {

    private static String filePath ="D://E//TEMP//product4FileReader.txt";

    public static void main(String[] args) throws IOException {
        _01getkey getkey=new _01getkey();
        getkey.cs();
    }

    public void cs() throws IOException {
        OutputStream outputStream = new FileOutputStream(filePath);
        byte[] a = new byte[1024];
        int m;
        while((m=System.in.read(a))!=-1){
            String str=new String(a,0,m);
            if("e".equals(str.trim())){
                break;
            }
            outputStream.write(m);
        }
    }


}
