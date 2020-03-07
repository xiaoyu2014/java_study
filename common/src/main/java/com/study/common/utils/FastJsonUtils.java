package com.study.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.study.common.Result;
import com.study.common.type.JsonType;

/**
 * @Author: yuqi
 * @Date: 2020-03-06 17:19
 */
public class FastJsonUtils {

    public static <T> T fromJson(String json, Class<T> classType){

        return JSON.parseObject(json, classType);
    }

    public static String toJson(Object o){

        return JSON.toJSONString(o);
    }

    public static  <T> T fromJson(String json, TypeReference<T> reference){
        return JSON.parseObject(json, reference);
    }

    public static void main(String[] args) {

        String json = "{\"id\":10000,\"status\":0}";

        Result result= fromJson(json, Result.class);

        System.out.println(result);

        System.out.println(toJson(result));
    }
}
