package com.study.common.type;

import lombok.Getter;

/**
 * @Author: yuqi
 * @Date: 2020-03-06 17:29
 */
public enum JsonType {

    FAST_JSON(1,"fast"),G_JSON(2,"g"),JACKSON(3,"jack");

    int value;

    String tag;

    JsonType(int value, String tag){
        this.value = value;
        this.tag = tag;
    }
}
