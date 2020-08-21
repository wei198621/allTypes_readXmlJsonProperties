package com.tz.leo.JsonObject03.util;


import com.tz.leo.JsonObject03.beans.TimeBean;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/21 17:56
 * Content:
 */
public class util01 {


    public  static String parse2JsonStr(String str){
        //转换为json字符串
        String strReturn = str
                .replace("{","\"{\"")
                .replace("}","\"}\"")
                .replace(",","\",\"")
                .replace("=","\"=\"")
                .replace("\" ","\"")
                .replace("\"\"","\"")
                .replace("\"\"{","{")
                .replace("}\"\"","}")
                .replace("[\"{","[{")
                .replace("\"[","[")
                .replace("\"]","]")
                .replace("]\"","]")
                .replace("}\"","}")
                .replace("\"{","{")
                .replace("=",":")
                ;
        return strReturn;
    }




    /**
    *@Description: 时间过滤函数
    *@Param:
    *@return:
    *@date: 2020/8/21
    */
    public static List<TimeBean> dateTimeFilter(List<TimeBean> dateTimeJsonList){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<TimeBean> returnList = new ArrayList<>();
        for(int i=0;i<dateTimeJsonList.size();i++){
            TimeBean tmpJsonBefore;                       //上一条记录
            TimeBean tmpJsonCurrent=new TimeBean();   //当前记录
            if(i==0){
                tmpJsonCurrent=dateTimeJsonList.get(i);
            }else if(i>=1){
                tmpJsonBefore=dateTimeJsonList.get(i-1);
                tmpJsonCurrent=dateTimeJsonList.get(i);

                LocalDateTime dateTimeBefore = LocalDateTime.parse(tmpJsonBefore.getStartTime(), formatter);
                LocalDateTime dateTimeCurrent = LocalDateTime.parse(tmpJsonCurrent.getStartTime(), formatter);

                //当前记录时间小于上一条记录时间的 不记录当前记录  可能扩展以后
                if(dateTimeBefore.isAfter(dateTimeCurrent)){
                    continue;
                }
            }else {

            }
            returnList.add(tmpJsonCurrent);
        }
        return returnList;
    }

}
