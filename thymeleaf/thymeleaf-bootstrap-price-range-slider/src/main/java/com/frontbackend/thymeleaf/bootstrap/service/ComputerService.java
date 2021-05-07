package com.frontbackend.thymeleaf.bootstrap.service;

import java.util.List;
import java.util.stream.Collectors;

import com.frontbackend.thymeleaf.bootstrap.model.Computer;
import com.frontbackend.thymeleaf.bootstrap.repo.ComputerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ComputerService {

    private final ComputerRepo repo;

    public List<Computer> filterProducts(int min, int max) {
        List<Computer> list =  getAllComputers().stream()
                .filter(computer -> computer.getPrice() >= min && computer.getPrice() <= max)
                .collect(Collectors.toList());
        return list;
    }

    public List<Computer> getAllComputers() {
        return (List<Computer>) repo.findAll();
    }

    public Computer getById(Long id) {
        return repo.findById(id).get();
    }

    public Computer saveComputer(Computer computer) {
        return repo.save(computer);
    }
}
