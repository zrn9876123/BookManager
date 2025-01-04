package com.study.controller;

import com.study.service.PublisherService;
import com.study.service.impl.PublisherServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PublisherController {
    @Resource
    PublisherService service;

    @GetMapping("/publisher")
    public String publisher(Model model) {
        model.addAttribute("publisher_list",service.getPublishers());
        return "/publishers";
    }

    @PostMapping("/publisher_search")
    public String publisher_search(@RequestParam("publisherInfo") String name, Model model) {
        model.addAttribute("publisher_list",service.getSelectPublishers(name));
        return "/selectPublisher";
    }

}
