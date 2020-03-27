package com.zjx.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: heshouyou
 * @date: 2018-07-03 16:55
 */
@Data
public class ObjectResponse<T> extends BaseResponse implements Serializable {

    private T data;

}