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
@RequestMapping({"/", "/index"})
public class IndexController {

    private final ComputerService computerService;

    @Autowired
    public IndexController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping
    public String main(Model model) {

        return "index";
    }


    @PostMapping
    public String save(PriceRange priceRange, Model model) {
        model.addAttribute("range", priceRange);
        return "saved";
    }


    @GetMapping("/contact")
    public String getContacts() {
        return "contact";
    }

    @GetMapping("/special")
    public String getSales() {
        return "special";
    }

    @GetMapping("/brand")
    public String getBrand(Model model) {
        model.addAttribute("priceRange", new PriceRange(5, 100000));
        model.addAttribute("products", computerService.getAllComputers());
        return "brand";
    }

    @GetMapping("/about")
    public String getAboutInfo() {
        return "about";
    }
}