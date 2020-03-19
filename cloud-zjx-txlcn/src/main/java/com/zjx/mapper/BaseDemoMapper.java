package com.zjx.mapper;

import com.zjx.domain.Demo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/19 10:48
 * @Version V1.0
 **/
@Mapper
public interface BaseDemoMapper {

    @Insert("insert into t_demo(kid, demo_field, group_id, create_time,app_name) values(#{kid}, #{demoField}, #{groupId}, #{createTime},#{appName})")
    void save(Demo demo);

    @Delete("delete from t_demo where id=#{id}")
    void deleteByKId(Long id);
}