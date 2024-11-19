package com.study.mapper;

import com.study.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("select count(sid) from student")
    int getStudentCount();

    @Select("select * from student")
    List<Student> getStudentList();

    @Select("select * from student where name like(concat('%',#{name},'%'))")
    List<Student> getSelectStudents(String name);
}
