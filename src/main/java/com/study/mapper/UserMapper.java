package com.study.mapper;

import com.study.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User getUserByName(String username);

}
