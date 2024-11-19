package com.study.service.impl;

import com.study.entity.Student;
import com.study.mapper.StudentMapper;
import com.study.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public int getStudentCount() {
        return studentMapper.getStudentCount();
    }

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }

    @Override
    public List<Student> getSelectStudents(String name) {
        return studentMapper.getSelectStudents(name);
    }


}
