package com.study.common;

import com.study.common.type.JsonType;
import lombok.*;

/**
 * @Author: yuqi
 * @Date: 2020-03-06 17:58
 */
@Getter
@Setter
@ToString
public class Result {

    int id;

    JsonType status;
}
