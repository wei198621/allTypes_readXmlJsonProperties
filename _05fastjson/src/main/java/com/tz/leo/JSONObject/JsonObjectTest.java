package com.tz.leo.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Author: tz_wl
 * Date: 2020/8/13 10:35
 * Content:
 */
public class JsonObjectTest {
    public static void main(String[] args) {
        JSONObject jsonObject = getJsonObject();
        String retString = retString(jsonObject);
        System.out.println("json string is ： "+ retString);

    }

    /**
    *@Description: 通过 alibaba.fastjson 设置实例对象
    *@Param: 
    *@return: 
    *@date: 2020/8/13
    */
    private static JSONObject getJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",123);
        jsonObject.put("name","lilei");
        jsonObject.put("age",18);
        return jsonObject;
    }

    /**
    *@Description:  JsonObject 转 string  
    *@Param: 
    *@return: 
    *@date: 2020/8/13
    */
    private static String retString(JSONObject object){
        String jsonStr="";
        jsonStr= JSON.toJSONString(object);
        return jsonStr;
    }






}
