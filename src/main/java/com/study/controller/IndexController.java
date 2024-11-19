package com.study.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

@Controller
public class IndexController {

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        Boolean failure = request.getParameter("failure") != null;
        model.addAttribute("failure",failure);
        return "login";
    }

}
