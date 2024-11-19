package com.study.controller;

import com.study.entity.Book;
import com.study.service.BookService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Resource
    BookService bookService;

    @GetMapping("/bookManage")
    public String bookManage(Model model) {
        model.addAttribute("books_list",bookService.getBookList());
        return "/books";
    }

    @GetMapping("/add_book")
    public String addBook() {
        return "/addBook_form";
    }

    @PostMapping("/add_book")
    public String addBook(HttpServletRequest req) {
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        double price = Double.parseDouble(req.getParameter("price"));
        bookService.insertBook(title, desc, price);

        return "redirect:/bookManage";
    }

    @GetMapping("/delete_book")
    public String deleteBook(HttpServletRequest req) {
        int bid = Integer.parseInt(req.getParameter("bid"));
        bookService.deleteBook(bid);
        return "redirect:/bookManage";
    }

    @PostMapping("/search_book")
    public String searchBook(HttpServletRequest req,Model model) {
        String title = req.getParameter("bookTitle");
        List<Book> books = bookService.searchBook(title);
        model.addAttribute("books_list", books);
        return "/selectBook";
    }


}
