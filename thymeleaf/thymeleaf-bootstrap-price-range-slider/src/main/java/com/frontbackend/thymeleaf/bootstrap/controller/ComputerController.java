package com.frontbackend.thymeleaf.bootstrap.controller;

import com.frontbackend.thymeleaf.bootstrap.model.Computer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.frontbackend.thymeleaf.bootstrap.model.PriceRange;
import com.frontbackend.thymeleaf.bootstrap.service.ComputerService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ComputerController {

    private final ComputerService computerService;

    @GetMapping
    public String filterProducts(PriceRange priceRange, Model model) {
        model.addAttribute("products", computerService.filterProducts(priceRange.getMin(), priceRange.getMax()));
        return "products";
    }

    @ResponseBody
    @PostMapping("/addPhoto/{id}")
    public Computer addPicture(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws IOException {
        Computer computer = computerService.getById(id);
        computer.setPicture(Base64.getEncoder().encodeToString(file.getBytes()));
        return computerService.saveComputer(computer);
    }

}
