package com.study.service;

import com.study.entity.Student;

import java.util.List;

public interface StudentService {
    int getStudentCount();
    List<Student> getStudentList();
    List<Student> getSelectStudents(String name);
}
