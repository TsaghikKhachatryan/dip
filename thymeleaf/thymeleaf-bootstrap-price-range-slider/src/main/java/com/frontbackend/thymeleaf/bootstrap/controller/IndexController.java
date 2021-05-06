package com.frontbackend.thymeleaf.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontbackend.thymeleaf.bootstrap.model.PriceRange;
import com.frontbackend.thymeleaf.bootstrap.service.ComputerService;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    private final ComputerService computerService;

    @Autowired
    public IndexController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("priceRange", new PriceRange(5, 100000));
        model.addAttribute("products", computerService.getAllComputers());
        return "index";
    }

    @PostMapping
    public String save(PriceRange priceRange, Model model) {
        model.addAttribute("range", priceRange);
        return "saved";
    }
}