package com.tz.leo.JSONObject02;

import com.alibaba.fastjson.JSON;
import com.tz.leo.JSONObject02.entities.User;

/**
 * Author: tz_wl
 * Date: 2020/8/13 10:35
 * Content:
 */
public class JsonObjectTest02 {
    public static void main(String[] args) {
        getJsonObject();
        System.out.println("==========================================");
        getJsonObject2();
    }



    /**
    *@Description:  使用 com.alibaba.fastjson.JSON;  打印字符串
    *@Param:
    *@return:
    *@date: 2020/8/13
    */
    private static void getJsonObject() {
        String data = "{\"id\":\"2222\",\"name\":\"LiLei\",\"age\":\"33\"  }";
        Object o = JSON.toJSON(data);
        System.out.println(data);
        System.out.println(o);
    }


    /**
    *@Description:   字符串转 对象
    *@Param:
    *@return:
    *@date: 2020/8/13
    */
    private static void getJsonObject2() {
        String strUser = "{\"id\":\"2222\",\"name\":\"LiLei\",\"age\":\"33\"  }";
        System.out.println(strUser);
        User objUser =  JSON.parseObject(strUser,User.class);
        System.out.println(objUser);
        System.out.println("JSON.parseObject 转换成功 ， age is :"+objUser.getAge());
    }



}
