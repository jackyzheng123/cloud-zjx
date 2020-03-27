package com.zjx.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 账户
 * @Author Carson Cheng
 * @Date 2020/3/24 11:17
 * @Version V1.0
 **/
@Data
public class AccountDTO implements Serializable {

    private String userId;

    private BigDecimal money;

}
