package com.study.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.common.Result;

/**
 * @Author: yuqi
 * @Date: 2020-03-06 17:35
 */
public class JacksonUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper() ;

    public static <T> T fromJson(String json, Class<T> classType) throws Exception{

        return objectMapper.readValue(json, classType);
    }

    public static String toJson(Object o) throws Exception{

        return objectMapper.writeValueAsString(o);
    }

    public static void main(String[] args) throws Exception{

        String json = "{\"id\":10000,\"status\":0}";

        Result result= fromJson(json, Result.class);

        System.out.println(result);

        System.out.println(toJson(result));
    }

}
