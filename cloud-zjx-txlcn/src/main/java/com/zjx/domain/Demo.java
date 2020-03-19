package com.zjx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.math.RandomUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/19 10:45
 * @Version V1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Demo {
    private Long id;
    private String kid = UUID.randomUUID().toString().replace("-", "");
    private String demoField;
    private String groupId;
    private Date createTime;
    private String appName;

}