package com.study.controller;

import com.study.service.BookService;
import com.study.service.StudentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BorrowController {

    @Resource
    BookService bookService;
    @Resource
    StudentService studentService;

    @GetMapping(path = {"/borrow"})
    public String borrowInfo(Model model) {
        model.addAttribute("borrow_list",bookService.getBorrowList());
        model.addAttribute("student_count",studentService.getStudentCount());
        model.addAttribute("book_turnover",bookService.getTurnover());
        model.addAttribute("book_count",bookService.getBookCount());

        return "index";
    }

    @GetMapping("/addBorrowInfo")
    public String addBorrowInfo(Model model) {

        model.addAttribute("book_list",bookService.getAvailableBookList());
        model.addAttribute("student_list",studentService.getStudentList());

        return "/addBorrow_form";
    }

    @PostMapping("/addBorrowInfo")
    public String addBorrowInfo(HttpServletRequest request) {
        int bid = Integer.parseInt(request.getParameter("bid"));
        int sid = Integer.parseInt(request.getParameter("sid"));
        bookService.addBorrowInfo(bid,sid);

        return "redirect:/borrow";
    }

    @GetMapping("/borrow_delete")
    public String deleteBorrowInfo(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        bookService.deleteBorrowInfoById(id);
        return "redirect:/borrow";
    }

}
