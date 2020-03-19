package com.zjx.service;

import com.codingapi.txlcn.common.util.Maps;
import com.codingapi.txlcn.tc.core.transaction.txc.analy.def.PrimaryKeysProvider;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/19 15:03
 * @Version V1.0
 **/
@Component
public class MysqlPrimaryKeysProvider implements PrimaryKeysProvider {

    @Override
    public Map<String, List<String>> provide() {
        return Maps.of("t_demo", Collections.singletonList("kid"));
    }
}