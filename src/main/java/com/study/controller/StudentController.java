package com.study.controller;

import com.study.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Resource
    StudentService studentService;

    @GetMapping("/student")
    public String studentManage(Model model) {
        model.addAttribute("student_list",studentService.getStudentList());
        return "/students";
    }

    @PostMapping("/student_search")
    public String studentSearch(@RequestParam("studentInfo") String name, Model model) {
        model.addAttribute("student_list",studentService.getSelectStudents(name));
        return "/selectStudent";
    }



}
