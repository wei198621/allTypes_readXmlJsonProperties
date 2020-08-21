package com.tz.leo.JsonObject03;

import com.alibaba.fastjson.JSON;
import com.tz.leo.JsonObject03.beans.Cmd81Bean;
import com.tz.leo.JsonObject03.beans.TimeBean;
import com.tz.leo.JsonObject03.util.util01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/**
 * Author: tz_wl
 * Date: 2020/8/21 17:24
 * Content:
 */
public class mainTest {

    public static void main(String[] args) throws IOException {



        System.out.println("=====================001======================");


        // System.out.println("true = " + true);
        InputStream inputStream = mainTest.class.getResourceAsStream("/originalData81.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = bufferedReader.readLine();

        //转换为json字符串
        System.out.println("=====================01======================");
        String strJson = util01.parse2JsonStr(str);
        System.out.println("strJson = " + strJson);

        //str 转换为 Array
        System.out.println("=====================02======================");
        List<Cmd81Bean> cmd81List = JSON.parseArray(strJson, Cmd81Bean.class);
        System.out.println("cmd81List = " + cmd81List);

        //按照  getTimeList.size() 倒叙排序后  取第一个记录
        System.out.println("======================03    =================");
        Optional<Cmd81Bean> first = cmd81List.stream().sorted().findFirst();
        System.out.println("first = " + first);

        //打印原始数据
        System.out.println("======================04=====================");
        List<TimeBean> timeListOriginal = first.get().getTimeList();
        System.out.println("原始数据 = " +  timeListOriginal);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        //打印处理后数据
        System.out.println("======================05=====================");
        List<TimeBean> dateTimeJsons = util01.dateTimeFilter(timeListOriginal);
        System.out.println("处理后数据 = " +  dateTimeJsons);
    }

}
