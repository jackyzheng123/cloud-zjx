package com.zjx;

import com.zjx.dto.CommodityDTO;
import com.zjx.mapper.CommodityMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/26 12:13
 * @Version V1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CommoditySeataApplication.class)
public class CommodityMapperTest {

    @Autowired
    private CommodityMapper commodityMapper;

    @Test
    public void findCommodityTest() {
        final CommodityDTO dto = commodityMapper.findCommodity("TB001");
        System.out.println(dto.toString());
    }
}
