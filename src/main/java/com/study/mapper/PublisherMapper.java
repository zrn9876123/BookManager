package com.study.mapper;

import com.study.entity.Publisher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PublisherMapper {

    @Select("select * from publisher")
    List<Publisher> getPublisher();

    @Select("select * from publisher where name like(concat('%',#{name},'%'))")
    List<Publisher> getSelectPublisher(String name);
}
